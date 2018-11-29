package com.leyou;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 商品微服务
 */
@EnableSwagger2
@MapperScan(value = {"com.leyou.item.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
public class LyItemService {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LyItemService.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
