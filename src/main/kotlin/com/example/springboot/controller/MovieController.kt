package com.example.springboot.controller

import com.example.springboot.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MovieController(private val movieService: MovieService) {

    @GetMapping("{movieId}")
    fun getMovieInfo(@PathVariable("movieId") movieId: Int) =
            movieService.getMovieInfo(movieId)
}
