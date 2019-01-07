package com.leyou.search.api;

import com.leyou.common.vo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author admin
 */
@FeignClient(value = "item-service")
@ApiIgnore
public interface ItemApi {


    /**
     * 根据品牌ID查询品牌
     * @param id
     * @return
     */
    @GetMapping("/brand")
    ResponseEntity<ResponseResult> selectBrandById(@RequestParam("id") Long id);

    /**
     * 根据品牌分类ID列表查询品牌列表
     *
     * @param ids
     * @return
     */
    @GetMapping("/brand/list-by-ids")
    ResponseEntity<ResponseResult> selectBrandListByIdList(@RequestParam("ids[]") List<Long> ids);

    /**
     * 根据分类ID列表查询分类列表
     *
     * @param ids
     * @return
     */
    @GetMapping("/category/list-by-ids")
    ResponseEntity<ResponseResult> selectCategoryListByIdList(@RequestParam("ids[]") List<Long> ids);

    /**
     * spu分页信息
     *
     * @param page
     * @param row
     * @param saleable
     * @param key
     * @return
     */
    @GetMapping("/spu/page")
    ResponseEntity<ResponseResult> getSpuPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "row", defaultValue = "5") Integer row,
                                              @RequestParam(value = "saleable", required = false) Boolean saleable,
                                              @RequestParam(value = "key", required = false) String key);

    /**
     * SPU列表
     * @return
     */
    @GetMapping("/spu/list-all")
    ResponseEntity<ResponseResult> findAllSpu();

    /**
     * 根据SPUID查询Sku列表
     * @param spuId
     * @return
     */
    @GetMapping("/sku/list-by-spuId")
    ResponseEntity<ResponseResult> findSkuListBySpuId(@RequestParam("spuId")Long spuId);

    /**
     * 根据SPUID查询SPU详情
     * @param spuId
     * @return
     */
    @GetMapping("/spu-detail")
    ResponseEntity<ResponseResult> findSpuDetailsBySpuId(@RequestParam("spuId")Long spuId);


}
