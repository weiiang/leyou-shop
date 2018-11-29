package com.leyou.item.mapper;

import com.leyou.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品品牌Mapper接口
 */
public interface BrandMapper extends Mapper<Brand> {

    /**
     * 新增商品分类和品牌中间表数据
     * @param cid 商品分类ID
     * @param bid   商品品牌ID
     * @return
     */
    @Insert("insert into tb_category_brand(category_id,brand_id)values(#{cid},#{bid})")
    int insertIntoCatogoryByBrand(@Param("cid") Long cid,@Param("bid") Long bid);

    /**
     * 根据商品品牌ID删除商品品牌和商品分类表的数据
     * @param bid 品牌ID
     * @return
     */
    @Delete("delete from tb_category_brand where brand_id = #{bid}")
    int deleteCategoryByBrandId(@Param("bid")Long bid);

    /**
     * 通过品牌ID查询品牌分类ID
     * @param bid
     * @return
     */
    @Select("select category_id from tb_category_brand where brand_id = #{bid}")
    List<Long> selectCidByBrandId(@Param("bid")Long bid);


    /**
     * 根据分类ID
     * 通过分类和品牌的关联表查询该分类品牌列表
     * @param cid
     * @return
     */
    @Select("select a.* from tb_brand a inner join tb_category_brand b on b.brand_id = a.id where b.category_id = #{cid}")
    List<Brand> getBrandByCid(@Param("cid")Long cid);

}
