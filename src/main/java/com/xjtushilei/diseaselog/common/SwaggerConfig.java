package com.xjtushilei.diseaselog.common;

/**
 * @author shilei
 * @Date 2017/11/12.
 */

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(" API")
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(paths())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private Predicate<String> paths() {
        return PathSelectors.regex("^/(?!error).*$");
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("xjtu", "http://www.xjtushilei.com/", "xjtushilei@foxmail.com");
        return new ApiInfoBuilder()
                .title("智能导诊log API")
                .description("哈哈，我的api文档最全最吊")
                .license("Apache License Version 2.0")
                .contact(contact)
                .version("1.0")
                .build();
    }
}