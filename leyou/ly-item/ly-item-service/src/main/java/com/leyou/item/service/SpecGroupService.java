package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.pojo.SpecGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecGroupService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    /**
     * 根据分类ID查询规格组
     * @param cid
     * @return
     */
    public Object getSpecGroupByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup() {{ setCid(cid); }};
        return specGroupMapper.select(specGroup);
    }

    public Object insertSpecGroup(SpecGroup specGroup) {
        return specGroupMapper.insert(specGroup);
    }

    public Object updateSpecGroup(SpecGroup specGroup) {
        return specGroupMapper.updateByPrimaryKey(specGroup);
    }

    public Object deleteByIdList(List<Long> ids) {
        return  specGroupMapper.deleteByIdList(ids);
    }
}
