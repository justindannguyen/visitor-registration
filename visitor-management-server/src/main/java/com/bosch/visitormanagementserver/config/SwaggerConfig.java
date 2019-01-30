/**
 * Copyright (C) 2019, Justin Nguyen
 */
package com.bosch.visitormanagementserver.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tuan3.nguyen@gmail.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(
        DocumentationType.SWAGGER_2).select()
                                    .apis(
                                        basePackage("com.bosch.visitormanagementserver.controller"))
                                    .paths(PathSelectors.any())
                                    .build()
                                    .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo("Raw Reading API", "Provide the APIs to get raw data from meter reading",
        "1.0", "", new Contact("Justin Nguyen", "https://justindannguyen.github.io/",
            "tuan3.nguyen@gmail.com"),
        "", "", Collections.emptyList());
  }
}
