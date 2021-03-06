package com.leyou.item.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SpuService;
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
 * @ClassName SpuController
 * @Description SPU控制器
 * @Author wq
 * @Date 2018/11/29 9:21
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/page")
    @ApiOperation("SPU分页列表")
    public ResponseEntity<ResponseResult> getSpuPage(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                                     @RequestParam(value = "row", defaultValue = "5")Integer row,
                                                     @RequestParam(value = "saleable", required = false)Boolean saleable,
                                                     @RequestParam(value = "key", required = false)String key){

        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(spuService.getPageList(page,row,saleable,key), HttpStatus.OK));
    }

    @GetMapping("/list-all")
    @ApiOperation("SPU全部列表")
    public ResponseEntity<ResponseResult> listAll(){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(spuService.listAll(), HttpStatus.OK));
    }

}
