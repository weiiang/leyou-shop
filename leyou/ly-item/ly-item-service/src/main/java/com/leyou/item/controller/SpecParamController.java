package com.leyou.item.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SpecParamService;
import com.leyou.pojo.SpecParam;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="规格参数控制器",tags={"规格参数相关接口"})
@RequestMapping("/spec-param")
@RestController
public class SpecParamController {

    @Autowired
    private SpecParamService specParamService;

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
}

