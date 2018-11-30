package com.leyou.upload.entity.req;

import java.util.Date;

/**
 * @ClassName FileInfoReq
 * @Description TODO
 * @Author wq
 * @Date 2018/11/30 16:42
 * @Version 1.0.0
 */
public class FileInfoReq {
    /**
     * 文件状态
     */
    private Boolean status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 编码
     */
    private String code;
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 拥有者ID
     */
    private Long objectId;
    /**
     * 上传终端
     */
    private String upterminal;

    /**
     * 文件类别  一个地方可以传多个不同类型的文件,有不同的用处,
     * 区分同一个objectId下的不同文件类别
     */
    private Integer fileClass;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getUpterminal() {
        return upterminal;
    }

    public void setUpterminal(String upterminal) {
        this.upterminal = upterminal;
    }

    public Integer getFileClass() {
        return fileClass;
    }

    public void setFileClass(Integer fileClass) {
        this.fileClass = fileClass;
    }

    @Override
    public String toString() {
        return "FileInfoReq{" +
                "status=" + status +
                ", remark='" + remark + '\'' +
                ", code='" + code + '\'' +
                ", sort=" + sort +
                ", objectId=" + objectId +
                ", upterminal='" + upterminal + '\'' +
                ", fileClass=" + fileClass +
                '}';
    }
}
