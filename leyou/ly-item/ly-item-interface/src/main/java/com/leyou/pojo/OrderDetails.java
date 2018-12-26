package com.leyou.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName OrderDetails
 * @Description 订单详情实体类
 * @Author wq
 * @Date 2018/12/21 10:36
 * @Version 1.0.0
 */
@Table(name = "tb_order_details")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long skuId;
    private Integer num;
    private String title;
    private String ownspec;
    private Long pcrice;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getorderId() {
        return orderId;
    }

    public void setorderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnspec() {
        return ownspec;
    }

    public void setOwnspec(String ownspec) {
        this.ownspec = ownspec;
    }

    public Long getPcrice() {
        return pcrice;
    }

    public void setPcrice(Long pcrice) {
        this.pcrice = pcrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}



