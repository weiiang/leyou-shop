package com.leyou.upload.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName FileInfo
 * @Description 文件信息实体类
 * @Author wq
 * @Date 2018/11/30 15:23
 * @Version 1.0.0
 */
@Table(name = "file_info")
public class FileInfo implements Serializable {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 上传时间
     */
    @Column(name = "addTime")
    private Date addTime;
    /**
     * 上传人
     */
    @Column(name = "addEmployee")
    private Long addEmployee;
    /**
     * 最后修改时间
     */
    @Column(name = "lastModifyTime")
    private Date lastModifyTime;
    /**
     * 最后修改人
     */
    @Column(name = "lastModifyEmployee")
    private Long lastModifyEmployee;
    /**
     * 文件状态
     */
    @Column(name = "status")
    private Boolean status;
    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 编码
     */
    @Column(name = "code")
    private String code;
    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;
    /**
     * 文件名称
     */
    @Column(name = "fileName")
    private String fileName;
    /**
     * 文件类型
     */
    @Column(name = "fileType")
    private String fileType;
    /**
     * 文件路径
     */
    @Column(name = "filePath")
    private String filePath;
    /**
     * 文件大小
     */
    @Column(name = "fileSize")
    private Long fileSize;
    /**
     * 拥有者ID
     */
    @Column(name = "objectId")
    private Long objectId;
    /**
     * 上传终端
     */
    @Column(name = "upterminal")
    private String upterminal;
    /**
     * 文件类别  一个地方可以传多个不同类型的文件,有不同的用处,
     * 区分同一个objectId下的不同文件类别
     */
    @Column(name = "fileClass")
    private Integer fileClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getAddEmployee() {
        return addEmployee;
    }

    public void setAddEmployee(Long addEmployee) {
        this.addEmployee = addEmployee;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getLastModifyEmployee() {
        return lastModifyEmployee;
    }

    public void setLastModifyEmployee(Long lastModifyEmployee) {
        this.lastModifyEmployee = lastModifyEmployee;
    }

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
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
        return "FileInfo{" +
                "id=" + id +
                ", addTime=" + addTime +
                ", addEmployee=" + addEmployee +
                ", lastModifyTime=" + lastModifyTime +
                ", lastModifyEmployee=" + lastModifyEmployee +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", code='" + code + '\'' +
                ", sort=" + sort +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", objectId=" + objectId +
                ", upterminal='" + upterminal + '\'' +
                ", fileClass=" + fileClass +
                '}';
    }
}
