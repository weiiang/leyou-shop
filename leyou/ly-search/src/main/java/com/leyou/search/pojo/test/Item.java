package com.leyou.search.pojo.test;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

/**
 * @ClassName Item
 * @Description 索引库类型
 * @Author wq
 * @Date 2019/1/7 11:48
 * @Version 1.0.0
 */
@Document(indexName = "item",type = "docs", shards = 1, replicas = 0)
public class Item {
    @Id
    private Long id;

    @Field(type = FieldType.text, analyzer = "ik_max_word")
    /**
     * 标题
     */
    private String title;

    /**
     * 分类
     */
    @Field(type = FieldType.keyword)
    private String category;

    /**
     * 品牌
     */
    @Field(type = FieldType.keyword)
    private String brand;

    /**
     * 价格
     */
    @Field(type = FieldType.Double)
    private Double price;

    /**
     * 图片地址
     */
    @Field(index = false, type = FieldType.keyword)
    private String images;

    public Item() {}

    public Item(Long id, String title, String category, String brand, Double price, String images) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.images = images;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
