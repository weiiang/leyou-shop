package com.leyou.item.mapper;

import com.leyou.pojo.SpecParam;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface SpecParamMapper extends Mapper<SpecParam>, InsertListMapper<SpecParam> , DeleteByIdListMapper<SpecParam, Long> {
}
