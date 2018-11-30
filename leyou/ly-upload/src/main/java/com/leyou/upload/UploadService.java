package com.leyou.upload;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName UploadService
 * @Description 上传服务启动类
 * @Author wq
 * @Date 2018/11/6 14:55
 * @Version 1.0.0
 */
@MapperScan("com.leyou")
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class UploadService {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(UploadService.class);
        //不打印springboot标志
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
