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
     * 根据品牌分类ID列表查询品牌列表
     * @param ids
     * @return
     */
    @GetMapping("/brand/list-by-ids")
    ResponseEntity<ResponseResult> selectBrandListByIdList(@RequestParam("ids[]") List<Long> ids);

    /**
     * 根据分类ID列表查询分类列表
     * @param ids
     * @return
     */
    @GetMapping("/category/list-by-ids")
    ResponseEntity<ResponseResult> selectCategoryListByIdList(@RequestParam("ids[]") List<Long> ids);

}
