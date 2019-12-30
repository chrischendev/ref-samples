package com.chris.hmc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 1:47
 * Use for:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chris.hmc.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ControllerAdvice ResponseBody 数据增强测试系统")
                .description("测试")
                .termsOfServiceUrl("htts://www.baidu.com")
                .contact(new Contact("chrischan", "htts://www.baidu.com", "chrischen2018@163.com"))
                .version("1.0" + "." + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()))
                .build();
    }
}
