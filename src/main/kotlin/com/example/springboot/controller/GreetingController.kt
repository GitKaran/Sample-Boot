/*
* In Spring’s approach to building RESTful web services,
* HTTP requests are handled by a controller. These components are easily identified
* by the @RestController annotation
*
*
* */

package com.example.springboot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/hello/{name}")
    fun get(@PathVariable name: String) = "Hello, $name"

}
