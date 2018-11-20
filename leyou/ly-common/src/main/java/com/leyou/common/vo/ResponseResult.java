package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @ClassName ResponseResult
 * @Description TODO
 * @Author wq
 * @Date 2018/10/30 11:23
 * @Version 1.0.0
 */
public class ResponseResult {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 数据
     */
    private Object data;
    /**
     * 操作描述
     */
    private String msg;
    /**
     * 时间戳
     */
    private Long timstamp;


    /**
     * 抛出异常时使用,不传递数据
     * @param exceptionEnum
     * @return
     */
    public static ResponseResult failWithoutData(ExceptionEnum exceptionEnum) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = exceptionEnum.getCode();
        responseResult.setMsg(exceptionEnum.getMsg());
        responseResult.setTimstamp(System.currentTimeMillis());
        return responseResult;
    }

    /**
     * 抛出异常时使用,传递数据
     * @param exceptionEnum
     * @param data
     * @return
     */
    public static ResponseResult failWithData(ExceptionEnum exceptionEnum, Object data) {
        ResponseResult responseResult = new ResponseResult();
        failWithoutData(exceptionEnum);
        responseResult.data = data;
        return responseResult;
    }

    /**
     * 操作成功调用的方法
     * 传入数据
     * @param data
     * @return
     */
    public static ResponseResult successWithData(Object data, HttpStatus httpStatus) {
        ResponseResult responseResult = successWithoutData(httpStatus);
        responseResult.data = data;
        return responseResult;
    }

    /**
     * 操作成功调用的方法
     * 传入数据
     * @param data
     * @return
     */
    public static ResponseResult successWithDataAndMsg(Object data, String msg,HttpStatus httpStatus) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.data = data;
        responseResult.timstamp = System.currentTimeMillis();
        responseResult.msg = msg;
        responseResult.code = httpStatus.value();
        return responseResult;
    }

    /**
     * 操作成功调用
     * 无返回数据
     * @param httpStatus
     * @return
     */
    public static ResponseResult successWithoutData(HttpStatus httpStatus) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.code = httpStatus.value();
        responseResult.timstamp = System.currentTimeMillis();
        responseResult.msg = httpStatus.getReasonPhrase() + " Success!";
        return responseResult;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(Long timstamp) {
        this.timstamp = timstamp;
    }

}
