package com.leyou.search.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 商品服务调用接口
 * @author admin
 */
@FeignClient(name = "item-service")
public interface ItemClient {

}
