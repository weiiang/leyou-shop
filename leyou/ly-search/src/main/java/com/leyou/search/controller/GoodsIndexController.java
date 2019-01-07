package com.leyou.search.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.search.pojo.Goods;
import com.leyou.search.service.GoodsIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GoodsIndexController
 * @Description 索引库控制器
 * @Author wq
 * @Date 2018/12/27 10:36
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/goods-index")
public class GoodsIndexController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostMapping
    public ResponseEntity<ResponseResult> createIndex(){
        boolean creatIndex = elasticsearchTemplate.createIndex(Goods.class);
        boolean putMapping = elasticsearchTemplate.putMapping(Goods.class);
        if (creatIndex && putMapping) {
            return ResponseEntity.status(200).body(ResponseResult
                    .successWithDataAndMsg(null, "索引库创建并添加映射成功!", HttpStatus.OK));
        }
        if (creatIndex && !putMapping) {
            return ResponseEntity.status(200).body(ResponseResult
                    .successWithDataAndMsg(null, "索引库创建成功添加映射失败!", HttpStatus.OK));
        }
        return ResponseEntity.status(200).body(ResponseResult
                .successWithDataAndMsg(null, "索引库创建失败并添加映射失败!", HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
