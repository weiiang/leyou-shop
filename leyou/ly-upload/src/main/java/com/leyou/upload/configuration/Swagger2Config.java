package com.leyou.upload.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName Swagger2Config
 * @Description Swagger文档配置类
 * @Author wq
 * @Date 2018/11/30 15:43
 * @Version 1.0.0
 */
@Configuration
public class Swagger2Config {
    private Logger logger = LoggerFactory.getLogger(Swagger2Config.class);
    @Bean
    public Docket createRestApi() {
        logger.info(":{}","swagger文档配置...");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.leyou.upload.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("文件服务API文档")
                .description("文件服务API文档-API文档")
                .termsOfServiceUrl("http://localhost:8081/swagger-ui.html")
                .version("1.0")
                .build();
    }
}
