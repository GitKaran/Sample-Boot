package com.example.springboot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@Profile("!test")
class SwaggerConfig {

    /**
     * Binds a Docket to the application, this is needed together with the above @EnableSwagger2 to
     * activate Swagger2 in the application.
     *
     * @return the Docket containing the Swagger info which will be in the context as a bean
     */
    @Bean
    fun documentation(): Docket = Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.springboot.controller"))
            .paths(PathSelectors.any())
            .build()
}
