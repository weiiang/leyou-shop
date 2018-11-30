package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.utils.DateUtils;
import com.leyou.common.utils.FileUtils;
import com.leyou.upload.entity.FileInfo;
import com.leyou.upload.entity.req.FileInfoReq;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName ImageUploadService
 * @Description 图片上传服务类
 * @Author wq
 * @Date 2018/11/6 15:14
 * @Version 1.0.0
 */
@Service
public class ImageUploadService {

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    private static final Logger logger = LoggerFactory.getLogger(ImageUploadService.class);

    /**
     * 持的文件类型
     */
    private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    public Object upload(MultipartFile file, FileInfoReq fileInfoReq) throws IOException {
        // 1)校验文件类型
        String type = file.getContentType();
        if (!suffixes.contains(type)) {
            logger.info("上传失败，文件类型不匹配：{}", type);
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_UPLOAD_IMAGE_FILE_TYPE_IS_NOT_ALLOWED);
        }
        //校验文件大小
        if (!FileUtils.checkFileSize(file, 5, "M")) {
            logger.info("上传失败，文件大小不匹配：{}", file.getSize() / (1024 * 1024) + "MB");
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_UPLOAD_IMAGE_FILE_SIZE_IS_TOO_LARGE);
        }
        //校验文件内容
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image == null) {
            logger.info("上传失败，文件内容匹配：{}", image);
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_UPLOAD_IMAGE_FILE_CONTENT_IS_NOT_ALLOWED);
        }

        FileInfo fileInfo = new FileInfo();
        BeanUtils.copyProperties(fileInfoReq, fileInfo);
        String fileOriginalName = file.getOriginalFilename();
        fileInfo.setFileName(StringUtils.substringBeforeLast(fileOriginalName, "."));
        String extendName = StringUtils.substringAfterLast(fileOriginalName, ".");
        fileInfo.setFileType(extendName);
        fileInfo.setAddTime(new Date());
        //文件上传
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), extendName, null);
        // 带分组的路径
        String filePath = storePath.getFullPath();
        // 不带分组的路径
        String withoutGroupFilePath = storePath.getPath();
        // 获取缩略图路径
        String thumbFilePath = thumbImageConfig.getThumbImagePath(withoutGroupFilePath);
        fileInfo.setFilePath(filePath);
        fileInfo.setFileSize(file.getSize());
        fileInfoService.insertFileInfo(fileInfo);
        Map<String, String> returnMap = new HashMap<String, String>(){{
            put("filePath" , filePath);
            put("withoutGroupFilePath", withoutGroupFilePath);
            put("withoutGroupThumbFilePath", thumbFilePath);
            put("thumbFilePath", thumbImageConfig.getThumbImagePath(filePath));
        }};
        return returnMap;
    }
}
