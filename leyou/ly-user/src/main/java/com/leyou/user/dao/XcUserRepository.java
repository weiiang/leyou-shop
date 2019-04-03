package com.leyou.user.dao;

import com.leyou.common.base.BaseMapper;
import com.leyou.user.entity.XcUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * Created by Administrator.
 */
@Mapper
public interface XcUserRepository extends BaseMapper<XcUser> {
    //根据账号查询用户信息
    @Select("select * from xc_user where username = #{username} limit 1")
    XcUser findByUsername(@Param("username") String username);
}
