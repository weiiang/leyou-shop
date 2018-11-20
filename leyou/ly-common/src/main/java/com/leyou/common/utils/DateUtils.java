package com.leyou.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description 日期工具类
 * @Author wq
 * @Date 2018/11/20 11:55
 * @Version 1.0.0
 */
public class DateUtils {

    public static String dateToString(Date date, String pattern){
        String dateString = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        dateString =  simpleDateFormat.format(date);
        return dateString;
    }

    public static void main(String[] args) {
        System.out.println(dateToString(new Date(), "yyyy-MM-dd"));
    }
}
