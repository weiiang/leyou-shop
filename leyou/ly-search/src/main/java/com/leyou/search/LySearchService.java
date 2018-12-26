package com.leyou.search;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName LySearchService
 * @Description 搜索服务启动类
 * @Author wq
 * @Date 2018/12/26 10:18
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
public class LySearchService {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
