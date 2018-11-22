package com.leyou.item.controller;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.SpecGroupService;
import com.leyou.pojo.SpecGroup;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
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

    @PostMapping
    public ResponseEntity<ResponseResult> insertSpecGroup(SpecGroup specGroup){
        if (StringUtils.isEmpty(specGroup.getName())){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_SPEC_GROUP_NAME_CANNOT_BE_NULL);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseResult
                .successWithData(specGroupService.insertSpecGroup(specGroup), HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseResult> updateSpecGroup(SpecGroup specGroup){
        if (StringUtils.isEmpty(specGroup.getName())){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_SPEC_GROUP_NAME_CANNOT_BE_NULL);
        }
        return ResponseEntity.status(HttpStatus.OK).body(ResponseResult
                .successWithData(specGroupService.updateSpecGroup(specGroup), HttpStatus.OK));
    }

    @DeleteMapping
    public ResponseEntity<ResponseResult> deleteByIdList(@RequestParam("ids[]") List<Long> ids){
        return ResponseEntity.status(HttpStatus.OK).body(ResponseResult
                .successWithData(specGroupService.deleteByIdList(ids), HttpStatus.OK));
    }
}
