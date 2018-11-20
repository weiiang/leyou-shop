package com.leyou.upload.controller;

import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.vo.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName HandlerExceptionController
 * @Description TODO
 * @Author wq
 * @Date 2018/10/30 10:55
 * @Version 1.0.0
 * <p>
 * <p>
 * 全局统一异常处理流程
 * <p>
 * 1.在controller中抛出自定义异常,用异常枚举类作为参数给自定义异常中的枚举属性赋值
 * 2.用springboot的controller增强器捕获异常 返回值ResponseEntity<ResponseResult>
 *     2.1 设置status
 *     2.2 设置body:  调用ResponseResult的静态方法,将捕获自定义异常中的枚举作为参数传递至ResonseResult的构造方法,创建出返回对象
 */
@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(CustomGlobalRuntimeException.class)
    public ResponseEntity<ResponseResult> handleRuntimeException(CustomGlobalRuntimeException e) {
        return ResponseEntity
                .status(e.getExceptionEnum().getCode())
                .body(ResponseResult.failWithoutData(e.getExceptionEnum()));
    }

}
