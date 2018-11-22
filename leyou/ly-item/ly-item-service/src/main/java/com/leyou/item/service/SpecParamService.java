package com.leyou.item.service;

import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public Object addBatch(List<SpecParam> specParamsList) {
        return specParamMapper.insertList(specParamsList);
    }

    public Object deleteBatch(List<Long> ids) {
        return specParamMapper.deleteByIdList(ids);
    }

    @Transactional
    public Object updateBatch(List<SpecParam> specParamList) {
        List<Long> ids = new ArrayList<Long>(){{specParamList.forEach(l ->{add(l.getId());});}};
        deleteBatch(ids);
        return  addBatch(specParamList);
    }
}
