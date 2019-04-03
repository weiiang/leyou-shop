package com.leyou.user.dao;


import com.leyou.common.base.BaseMapper;
import com.leyou.user.entity.XcMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author admin
 */
@Mapper
public interface XcMenuMapper extends BaseMapper<XcMenu> {
    /**
     * 根据用户id查询用户的权限
     * @param userId
     * @return
     */
    @Select("select * from xc_menu where id in (select menu_id from xc_permission where role_id in (select role_id from xc_user_role where user_id = #{userId}))")
    List<XcMenu> selectPermissionByUserId(@Param("userId") String userId);
}
