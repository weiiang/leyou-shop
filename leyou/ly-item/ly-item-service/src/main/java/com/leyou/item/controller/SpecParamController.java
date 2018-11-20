package com.leyou.item.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
