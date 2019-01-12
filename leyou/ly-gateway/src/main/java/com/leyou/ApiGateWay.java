package com.leyou;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RestController
public class ApiGateWay {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ApiGateWay.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


}
