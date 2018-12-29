package com.leyou.search.controller;

import com.leyou.common.vo.ResponseResult;
import com.leyou.search.utils.ClassUtils;
import com.leyou.search.utils.ReflectUtils;
import com.leyou.search.vo.ClassFileVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ClassInfoController
 * @Description TODO
 * @Author wq
 * @Date 2018/12/29 16:51
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/class-info")
public class ClassInfoController {

    @GetMapping("/list")
    public ResponseEntity<ResponseResult> classInfoList(@RequestParam(required = false)String packageName) throws ClassNotFoundException {
        ReflectUtils reflectUtils = new ReflectUtils();
        String totalPath = reflectUtils.resovlePackagePath("com.leyou");
        List<ClassFileVO> classFileVOS = reflectUtils.parseClassName(totalPath, "com.leyou");
        List<ClassFileVO> classDetails = ClassUtils.getClassDetails(classFileVOS);
        return ResponseEntity.status(200).body(ResponseResult.successWithData(classDetails, HttpStatus.OK));

    }
}
