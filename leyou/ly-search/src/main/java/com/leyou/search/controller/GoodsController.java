package com.leyou.search.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.search.pojo.Goods;
import com.leyou.search.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsController
 * @Description Goods索引库搜索控制器
 * @Author wq
 * @Date 2018/12/27 10:35
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/goos-search")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping
    @ApiOperation("将数据库的商品数据同步到索引库")
    public ResponseEntity<ResponseResult> syncDataToIndex() throws IOException {
        return ResponseEntity.status(200).body(goodsService.syncDataToIndex());
    }


}
