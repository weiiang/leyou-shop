package com.leyou.upload.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.upload.service.FileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName FileInfoController
 * @Description 文件信息
 * @Author wq
 * @Date 2018/11/30 15:43
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/file-info")
public class FileInfoController {
    @Autowired
    private FileInfoService fileInfoService;

    @ApiOperation("文件分页列表")
    @GetMapping("/page")
    public ResponseEntity<ResponseResult> getFileInfoPage(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                                          @RequestParam(value = "rows", defaultValue = "10")Integer rows,
                                                          @RequestParam(value = "queryString", required = false)String queryString){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(fileInfoService.getFileInfoPage(page, rows, queryString), HttpStatus.OK));
    }

    @ApiOperation("根据上传ID查询文件列表")
    @GetMapping("/{objectId}")
    public ResponseEntity<ResponseResult> getFileListByObjectId(@PathVariable("objectId")Long objectId){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(fileInfoService.getFileListByObjectId(objectId), HttpStatus.OK));
    }

    @ApiOperation("根据上传ID删除文件列表")
    @DeleteMapping("/{objectId}")
    public ResponseEntity<ResponseResult> deleteFileListByObjectId(@PathVariable("objectId")Long objectId){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(fileInfoService.deleteFileListByObjectId(objectId), HttpStatus.OK));
    }
}
