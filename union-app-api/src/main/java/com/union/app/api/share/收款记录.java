package com.union.app.api.share;

import com.union.app.domain.pk.apply.ApplyOrder;
import com.union.app.plateform.data.resultcode.AppException;
import com.union.app.plateform.data.resultcode.AppResponse;
import com.union.app.plateform.data.resultcode.PageAction;
import com.union.app.plateform.storgae.redis.RedisStringUtil;
import com.union.app.service.pk.click.ClickService;
import com.union.app.service.pk.service.OrderService;
import com.union.app.service.pk.service.PkService;
import com.union.app.service.pk.service.PostService;
import com.union.app.service.pk.service.UserInfoService;
import com.union.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.io.IOException;

@RestController
@RequestMapping(path="/pk")
public class 收款记录 {


    @Autowired
    PkService pkService;

    @Autowired
    ClickService clickService;

    @Autowired
    RedisStringUtil redisStringUtil;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserInfoService userInfoService;



    @RequestMapping(path="/feeOrder",method = RequestMethod.GET)
    public AppResponse getApplyOrder(@RequestParam("pkId") String pkId,@RequestParam("userId") String userId,@RequestParam("type") int type,@RequestParam("page") int page) throws AppException, IOException {


        ApplyOrder applyOrder = userInfoService.查询收款类型订单(pkId,userId,type,page);

        return AppResponse.buildResponse(PageAction.执行处理器("success",applyOrder));
    }


    @RequestMapping(path="/cashierOrderConfirm1",method = RequestMethod.GET)
    @Transactional(rollbackOn = Exception.class)
    public AppResponse cashierOrderConfirm1(@RequestParam("orderId") String orderId,@RequestParam("userId") String userId) throws AppException, IOException {


        userInfoService.确认已收款(orderId,userId);
        ApplyOrder applyOrder = userInfoService.查询订单ById(orderId);
        return AppResponse.buildResponse(PageAction.执行处理器("success",applyOrder));
    }

    @RequestMapping(path="/cashierOrderConfirm2",method = RequestMethod.GET)
    @Transactional(rollbackOn = Exception.class)
    public AppResponse cashierOrderConfirm2(@RequestParam("orderId") String orderId,@RequestParam("userId") String userId) throws AppException, IOException {

        userInfoService.确认未收款(orderId,userId);
        ApplyOrder applyOrder = userInfoService.查询订单ById(orderId);
        return AppResponse.buildResponse(PageAction.执行处理器("success",applyOrder));
    }



}
