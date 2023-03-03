package com.udemy.courudemy.Config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.udemy.courudemy.Controller.Api.utils.Constants.App_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(
                new ApiInfoBuilder()
                        .title("Gestion de stock")
                        .description("API de gestion de stock")
                        .version("1.0.0")
                        .build()
        ).groupName("Gestion de stock")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.udemy.courudemy.Controller.Api"))
                .paths(PathSelectors.ant(App_ROOT + "/**"))
                .build();
    }

}
