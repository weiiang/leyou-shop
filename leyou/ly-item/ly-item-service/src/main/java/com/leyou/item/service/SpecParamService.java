package com.leyou.item.service;

import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecParamService {

    @Autowired
    private SpecParamMapper specParamMapper;

    /**
     * 根据规格组ID查询规格参数列表
     * @param groupId
     * @return
     */
    public Object getSpecParamListByGroupId(Long groupId){
        SpecParam specParam = new SpecParam(){{setGroupId(groupId);}};
        return specParamMapper.select(specParam);
    }
}
