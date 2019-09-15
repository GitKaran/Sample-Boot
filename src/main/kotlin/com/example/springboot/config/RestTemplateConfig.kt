package com.example.springboot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {


    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    /*
    ============either of them can be used==========
    @Bean
    fun getRestTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()
    */
}
