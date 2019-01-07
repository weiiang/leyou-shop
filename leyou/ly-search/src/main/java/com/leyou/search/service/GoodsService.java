package com.leyou.search.service;

import com.leyou.common.vo.ResponseResult;
import com.leyou.search.api.ItemApi;
import com.leyou.search.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName GoodsService
 * @Description 商品搜索
 * @Author wq
 * @Date 2018/12/27 10:02
 * @Version 1.0.0
 */
@Service
public class GoodsService {
    @Autowired
    private ItemApi itemApi;

    @Autowired
    private GoodsRepository goodsRepository;

    public ResponseResult syncDataToIndex() {

        List<Long> ids = new ArrayList<Long>(){{
            add(1115L);
            add(1528L);
        }};
        ResponseEntity responseEntity = itemApi.selectBrandListByIdList(ids);
        return (ResponseResult) responseEntity.getBody();
    }
}
