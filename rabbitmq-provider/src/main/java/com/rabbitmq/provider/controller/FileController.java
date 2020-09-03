package com.rabbitmq.provider.controller;

import com.rabbitmq.provider.respon.ApiReturnInfo;
import com.rabbitmq.provider.respon.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @Author: 惠腾贤
 * @Date: 2020/7/27 10:26
 */
@RestController
@RequestMapping(value = "file", method = RequestMethod.POST)
@Api(value = "文件上传", tags = "文件上传")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${file.upload.path}")
    public String filePath;

    @Value("${file.download.path}")
    public String fileDownLoadPath;

    @RequestMapping("/upload")
    @ApiOperation(value = "文件上传，返回文件路径")
    public ApiReturnInfo<String> upload(MultipartFile multipartFile) {
        ApiReturnInfo<String> apiReturnInfo = new ApiReturnInfo<String>();
        if (null == multipartFile) {
            apiReturnInfo.setCode(ResultCodeEnum.NO_DATA.getCode());
            apiReturnInfo.setMessage(ResultCodeEnum.NO_DATA.getMessage());
            return apiReturnInfo;
        }
        try {
            String filename = multipartFile.getOriginalFilename();
            String suffixName = filename.substring(filename.lastIndexOf("."));
            log.info("上传文件名称为" + filename + "文件后缀为" + suffixName);
            //重命名文件名称，防止乱码
            String newFileName = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli() + suffixName;
            File dest = new File(filePath + newFileName);
            // 判断路径是否存在，如果不存在，创建该路径
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            multipartFile.transferTo(dest);
            String fileUrl = fileDownLoadPath + newFileName;
            apiReturnInfo.setData(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.toString());
            apiReturnInfo.setCode(ResultCodeEnum.ServerExceprion.getCode());
            apiReturnInfo.setMessage(ResultCodeEnum.ServerExceprion.getMessage());
        }
        return apiReturnInfo;
    }
}
