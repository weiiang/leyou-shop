package com.leyou.item.service;

import com.leyou.item.mapper.SkuMapper;
import com.leyou.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SkuService
 * @Description TODO
 * @Author wq
 * @Date 2018/12/21 10:21
 * @Version 1.0.0
 */
@Service
public class SkuService {

    @Autowired
    private SkuMapper skuMapper;

    public Object findListBySpuId(Long spuId) {
        Sku sku = new Sku();
        sku.setSpuId(spuId);
        return skuMapper.select(sku);
    }
}
