package com.example.employeemanagement.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Application API")
                .description("This is description for my EmployeeWeb")
                .contact(new Contact("duyanh0610","https://www.facebook.com/duyanh0610","duyanhvu0610@gmail.com"))
                .version("1.0.0")
                .build();
    }
//    private List<ApiKey> apiKeys() {
//        return Collections.singletonList(
//                new ApiKey("AUTHORIZATION_TOKEN", "AUTHORIZATION_TOKEN", "header")
//        );
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.any())
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{
//                new AuthorizationScope("global", "accessEverything")
//        };
//        return Collections.singletonList(
//                new SecurityReference("AUTHORIZATION_TOKEN", authorizationScopes)
//        );
//    }
}
