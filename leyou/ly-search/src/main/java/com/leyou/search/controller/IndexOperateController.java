package com.leyou.search.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.search.pojo.test.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexOperateController
 * @Description 索引库控制器 索引库的增删查改
 * @Author wq
 * @Date 2018/12/27 10:56
 * @Version 1.0.0
 */
@Api
@RestController
@RequestMapping("/index")
public class IndexOperateController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostMapping
    @ApiOperation("根据类型创建索引库")
    public ResponseEntity<ResponseResult> createIndex() {
        boolean creatIndex = elasticsearchTemplate.createIndex(Item.class);
        boolean putMapping = elasticsearchTemplate.putMapping(Item.class);
        if (creatIndex && putMapping) {
            return ResponseEntity.status(200).body(ResponseResult
                    .successWithDataAndMsg(null, "索引库创建并添加映射成功!", HttpStatus.OK));
        }
        if (creatIndex && !putMapping) {
            return ResponseEntity.status(200).body(ResponseResult
                    .successWithDataAndMsg(null, "索引库创建添加映射失败!", HttpStatus.OK));
        }
        return ResponseEntity.status(200).body(ResponseResult
                .successWithDataAndMsg(null, "索引库创建失败并添加映射失败!", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping("/{indexName}")
    @ApiOperation("指定创建索引库名称创建爱你索引库")
    public ResponseEntity<ResponseResult> createIndexByName(@PathVariable("indexName")String indexName) {
        boolean creatIndex = elasticsearchTemplate.createIndex(indexName);
        if (creatIndex){
            return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(null,indexName+" 创建成功!", HttpStatus.OK));
        }
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(null,indexName+" 创建失败!", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/list")
    @ApiOperation("查询索引库列表")
    public ResponseEntity<ResponseResult> list() {
//        elasticsearchTemplate.s
//        Map mapping = elasticsearchTemplate.getMapping(Item.class);
        return ResponseEntity.status(200).body(ResponseResult.successWithData(null, HttpStatus.OK));
    }

    @GetMapping("/{indexName}")
    @ApiOperation("根据索引库名称查询索引库映射信息")
    public ResponseEntity<ResponseResult> getIndex(@PathVariable("indexName")String indexName) {
        Map mapping = elasticsearchTemplate.getMapping(indexName, "item");
        return ResponseEntity.status(200).body(ResponseResult.successWithData(mapping, HttpStatus.OK));
    }

    @DeleteMapping("/{indexName}")
    @ApiOperation("根据索引库名称删除索引库")
    public ResponseEntity<ResponseResult> deleteIndex(@PathVariable("indexName")String indexName) {
        boolean b = elasticsearchTemplate.deleteIndex(indexName);
        if (b){
            return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(null,indexName+" 删除成功!", HttpStatus.OK));
        }
        return ResponseEntity.status(200).body(ResponseResult.successWithDataAndMsg(null,indexName+" 删除失败!", HttpStatus.INTERNAL_SERVER_ERROR));
    }



}
