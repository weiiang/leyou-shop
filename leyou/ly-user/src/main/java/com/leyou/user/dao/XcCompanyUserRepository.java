package com.leyou.user.dao;

import com.leyou.common.base.BaseMapper;
import com.leyou.user.entity.XcCompanyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wq
 */
@Mapper
public interface XcCompanyUserRepository extends BaseMapper<XcCompanyUser> {
    /**
     * 根据用户id查询该用户所属的公司id
     * @param userId
     * @return
     */
    @Select("select * from xc_company where id = (select company_id from xc_company_user where user_id = #{userId})")
    XcCompanyUser findByUserId(@Param("userId") String userId);
}
