package com.leyou.auth.service;

import com.leyou.auth.api.UserApi;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.user.entity.ext.XcUserExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            throw new CustomGlobalRuntimeException(ExceptionEnum.USERNAME_OR_PASSWORD_CANNOT_BE_NULL);
        }

        XcUserExt xcUserExt = userApi.getUserext(username);
        return xcUserExt;
    }
}
