package com.leyou.search.vo;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 */
public class ClassFileVO implements Serializable {

    public ClassFileVO() {}

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

    /**
     * 默认不支持创建索引
     */
    public Boolean canCreateIndex = false;

    public List<FileldVO> filedList;

    public List<MethodVO> methodList;

    public List<String> annotationList;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public Boolean getCanCreateIndex() {
        return canCreateIndex;
    }

    public void setCanCreateIndex(Boolean canCreateIndex) {
        this.canCreateIndex = canCreateIndex;
    }

    public List<FileldVO> getFiledList() {
        return filedList;
    }

    public void setFiledList(List<FileldVO> filedList) {
        this.filedList = filedList;
    }

    public List<MethodVO> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<MethodVO> methodList) {
        this.methodList = methodList;
    }

    public List<String> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<String> annotationList) {
        this.annotationList = annotationList;
    }

    @Override
    public String toString() {
        return "ClassFileVO{" +
                "createTime=" + createTime +
                ", size=" + size +
                ", className='" + className + '\'' +
                ", qualifiedName='" + qualifiedName + '\'' +
                ", absolutePath='" + absolutePath + '\'' +
                ", canCreateIndex=" + canCreateIndex +
                ", filedList=" + filedList +
                ", methodList=" + methodList +
                ", annotationList=" + annotationList +
                '}';
    }
}
