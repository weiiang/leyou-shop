package com.leyou.common.exceptions;

import com.leyou.common.enums.ExceptionEnum;

/**
 * @ClassName CustomGlobalRuntimeException
 * @Description 自定义运行时异常类
 * @Author wq
 * @Date 2018/10/30 11:55
 * @Version 1.0.0
 */
public class CustomGlobalRuntimeException extends RuntimeException{

    //异常枚举常量
    private ExceptionEnum exceptionEnum;

    /**
     * 构造方法,抛出异常的时候new调用,传入枚举,供controller增强器捕获异常时构造返回ResposneResult对象使用
     * @param exceptionEnum
     */
    public CustomGlobalRuntimeException(ExceptionEnum exceptionEnum){
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
