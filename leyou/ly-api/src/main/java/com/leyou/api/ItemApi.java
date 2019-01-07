package com.leyou.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface ItemApi {





}
