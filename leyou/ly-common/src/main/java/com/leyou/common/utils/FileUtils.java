package com.leyou.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @ClassName FileUtils
 * @Description 文件处理工具类
 * @Author wq
 * @Date 2018/11/20 11:27
 * @Version 1.0.0
 */
public class FileUtils {

    /**
     * 判断文件大小
     *
     * @param file
     *            文件
     * @param size
     *            限制大小
     * @param unit
     *            限制单位（B,K,M,G）
     * @return  大于目标大小返回false   小于目标大小返回true
     */
    public static boolean checkFileSize(MultipartFile file, int size, String unit) {
        //len 文件的字节数
        long len = file.getSize();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }
}
