package com.example.springboot.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class RetrofitConfig {
    companion object {
        fun <T> createRetrofitClient(service: Class<T>, baseUrl: String): T {

            val mapper = ObjectMapper()
                    .registerKotlinModule()

            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create(mapper))
                    .build()

            return retrofit.create(service)
        }
    }

    @Bean
    fun petStoreClientApi() =  createRetrofitClient(PetStore::class.java, "https://petstore.swagger.io" )

}
