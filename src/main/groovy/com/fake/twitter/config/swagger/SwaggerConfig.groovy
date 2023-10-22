package com.fake.twitter.config.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.Contact

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fake.twitter.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
    }

    static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Twitter")
//                .description("")
                .version("1.0")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("Test", "test", "test"))
                .license("License of API")
                .licenseUrl("API license URL")
                .build()
    }
}
