package com.leyou.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Sku
 * @Description 商品SKU属性
 *  每个商品享有的属性
 * @Author wq
 * @Date 2018/12/21 10:04
 * @Version 1.0.0
 */
@Table(name = "tb_sku")
public class Sku implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * SpuID
     */
    private Long supId;
    /**
     * 标题
     */
    private String title;
    /**
     * 商品图片地址
     */
    private String images;
    /**
     * 价格
     */
    private Long price;
    /**
     *
     */
    private String indexes;
    /**
     * 特有属性
     */
    private String ownSpec;
    /**
     * 是否可用
     */
    private Boolean enable;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date LastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupId() {
        return supId;
    }

    public void setSupId(Long supId) {
        this.supId = supId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return LastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        LastUpdateTime = lastUpdateTime;
    }
}
