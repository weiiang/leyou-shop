package com.leyou.search.vo;

import io.swagger.annotations.ApiModel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author admin
 */
@ApiModel
public class MethodVO {
    private String methodName;
    private String returnType;
    private List<String> annotationList = new ArrayList<>();

    /**
     * 参数列表
     * 参数<->参数类型
     */
    private List<Map<String, String>> params;


    public List<Map<String, String>> getParams() {
        return params;
    }

    public void setParams(List<Map<String, String>> params) {
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<String> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<String> annotationList) {
        this.annotationList = annotationList;
    }

    @Override
    public String toString() {
        return "MethodVO{" +
                "methodName='" + methodName + '\'' +
                ", returnType='" + returnType + '\'' +
                ", annotationList=" + annotationList +
                '}';
    }
}
