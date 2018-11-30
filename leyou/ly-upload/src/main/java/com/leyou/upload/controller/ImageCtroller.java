package com.leyou.upload.controller;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.vo.ResponseResult;
import com.leyou.upload.entity.FileInfo;
import com.leyou.upload.entity.req.FileInfoReq;
import com.leyou.upload.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName ImageCtroller
 * @Description 图片上传服务控制器
 * @Author wq
 * @Date 2018/11/6 15:06
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/image-upload")
public class ImageCtroller {

    @Autowired
    private ImageUploadService imageUploadService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseResult> uploadImage(@RequestParam(value = "file", required = true) MultipartFile file, FileInfoReq fileInfoReq) throws IOException {
        if (file == null){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_UPLOAD_IMAGE_CANNOT_BE_NULL);
        }
        return ResponseEntity.status(200)
                .body(ResponseResult.successWithDataAndMsg(imageUploadService
                        .upload(file, fileInfoReq),"上传成功!", HttpStatus.OK));
    }
}
