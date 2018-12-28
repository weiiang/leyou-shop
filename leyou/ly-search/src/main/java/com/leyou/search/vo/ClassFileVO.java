package com.leyou.search.vo;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

public class ClassFileVO implements Serializable {

    public ClassFileVO() {
    }

    public ClassFileVO(Date createTime, Long size, String className, String qualifiedName, String absolutePath) {
        this.createTime = createTime;
        this.size = size;
        this.className = className;
        this.qualifiedName = qualifiedName;
        this.absolutePath = absolutePath;
    }

    /**
     * 创建时间
     */
    public Date createTime;
    /**
     * 文件大小
     */
    public Long size;
    /**
     * 类名称
     */
    public String className;
    /**
     * 类全名
     */
    public String qualifiedName;
    /**
     * 绝对路径
     */
    public String absolutePath;

    public Boolean canCreateIndex;

    public List<FileldVO> filedList;

    public List<MethodVO> methodList;

    public List<Annotation> annotationList;


    @Override
    public String toString() {
        return "createTime=" + createTime + ";" +
                "size=" + size + ";" +
                "className=" + className + ";" +
                "qualifiedName=" + qualifiedName + ";" +
                "absolutePath=" + absolutePath + ";";
    }
}
