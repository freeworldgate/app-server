package com.union.app.api.OSS;

import com.union.app.common.config.AppConfigService;
import com.union.app.domain.Oss上传.OssUrlInfo;
import com.union.app.plateform.constant.常量值;
import com.union.app.plateform.response.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/oss")
public class OSSSave {

//


    @RequestMapping(path="/getUrl",method = RequestMethod.GET)
    public ApiResponse 获取临时URL( @RequestParam(value="type")String type,@RequestParam(value="userId")String userId)
    {
        OssUrlInfo ossUrlInfo = new OssUrlInfo();
        ossUrlInfo.setAliyunServerURL(AppConfigService.getConfigAsString(常量值.OSS基础地址,"https://oss.211shopper.com"));
        ossUrlInfo.setDirectory(userId);

        ossUrlInfo.setPrefix("wx");
        ossUrlInfo.setTaskId(UUID.randomUUID().toString());

        return ApiResponse.buildSuccessResponse(ossUrlInfo);
    }

    @RequestMapping(path="/postUploadImgs",method = RequestMethod.GET)
    public ApiResponse 上传报告( @RequestParam(value="taskId")String taskId,@RequestParam(value="files")String[] files)
    {
        List<String> filePaths = new ArrayList<>();

        for(String file:files){
            String myfile = file.replace("[","").replace("]","").replace("\"","");
            String filePath = "https://oss.211shopper.com/" + myfile;
            filePaths.add(filePath);
        }


        return ApiResponse.buildSuccessResponse(filePaths);
    }




}
