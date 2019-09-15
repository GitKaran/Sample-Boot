package com.example.springboot.controller

import com.example.springboot.service.CatalogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog")
class CatalogController(private val catalogService: CatalogService) {

    @GetMapping("{userId}")
    fun getCatalog(@PathVariable("userId") userId: String) =
            catalogService.getCatalog(userId)

}
