package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.utils.DateUtils;
import com.leyou.common.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ImageUploadService
 * @Description 图片上传服务类
 * @Author wq
 * @Date 2018/11/6 15:14
 * @Version 1.0.0
 */
@Service
public class ImageUploadService {

    private static final Logger logger = LoggerFactory.getLogger(ImageUploadService.class);

    /**
     * 持的文件类型
     */
    private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    public Object upload(MultipartFile file) throws IOException {
        // 1)校验文件类型
        String type = file.getContentType();
        if (!suffixes.contains(type)) {
            logger.info("上传失败，文件类型不匹配：{}", type);
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_UPLOAD_IMAGE_FILE_TYPE_IS_NOT_ALLOWED);
        }
        //校验文件大小
        if ( !FileUtils.checkFileSize(file, 5, "M")){
            logger.info("上传失败，文件大小不匹配：{}", file.getSize()/(1024*1024)+"MB");
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_UPLOAD_IMAGE_FILE_SIZE_IS_TOO_LARGE);
        }
        //校验文件内容
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image == null){
            logger.info("上传失败，文件内容匹配：{}", image);
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_UPLOAD_IMAGE_FILE_CONTENT_IS_NOT_ALLOWED);
        }
        //文件上传
        File dir = new File("classpath:\\heima\\upload\\"+ DateUtils.dateToString(new Date(), "yyyy-MM-dd"));
        System.out.println(dir);
        System.out.println(!dir.exists());
        if (!dir.exists()){
            dir.mkdirs();
        }

        return suffixes;
    }
}
