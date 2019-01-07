package com.leyou.item.service;

import com.leyou.item.mapper.SpuDetailMapper;
import com.leyou.pojo.SpuDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SpuDetailService
 * @Description TODO
 * @Author wq
 * @Date 2018/11/29 9:21
 * @Version 1.0.0
 */
@Service
public class SpuDetailService {

    @Autowired
    private SpuDetailMapper spuDetailMapper;

    public Object getDetailBySpuId(Long spuId) {
        SpuDetail spuDetail = new SpuDetail();
        spuDetail.setSpuId(spuId);
        return spuDetailMapper.selectByPrimaryKey(spuDetail);
    }
}
