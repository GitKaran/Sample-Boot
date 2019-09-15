package com.example.springboot.controller

import com.example.springboot.service.RatingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ratings")
class RatingController(private val ratingService: RatingService) {

    @GetMapping("/movies/{movieId}")
    fun getMovieRatings(@PathVariable("movieId") movieId: Int ) =
            ratingService.getMovieRating(movieId)

    @GetMapping("/{userId}")
    fun getUserRatings(@PathVariable("userId") userId: Int ) =
        ratingService.getUserRatings(userId)

}

