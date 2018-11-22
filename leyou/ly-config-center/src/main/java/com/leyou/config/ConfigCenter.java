package com.leyou.config;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName ConfigCenter
 * @Description 配置中心
 * @Author wq
 * @Date 2018/11/22 10:58
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConfigCenter.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
