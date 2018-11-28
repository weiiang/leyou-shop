package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecGroupService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

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
         specGroupMapper.insert(specGroup);
         return specGroup.getId();
    }

    @Transactional
    public Object updateSpecGroup(SpecGroup specGroup,List<SpecParam> specParamList) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(specGroup.getId());
        specParamMapper.delete(specParam);
        specParamMapper.insertList(specParamList);
        return specGroupMapper.updateByPrimaryKey(specGroup);
    }

    @Transactional
    public Object deleteByIdList(List<Long> ids) {
        ids.forEach(id ->{
            SpecParam specParam = new SpecParam();
            specParam.setGroupId(id);
            specParamMapper.delete(specParam);
        });
        return  specGroupMapper.deleteByIdList(ids);
    }
}
