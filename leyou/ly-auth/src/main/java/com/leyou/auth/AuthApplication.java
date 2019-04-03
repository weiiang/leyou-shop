package com.leyou.auth;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName AuthApplication
 * @Description 认证服务启动类
 * @Author wq
 * @Date 2019/4/3 11:12
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
public class AuthApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthApplication.class)
                .bannerMode(Banner.Mode.OFF)
//                .properties("server.port=9080", "spring.application.name=auth-service")
                .run(args);
    }
}
