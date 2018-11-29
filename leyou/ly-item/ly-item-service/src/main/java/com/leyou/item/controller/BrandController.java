package com.leyou.item.controller;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.BrandService;
import com.leyou.pojo.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BrandController
 * @Description 品牌服务控制器
 * @Author wq
 * @Date 2018/11/1 17:23
 * @Version 1.0.0
 */
@Api(value="品牌控制器",tags={"品牌相关接口"})
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    private Logger logger = LoggerFactory.getLogger(BrandController.class);

    /**
     *
     * @param rows 每页的数据条数
     * @param sortBy 排序字段
     * @param desc  是否降序
     * @param key   搜索关键字
     * @param page  当前页数
     * @return
     */
    @ApiOperation(value = "品牌分页列表")
    @GetMapping("/page")
    public ResponseEntity<ResponseResult> getPageList(@RequestParam(value = "rows", defaultValue = "5") int rows,
                                                      @RequestParam(value = "sortBy", required = false) String sortBy,
                                                      @RequestParam(value = "desc", defaultValue = "false") boolean desc,
                                                      @RequestParam(value = "key", required = false) String key,
                                                      @RequestParam(value = "page", defaultValue = "1") int page) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult.successWithData(brandService
                        .getPageList(rows,sortBy,desc,key,page), HttpStatus.OK));

    }

    @ApiOperation(value = "品牌新增")
    @PostMapping
    public ResponseEntity<ResponseResult> insertCategory(Brand brand,@RequestParam("cids") List<Long> cids) {
        logger.info("insert brand:{}", brand.toString());
        logger.info("insert cids:{}", cids);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseResult
                        .successWithData(brandService.insertBrand(brand, cids), HttpStatus.CREATED));
    }

    @ApiOperation(value = "品牌修改")
    @PutMapping
    public ResponseEntity<ResponseResult> updateCategory(Brand brand, @RequestParam("cids")List<Long> cids) {
        logger.info("update brand:{}", brand.toString());
        if (StringUtils.isEmpty(brand.getName())){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_ITEM_BRAND_NAME_CANNOT_BE_NULL);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult
                        .successWithData(brandService.updateBrand(brand,cids), HttpStatus.OK));
    }

    @ApiOperation(value = "品牌删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult> deleteCategoryById(@PathVariable("id")Long id) {
        logger.info("insert brand:{}", id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult
                        .successWithData(brandService.deleteBrandById(id), HttpStatus.OK));
    }


    @ApiOperation(value = "根据ID查询品牌信息")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult> getById(@PathVariable("id")Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult
                        .successWithData(brandService.getById(id), HttpStatus.OK));
    }

    @ApiOperation(value = "根据三级分类ID查询该分类下的品牌列表")
    @GetMapping("/list-by-cid/{cid}")
    public ResponseEntity<ResponseResult> getBrandListByCategoryId(@PathVariable("cid")Long cid){
        return ResponseEntity.status(200).body(ResponseResult
                .successWithData(brandService.getBrandListByCategoryId(cid), HttpStatus.OK));
    }
}
