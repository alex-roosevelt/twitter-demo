package com.fake.twitter.config.swagger

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.Contact
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization"

    private static ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header")
    }

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
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


    private static SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build()
    }

    private static List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything")
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]
        authorizationScopes[0] = authorizationScope
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes))
    }
}
