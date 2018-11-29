package com.leyou.pojo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Spu
 * @Description Spu实体类
 * @Author wq
 * @Date 2018/11/29 9:08
 * @Version 1.0.0
 */
@Table(name = "tb_spu")
public class Spu  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private Long brandId;

    @Column(name = "saleable")
    private Boolean saleable;
    @Column(name = "valid")
    private Boolean valid;


    private Date createTime;
    private Date lastUpdateTime;

    /**
     * 非实体类字段
     */
    @Transient
    private String cname;
    /**
     * 非实体类字段
     */
    @Transient
    private String bname;



    public Boolean isSaleable() {
        return saleable;
    }

    public void setSaleable(boolean saleable) {
        this.saleable = saleable;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Long getCid1() {
        return cid1;
    }

    public void setCid1(Long cid1) {
        this.cid1 = cid1;
    }

    public Long getCid2() {
        return cid2;
    }

    public void setCid2(Long cid2) {
        this.cid2 = cid2;
    }

    public Long getCid3() {
        return cid3;
    }

    public void setCid3(Long cid3) {
        this.cid3 = cid3;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }



    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Spu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", cid1=" + cid1 +
                ", cid2=" + cid2 +
                ", cid3=" + cid3 +
                ", brandId=" + brandId +
                ", saleable=" + saleable +
                ", valid=" + valid +
                ", createTime=" + createTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", cname='" + cname + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }
}
