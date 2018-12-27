package com.leyou.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Goods
 * @Description 存入索引库的实体类
 * @Author wq
 * @Date 2018/12/27 9:19
 * @Version 1.0.0
 */
@Document( indexName = "goods", type = "docs", shards = 1, replicas = 0)
public class Goods implements Serializable {

    /**
     * spuId
     */
    @Id
    private Long id;
    /**
     * 所有用來搜索的信息:标题/分类/品牌
     */
    @Field(type = FieldType.text, analyzer = "ik_max_word")
    private String all;
    /**
     * 卖点 不用来搜索
     */
    @Field(type = FieldType.keyword, index = false)
    private String subTitle;
    /**
     * 品牌ID
     */
    private Long brandId;
    /**
     * 1级分类ID
     */
    private Long cid1;

    /**
     * 二级分类ID
     */
    private Long cid2;

    /**
     * 三级分类ID
     */
    private Long cid3;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 价格
     */
    private List<Long> price;

    /**
     * sku的json字符串
     */
    @Field(type = FieldType.keyword, index = false)
    private String skus;
    /**
     * 可搜索的规格参数 key:参数名; value:参数值
     */
    private Map<String, Object> specs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Long> getPrice() {
        return price;
    }

    public void setPrice(List<Long> price) {
        this.price = price;
    }

    public String getSkus() {
        return skus;
    }

    public void setSkus(String skus) {
        this.skus = skus;
    }

    public Map<String, Object> getSpecs() {
        return specs;
    }

    public void setSpecs(Map<String, Object> specs) {
        this.specs = specs;
    }
}
