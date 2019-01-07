package com.leyou.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.vo.PageBean;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BrandService
 * @Description 商品品牌服务类
 * @Author wq
 * @Date 2018/11/1 17:07
 * @Version 1.0.0
 */
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public Object getPageList(int rows, String sortBy, boolean desc, String key, int page) {
        PageHelper.startPage(page, rows);
        //用Example过滤
        Example example = new Example(Brand.class);
        if (!StringUtils.isEmpty(key)){
            example.createCriteria()
                    .andLike("name", "%"+key+"%")
                    .orEqualTo("letter",key);
        }
        if (!StringUtils.isEmpty(sortBy)){
            String orderByClounm = sortBy + " " + (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClounm);
        }
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageBean<Brand>(pageInfo.getTotal(), pageInfo.getResult());
    }

    /**
     * Spring事务框架默认只在抛出RuntimeException和unchecked exceptions时才将事务回滚（Errors默认 - 事务回滚），但是抛出的Checked exceptions时将不进行事务回滚。
     * 如果我们希望改变这个默认情况，可以按场景做设置：
     * 抛出checked exceptions时也回滚事务：@Transactional(rollbackFor=Exception.class)
     * 抛出unchecked excepitons时不回滚事务：@Transactional(notRollbackFor=RunTimeException.class)
     * 不需要事务管理：@Transactional(propagation=Propagation.NOT_SUPPORTED)
     * 注意：如果异常被try｛｝catch｛｝了，事务就不回滚了，如果想让事务回滚必须再往外抛try｛｝catch｛throw Exception｝。
     *
     * 补充
     * Spring团队的建议是你在具体的类（或类的方法）上使用 @Transactional 注解，而不要使用在类所要实现的任何接口上。你当然可以在接口上使用 @Transactional 注解，但是这将只能当你设置了基于接口的代理时它才生效。因为注解是不能继承的，这就意味着如果你正在使用基于类的代理时，那么事务的设置将不能被基于类的代理所识别，而且对象也将不会被事务代理所包装（将被确认为严重的）。因此，请接受Spring团队的建议并且在具体的类上使用 @Transactional 注解。
     * @Transactional 注解标识的方法，处理过程尽量的简单。尤其是带锁的事务方法，能不放在事务里面的最好不要放在事务里面。可以将常规的数据库查询操作放在事务前面进行，而事务内进行增、删、改、加锁查询等操作。
     * @param brand
     * @param cids
     * @return
     */
    @Transactional
    public boolean insertBrand(Brand brand, List<Long> cids) {
            this.brandMapper.insertSelective(brand);
            cids.forEach(c ->{
                this.brandMapper.insertIntoCatogoryByBrand(c, brand.getId());
            });
        return true;
    }

    @Transactional
    public Object updateBrand(Brand brand, List<Long> cids) {
        brandMapper.deleteCategoryByBrandId(brand.getId());
        cids.forEach(cid ->{
            brandMapper.insertIntoCatogoryByBrand(cid, brand.getId());
        });
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Transactional
    public Object deleteBrandById(Long id) {
        brandMapper.deleteCategoryByBrandId(id);
        return brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 通过品牌ID查询品牌信息和品牌分类信息
     * @param id
     * @return
     */
    public Object getById(Long id) {
        Map<String, Object> returnMap = new HashMap<>();
        Brand brand = brandMapper.selectByPrimaryKey(id);
        List<Long> cids = brandMapper.selectCidByBrandId(id);
        returnMap.put("brand", brand);
        returnMap.put("cids", cids);
        return returnMap;
    }

    /**
     * 根据分类ID查询品牌列表
     * @param cid
     * @return
     */
    public Object getBrandListByCategoryId(Long cid) {
        return brandMapper.getBrandByCid(cid);
    }

    public List<Brand> getBrandListByIdList(List<Long> ids){
        List<Brand> lsit = brandMapper.selectByIdList(ids);
        return lsit;
    }

}
