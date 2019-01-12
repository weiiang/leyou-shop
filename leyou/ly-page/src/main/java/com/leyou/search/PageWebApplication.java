package com.leyou.search;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName PageWebApplication
 * @Description TODO
 * @Author wq
 * @Date 2019/1/12 10:02
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PageWebApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PageWebApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
