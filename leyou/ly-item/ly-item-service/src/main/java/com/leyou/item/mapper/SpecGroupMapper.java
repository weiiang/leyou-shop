package com.leyou.item.mapper;

import com.leyou.pojo.SpecGroup;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecGroupMapper extends Mapper<SpecGroup>, DeleteByIdListMapper<SpecGroup, Long> {
}
