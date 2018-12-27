package com.leyou.search.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.search.service.GoodsIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private GoodsIndexService goodsIndexService;

     @GetMapping("/syschognized-index")
    public ResponseEntity<ResponseResult> SyschognizedIndex(){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(goodsIndexService.syschognizedIndex(), HttpStatus.OK));
    }
}
