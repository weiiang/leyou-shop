package com.leyou.item.controller;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.common.vo.ResponseResult;
import com.leyou.item.service.ItemService;
import com.leyou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName ItemController
 * @Description TODO
 * @Author wq
 * @Date 2018/10/30 10:32
 * @Version 1.0.0
 */
@ApiIgnore
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ResponseResult> addUser(User user){
        if (user.getAge() == null){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_AGE_CANNOT_BE_NULL);
        }
        if (user.getName() == null){
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_NAME_CANNOT_BE_NULL);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseResult.successWithData(itemService.insert(user), HttpStatus.CREATED));
    }

}
