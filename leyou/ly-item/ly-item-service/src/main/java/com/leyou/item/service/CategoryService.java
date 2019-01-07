package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exceptions.CustomGlobalRuntimeException;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategotyMapper;
import com.leyou.pojo.Category;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description 商品分类服务类
 * @Author wq
 * @Date 2018/10/31 9:19
 * @Version 1.0.0
 */

@Service
public class CategoryService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CategotyMapper categotyMapper;

    public List<Category> getCategoryListByPid(Long pid) {
        Category queryCategory = new Category();
        queryCategory.setParentId(pid);
        List<Category> categoryList = categotyMapper.select(queryCategory);
        if (CollectionUtils.isEmpty(categoryList)) {
            throw new CustomGlobalRuntimeException(ExceptionEnum.NOT_FOUNT_ITEM_CATEGORY);
        }
        return categoryList;
    }

    /**
     * 新增的时候判断父节点的isParent是否为false,如果为false要改为true
     *
     * @param category
     * @return
     */
    public Integer insertCategory(Category category) {
        if (hasSameName(category.getName())) {
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_CATEGORY_NAME_EXIST);
        }
        //当父节点为0的时候直接添加,不用判断
        if (category.getParentId() != 0L){
            Category queryCategory = new Category();
            queryCategory.setId(category.getParentId());
            Category parentCategory = categotyMapper.selectByPrimaryKey(queryCategory);
            if (!parentCategory.getIsParent()) {
                parentCategory.setIsParent(true);
                categotyMapper.updateByPrimaryKey(parentCategory);
            }
        }
        Integer insert = categotyMapper.insert(category);
        return insert;
    }

    public Integer updateCategory(Category category) {
        if (hasSameName(category.getName())) {
            throw new CustomGlobalRuntimeException(ExceptionEnum.BADREQUEST_CATEGORY_NAME_EXIST);
        }
        int i = categotyMapper.updateByPrimaryKey(category);
        return i;
    }

    /**
     * 当删除最后一个节点的时候要将父节点的isParent设置为false
     *
     * @param id
     * @return
     */
    public Integer deleteCategoryById(Long id) {
        //查询当前删除节点
        Category category = categotyMapper.selectByPrimaryKey(id);
        //构造查询条件
        Category query = new Category();
        query.setParentId(category.getParentId());
        int i = categotyMapper.deleteByPrimaryKey(id);
        //查询父节点相同的数量
        int count = categotyMapper.selectCount(query);
        //当没有子节点将isParent改为false
        if (count <= 0) {
            Category parentCategory = categotyMapper.selectByPrimaryKey(category.getParentId());
            parentCategory.setIsParent(false);
            categotyMapper.updateByPrimaryKey(parentCategory);
        }
        return i;
    }

    /**
     * 添加和修改的时候校验是否存在该名称节点
     *
     * @param name
     * @return
     */
    private boolean hasSameName(String name) {
        boolean flag = false;
        Category category = new Category();
        category.setName(name);
        int count = categotyMapper.selectCount(category);
        if (count > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 查询商品品牌分类信息
     * @param id
     * @return
     */
    public Object getCategoryListById(Long id) {
        List<Long> cids = brandMapper.selectCidByBrandId(id);

        List<Category> categories = categotyMapper.selectByIdList(cids);
        return categories;
    }

    public Object getCategoryListByIdList(List<Long> ids) {
        List<Category> categories = categotyMapper.selectByIdList(ids);
        return categories;
    }
}
