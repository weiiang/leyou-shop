package com.leyou.item.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SpecParamService;
import com.leyou.pojo.SpecParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/spec-param")
@RestController
public class SpecParamController {

    @Autowired
    private SpecParamService specParamService;

    @ApiOperation("根据规格组ID查询规格参数列表")
    @GetMapping("/{groupId}")
    public ResponseEntity<ResponseResult> getSpecParamListByGroupId(@PathVariable("groupId")Long groupId){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(specParamService.getSpecParamListByGroupId(groupId), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseResult> addBatch(@RequestBody List<SpecParam> specParamsList){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(specParamService.addBatch(specParamsList), HttpStatus.OK));
    }


    @DeleteMapping
    public ResponseEntity<ResponseResult> deleteBatch(@RequestParam("ids[]")List<Long> ids){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(specParamService.deleteBatch(ids), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseResult> updateBatch(@RequestBody List<SpecParam> specParamList){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(specParamService.updateBatch(specParamList), HttpStatus.OK));
    }

    @ApiOperation("根据分类ID或是否搜索查询规格参数列表")
    @GetMapping("/list-by-param")
    public ResponseEntity<ResponseResult> getSpecParamListByParam(@RequestParam(value = "cid", required = false)Long cid,
                                                                  @RequestParam(value = "searching", required = false)Boolean searching){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(specParamService.getSpecParamListByByParam(cid, searching), HttpStatus.OK));
    }

}

