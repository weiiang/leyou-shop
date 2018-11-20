package com.leyou.item.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SpecGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/spec-group")
@RestController
public class SpecGroupController {

    @Autowired
    private SpecGroupService specGroupService;

    @GetMapping("/{cid}")
    public ResponseEntity<ResponseResult> getSpecGroupListByCid(@PathVariable("cid")Long cid){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(specGroupService.getSpecGroupByCid(cid), HttpStatus.OK));
    }
}
