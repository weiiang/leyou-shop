package com.leyou.search.vo;

import io.swagger.annotations.ApiModel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
@ApiModel
public class FileldVO {

    private String filedName;
    private String type;
    private List<String> annotationList = new ArrayList<>();

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<String> annotationList) {
        this.annotationList = annotationList;
    }

    @Override
    public String toString() {
        return "FileldVO{" +
                "filedName='" + filedName + '\'' +
                ", type='" + type + '\'' +
                ", annotationList=" + annotationList +
                '}';
    }
}
