package com.union.app.service.pk.service;

import com.mchange.v1.lang.BooleanUtils;
import com.union.app.common.OSS存储.CacheStorage;
import com.union.app.common.OSS存储.OssStorage;
import com.union.app.common.config.AppConfigService;
import com.union.app.dao.spi.AppDaoService;
import com.union.app.dao.spi.filter.CompareTag;
import com.union.app.dao.spi.filter.EntityFilterChain;
import com.union.app.domain.pk.*;
import com.union.app.common.id.KeyGetter;
import com.union.app.domain.pk.apply.ApproveCode;
import com.union.app.domain.pk.apply.KeyNameValue;
import com.union.app.domain.user.User;
import com.union.app.domain.工具.RandomUtil;
import com.union.app.entity.ImgStatu;
import com.union.app.entity.pk.*;
import com.union.app.entity.pk.apply.PayOrderEntity;
import com.union.app.entity.pk.助力浏览评论分享.UserLikeEntity;
import com.union.app.plateform.constant.常量值;
import com.union.app.plateform.data.resultcode.AppException;
import com.union.app.plateform.data.resultcode.Level;
import com.union.app.plateform.data.resultcode.PageAction;
import com.union.app.plateform.storgae.redis.RedisStringUtil;
import com.union.app.service.pk.dynamic.DynamicService;
import com.union.app.service.user.UserService;
import com.union.app.util.idGenerator.IdGenerator;
import com.union.app.util.time.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PostService {


    @Autowired
    AppDaoService daoService;

    @Autowired
    DynamicService dynamicService;

    @Autowired
    UserService userService;

    @Autowired
    RedisStringUtil redisStringUtil;

    @Autowired
    OssStorage ossStorage;

    @Autowired
    CacheStorage cacheStorage;


    @Autowired
    PkService pkService;






    public String 创建帖子(String pkId,String userId,String title,List<String> images) throws IOException, AppException
    {

        String postId = IdGenerator.getPostId();
        PostEntity postEntity = new PostEntity();

        postEntity.setPkId(pkId);
        postEntity.setPostId(postId);
        postEntity.setUserId(userId);
        postEntity.setTopic(title.getBytes(Charset.forName("UTF-8")));
        postEntity.setImgNum(images.size());
        postEntity.setCreateTime(TimeUtils.currentTime());
        postEntity.setLastModifyTime(TimeUtils.currentTime());
        postEntity.setStatu(PostStatu.上线);
        for(String img:images){
            PostImageEntity postImageEntity = new PostImageEntity();
            postImageEntity.setPkId(pkId);
            postImageEntity.setPostId(postId);
            postImageEntity.setImgUrl(getLegalImgUrl(img));
            postImageEntity.setImgId(IdGenerator.getImageId());
            postImageEntity.setCreateTime(TimeUtils.currentTime());
            daoService.insertEntity(postImageEntity);
        }

        daoService.insertEntity(postEntity);

        PkDynamicEntity pkDynamicEntity = pkService.查询PK动态表(pkId);
        pkDynamicEntity.setPostNum(pkDynamicEntity.getPostNum() + 1);

        daoService.updateEntity(pkDynamicEntity);


        return postId;
    }

    private String getLegalImgUrl(String image) {
        String reg1 = "\\[";
        String reg2 = "]";
        String reg3 = "\"";
        image = image.replaceAll(reg3,"").replaceAll(reg1,"").replaceAll(reg2,"").trim();
        return image;
    }

//    public Post 查询帖子(String postId,String queryerId) throws UnsupportedEncodingException {
//
//        Post post = new Post();
//
//        PostEntity postEntity = getPostEntityById(postId);
//
//        if((!StringUtils.isEmpty(queryerId)) && (!org.apache.commons.lang.StringUtils.equals(postEntity.getUserId(),queryerId))){
//
//            post.setQueryerCollect(isUserCollectPost(postId,queryerId));
//
//        }
//
//        post.setPkId(postEntity.getPkId());
//        post.setPostId(postEntity.getPostId());
//        post.setCreator(userService.queryUser(postEntity.getUserId()));
//        post.setTopic(new String(postEntity.getTopic(),"UTF-8"));
//        post.setDynamic(getPostDynamic(postEntity.getPostId(),postEntity.getPkId()));
//        post.setPostImages(getPostImages(postEntity.getPostId(),postEntity.getPkId()));
//        post.setStatu(new KeyNameValue(postEntity.getStatu().getStatu(),postEntity.getStatu().getStatuStr()));
//        return post;
//    }

    public Post 查询帖子(String pkId,String postId,String queryerId) throws UnsupportedEncodingException {

        PostEntity postEntity = this.查询帖子ById(pkId,postId);
        if(ObjectUtils.isEmpty(postEntity)){return null;}
        Post post = translate(postEntity);
        if((!StringUtils.isEmpty(queryerId)) && (!org.apache.commons.lang.StringUtils.equals(postEntity.getUserId(),queryerId))){
            post.setQueryerCollect(isUserCollectPost(postId,queryerId));
        }
        return post;
    }


    public Post translate(PostEntity postEntity) throws UnsupportedEncodingException {
        Post post = new Post();
        post.setPkId(postEntity.getPkId());
        post.setPostId(postEntity.getPostId());
        post.setCreator(userService.queryUser(postEntity.getUserId()));
        post.setTopic(new String(postEntity.getTopic(),"UTF-8"));
        post.setDynamic(getPostDynamic(postEntity.getPostId(),postEntity.getPkId()));
        post.setPostImages(getPostImages(postEntity.getPostId(),postEntity.getPkId()));
        post.setStatu(new KeyNameValue(postEntity.getStatu().getStatu(),postEntity.getStatu().getStatuStr()));
        return post;
    }




    private List<PostImage> getPostImages(String postId, String pkId) {
        List<PostImage> postImages = new ArrayList<>();

        EntityFilterChain filter = EntityFilterChain.newFilterChain(PostImageEntity.class)
                .compareFilter("postId",CompareTag.Equal,postId)
                .andFilter()
                .compareFilter("pkId",CompareTag.Equal,pkId);
        List<PostImageEntity> postImageEntities = daoService.queryEntities(PostImageEntity.class,filter);

        for(PostImageEntity postImageEntity:postImageEntities){
            PostImage postImage = new PostImage();
            postImage.setImgUrl(postImageEntity.getImgUrl());
            postImage.setImageId(postImageEntity.getImgId());
            postImage.setTime(postImageEntity.getCreateTime());
            postImages.add(postImage);
        }
        return postImages;
    }


    private PostDynamic getPostDynamic(String postId, String pkId) {

        return new PostDynamic();
    }




    public PostEntity 查询用户帖(String pkId, String userId) {
        EntityFilterChain filter = EntityFilterChain.newFilterChain(PostEntity.class)
                .compareFilter("pkId",CompareTag.Equal,pkId)
                .andFilter()
                .compareFilter("userId",CompareTag.Equal,userId);
        PostEntity postEntity = daoService.querySingleEntity(PostEntity.class,filter);
        return postEntity;
    }


    public Post 查询用户帖子(String pkId, String userId) throws UnsupportedEncodingException {

            PostEntity userPostEntity = 查询用户帖(pkId,userId);
            if(ObjectUtils.isEmpty(userPostEntity)){
                return null;
            }
            else {
                return this.translate(userPostEntity);
            }
    }




    public boolean 帖子是否存在(String postId) {
        String detail = KeyGetter.Post的Key(PostPart.POST信息,postId);
        if(!ossStorage.isKeyExist(detail)){return false;}
        return true;
    }


    public void 删除帖子指定图片(String postId, String imgId, String userId) throws AppException {
        EntityFilterChain filter = EntityFilterChain.newFilterChain(PostEntity.class)
                .compareFilter("postId",CompareTag.Equal,postId);
        PostEntity postEntity = daoService.querySingleEntity(PostEntity.class,filter);
        if(!org.apache.commons.lang.StringUtils.equals(postEntity.getUserId(),userId)){
            throw AppException.buildException(PageAction.信息反馈框("操作异常","您无权删除用户图片"));
        }

        EntityFilterChain filter1 = EntityFilterChain.newFilterChain(PostImageEntity.class)
                .compareFilter("imgId",CompareTag.Equal,imgId)
                .andFilter()
                .compareFilter("postId",CompareTag.Equal,postId);
        PostImageEntity postImageEntity = daoService.querySingleEntity(PostImageEntity.class,filter1);
        if(ObjectUtils.isEmpty(postImageEntity)){return;}
        postEntity.setImgNum(postEntity.getImgNum() - 1);

        daoService.deleteEntity(postImageEntity);
        daoService.updateEntity(postEntity);

    }

    public void 续传帖子(String postId, String title, String userId, List<String> images) throws AppException, UnsupportedEncodingException {

        EntityFilterChain filter = EntityFilterChain.newFilterChain(PostEntity.class)
                .compareFilter("postId",CompareTag.Equal,postId);
        PostEntity postEntity = daoService.querySingleEntity(PostEntity.class,filter);
        if(!org.apache.commons.lang.StringUtils.equals(postEntity.getUserId(),userId)){
            throw AppException.buildException(PageAction.信息反馈框("操作异常","您无权续传用户图片"));
        }


        postEntity.setLastModifyTime(TimeUtils.currentTime());
        String oldTitle = new String(postEntity.getTopic(),Charset.forName("UTF-8"));
        if(!StringUtils.isEmpty(title)) {
            postEntity.setTopic(org.apache.commons.lang.StringUtils.equals(title, oldTitle) ? postEntity.getTopic() : title.getBytes("UTF-8"));
        }
        for(String img:images){
            PostImageEntity postImageEntity = new PostImageEntity();
            postImageEntity.setPkId(postEntity.getPkId());
            postImageEntity.setPostId(postId);
            postImageEntity.setImgUrl(getLegalImgUrl(img));
            postImageEntity.setImgId(IdGenerator.getImageId());
            postImageEntity.setCreateTime(TimeUtils.currentTime());
            daoService.insertEntity(postImageEntity);
        }
        postEntity.setImgNum(postEntity.getImgNum() + images.size());
        daoService.updateEntity(postEntity);



    }

    public Post 查询类型帖子(String pkId, String userId, int type, int page) throws AppException, UnsupportedEncodingException {

        String creator = pkService.querySinglePkEntity(pkId).getUserId();
        if(!org.apache.commons.lang.StringUtils.equals(userId,creator)){throw AppException.buildException(PageAction.消息级别提示框(Level.错误消息,"非法操作"));}


        Post post = new Post();


        PostEntity postEntity = this.查询下一个PostEntity(pkId,type,page);
        if(org.springframework.util.ObjectUtils.isEmpty(postEntity))
        {
            post.setStatu(new KeyNameValue(PostStatu.无内容.getStatu(), PostStatu.无内容.getStatuStr()));
        }
        else
        {
            post.setPkId(postEntity.getPkId());
            post.setPostId(postEntity.getPostId());
            post.setCreator(userService.queryUser(postEntity.getUserId()));
            post.setTopic(new String(postEntity.getTopic(),"UTF-8"));
            post.setDynamic(getPostDynamic(postEntity.getPostId(),postEntity.getPkId()));
            post.setPostImages(getPostImages(postEntity.getPostId(),postEntity.getPkId()));
            post.setStatu(new KeyNameValue(postEntity.getStatu().getStatu(), postEntity.getStatu().getStatuStr()));
        }


        return post;

    }

    private PostEntity 查询下一个PostEntity(String pkId, int type, int page) {
        EntityFilterChain filter = null;
        if(type == PostStatu.上线.getStatu()){
            filter = EntityFilterChain.newFilterChain(PostEntity.class)
                    .compareFilter("pkId",CompareTag.Equal,pkId)
                    .andFilter()
                    .compareFilter("statu",CompareTag.Equal,PostStatu.上线)
                    .pageLimitFilter(page,1);;
        }
        else
        {
            filter = EntityFilterChain.newFilterChain(PostEntity.class)
                    .compareFilter("pkId",CompareTag.Equal,pkId)
                    .andFilter()
                    .compareFilter("statu",CompareTag.Equal,  PostStatu.下线)
                    .pageLimitFilter(page,1);;
        }

        List<PostEntity> postEntities = daoService.queryEntities(PostEntity.class,filter);

        return CollectionUtils.isEmpty(postEntities)?null:postEntities.get(0);


    }

    public KeyNameValue 修改榜帖状态(String pkId, String postId, String userId) throws AppException {
        String creator = pkService.querySinglePkEntity(pkId).getUserId();
        if(!org.apache.commons.lang.StringUtils.equals(userId,creator)){throw AppException.buildException(PageAction.消息级别提示框(Level.错误消息,"非法操作"));}

        KeyNameValue keyNameValue = null;

        PostEntity postEntity = this.查询帖子ById(pkId,postId);
        if(PostStatu.上线 == postEntity.getStatu()){
            postEntity.setStatu(PostStatu.下线);
        }
        else {
            postEntity.setStatu(PostStatu.上线);
        }
        keyNameValue = new KeyNameValue(postEntity.getStatu().getStatu(),postEntity.getStatu().getStatuStr());
        daoService.updateEntity(postEntity);
        return keyNameValue;
    }

    public PostEntity getPostEntityById(String postId) {
        EntityFilterChain filter1 = EntityFilterChain.newFilterChain(PostEntity.class)
                .compareFilter("postId",CompareTag.Equal,postId);
        PostEntity postEntity = daoService.querySingleEntity(PostEntity.class,filter1);
        return postEntity;
    }

    private boolean isUserCollectPost(String postId,String userId){
        EntityFilterChain cfilter = EntityFilterChain.newFilterChain(UserCollectionEntity.class)
                .compareFilter("postId",CompareTag.Equal,postId)
                .andFilter()
                .compareFilter("userId",CompareTag.Equal,userId);
        UserCollectionEntity userCollectionEntity = daoService.querySingleEntity(UserCollectionEntity.class,cfilter);
        return !ObjectUtils.isEmpty(userCollectionEntity);
    }


    public PostEntity 查询帖子ById(String pkId, String postId) {
        EntityFilterChain filter1 = EntityFilterChain.newFilterChain(PostEntity.class)
                .compareFilter("pkId",CompareTag.Equal,pkId)
                .andFilter()
                .compareFilter("postId",CompareTag.Equal,postId);
        PostEntity postEntity = daoService.querySingleEntity(PostEntity.class,filter1);
        return postEntity;
    }
}
