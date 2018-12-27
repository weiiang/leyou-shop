package com.leyou.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName IndexOperateService
 * @Description 索引库
 * @Author wq
 * @Date 2018/12/27 10:57
 * @Version 1.0.0
 */
@Service
public class IndexOperateService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * @param cl 索引库映射类字节码
     * @return
     */
    public Object addIndex(Class cl){
        boolean flag = false;
        elasticsearchTemplate.createIndex(cl);
        flag = true;
        return flag;
    }
}
