package com.leyou.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.vo.PageBean;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategotyMapper;
import com.leyou.item.mapper.SpuMapper;
import com.leyou.pojo.Category;
import com.leyou.pojo.Spu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName SpuService
 * @Description SPU服务层
 * @Author wq
 * @Date 2018/11/29 9:21
 * @Version 1.0.0
 */
@Service
public class SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private CategotyMapper categotyMapper;

    @Autowired
    BrandMapper brandMapper;

    /**
     * spu分页列表
     *
     * @param page
     * @param row
     * @param saleable
     * @param key
     * @return
     */
    public Object getPageList(Integer page, Integer row, Boolean saleable, String key) {
        PageHelper.startPage(page, row);
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("saleable", saleable);
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("title", "%" + key + "%");
        }
        Page<Spu> spuList = (Page<Spu>) spuMapper.selectByExample(example);
        //查询品牌和分类
        spuList.forEach(spu -> {
            List<String> nameList = categotyMapper.selectByIdList(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()))
                    .stream().map(Category::getName).collect(Collectors.toList());
            String names = StringUtils.join(nameList, "/");
            spu.setCname(names);
            spu.setBname(brandMapper.selectByPrimaryKey(spu.getBrandId()).getName());
        });
        return new PageBean<Spu>(spuList.getTotal(), spuList.getResult());
    }
}
