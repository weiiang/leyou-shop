package com.leyou.item.controller;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.CategoryService;
import com.leyou.pojo.Category;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CategoryController
 * @Description 商品分类控制类
 * @Author wq
 * @Date 2018/10/31 9:20
 * @Version 1.0.0
 */
@Api(value="商品分类控制器",tags={"商品分类相关接口"})
@RestController
@RequestMapping("/category")
public class CategoryController {

    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseResult> getCategoryListByPid(@RequestParam("pid") Long pid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult
                        .successWithData(categoryService.getCategoryListByPid(pid), HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult> getCategoryListById(@PathVariable("id")Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult
                        .successWithData(categoryService.getCategoryListById(id), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseResult> insertCategory(@RequestBody Category category) {
        logger.info("insert category:{}", category.toString());
        if (StringUtils.isEmpty(category.getName())){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_CATEGORY_NAME_CANNOT_BE_NULL);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseResult
                        .successWithData(categoryService.insertCategory(category), HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ResponseResult> updateCategory(@RequestBody Category category) {
        if (StringUtils.isEmpty(category.getName())){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_CATEGORY_NAME_CANNOT_BE_NULL);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult
                        .successWithData(categoryService.updateCategory(category), HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult> deleteCategoryById(@PathVariable("id")Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseResult
                        .successWithData(categoryService.deleteCategoryById(id), HttpStatus.OK));
    }
}
