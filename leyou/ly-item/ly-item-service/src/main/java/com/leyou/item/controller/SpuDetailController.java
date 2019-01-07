package com.leyou.item.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SpuDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SpuDetailController
 * @Description TODO
 * @Author wq
 * @Date 2018/11/29 9:22
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/spu-detail")
public class SpuDetailController {

    @Autowired
    private SpuDetailService spuDetailService;

    @GetMapping
    @ApiOperation("通过SPUID获取SPU详情")
    public ResponseEntity<ResponseResult> getDetailBySpuId(@RequestParam("spuId")Long spuId){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(spuDetailService.getDetailBySpuId(spuId), HttpStatus.OK));
    }
}
