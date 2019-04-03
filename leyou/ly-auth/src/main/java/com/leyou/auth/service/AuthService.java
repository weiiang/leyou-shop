package com.leyou.auth.service;

import com.leyou.auth.api.UserApi;
import com.leyou.user.entity.ext.XcUserExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AuthService
 * @Description TODO
 * @Author wq
 * @Date 2019/4/3 14:09
 * @Version 1.0.0
 */
@Service
public class AuthService {

    @Autowired
    private UserApi userApi;


    public Object auth(String username, String password) {
        XcUserExt xcUserExt = userApi.getUserext(username);
        return xcUserExt;
    }
}
