package com.leyou.search.vo;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class FileldVO {

    public String filedName;
    public String type;
    public List<Annotation> annotationList = new ArrayList<>();

    @Override
    public String toString() {
        return "filedName=" + filedName + ";" +
                "type=" + type + ";" +
                "annotationList=" + annotationList.toString() ;
    }
}
