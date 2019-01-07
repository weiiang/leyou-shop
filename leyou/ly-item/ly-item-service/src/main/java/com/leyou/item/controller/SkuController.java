package com.leyou.item.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SkuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName SkuController
 * @Description TODO
 * @Author wq
 * @Date 2018/12/21 10:22
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @GetMapping("list-by-spuId")
    @ApiOperation("根据spuId查询SKU列表")
    public ResponseEntity<ResponseResult> listBySpuId(@RequestParam("spuId")Long spuId){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(skuService.findListBySpuId(spuId), HttpStatus.OK));
    }
}
