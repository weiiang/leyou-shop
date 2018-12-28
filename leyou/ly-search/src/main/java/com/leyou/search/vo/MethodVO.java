package com.leyou.search.vo;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;


public class MethodVO {
    public String methodName;
    public String returnType;
    public List<Annotation> annotationList = new ArrayList<>();

    @Override
    public String toString() {
        return "methodName=" + methodName + ";" +
                "returnType=" + returnType + ";" +
                "annotationList=" + annotationList.toString() ;
    }
}
