package com.leyou.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Stock
 * @Description 商品秒杀及剩余数量实体类
 * 由于该表的数据更新频率较高,所以单独将这些字段抽取出来
 * 纵向拆分
 * @Author wq
 * @Date 2018/12/21 10:12
 * @Version 1.0.0
 */
@Table(name = "tb_stock")
public class Stock {

    @Id
    private Long skuId;
    private int seckillStock;
    private int seckillTotal;
    private int stock;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public int getSeckillStock() {
        return seckillStock;
    }

    public void setSeckillStock(int seckillStock) {
        this.seckillStock = seckillStock;
    }

    public int getSeckillTotal() {
        return seckillTotal;
    }

    public void setSeckillTotal(int seckillTotal) {
        this.seckillTotal = seckillTotal;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
