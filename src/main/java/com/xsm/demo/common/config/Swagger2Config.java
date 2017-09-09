package com.xsm.demo.common.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger2集成
 */
@Configuration
public class Swagger2Config {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("测试api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xsm.demo.controller.test"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("线上api")//创建多个分组
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xsm.demo.controller.online"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("")
                .termsOfServiceUrl("")
                .contact("XSM")
                .version("1.0")
                .build();
    }
}
