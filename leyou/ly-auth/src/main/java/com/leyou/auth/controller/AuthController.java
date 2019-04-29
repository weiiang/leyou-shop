package com.leyou.auth.controller;

import com.leyou.auth.service.AuthService;
import com.leyou.common.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AuthController
 * @Description TODO
 * @Author wq
 * @Date 2019/4/3 14:08
 * @Version 1.0.0
 */
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public ResponseEntity<ResponseResult>  auth(@RequestParam("username")String username, @RequestParam("password")String password){
        ResponseResult responseResult = ResponseResult.successWithDataAndMsg(authService.auth(username, password), "认证成功", HttpStatus.OK);
        return ResponseEntity.status(200)
                .body(responseResult);
    }

}
