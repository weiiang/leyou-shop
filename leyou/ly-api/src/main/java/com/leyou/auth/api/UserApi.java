package com.leyou.auth.api;

import com.leyou.user.entity.ext.XcUserExt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
@RequestMapping("/user")
public interface UserApi {
    /**
     * 根据用户名查询用户权限信息
     * @param username
     * @return
     */
    @GetMapping("/getuserext")
    XcUserExt getUserext(@RequestParam("username") String username);

}
