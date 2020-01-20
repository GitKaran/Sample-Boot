package com.example.springboot.controller

import com.example.springboot.dto.ErrorDto
import com.example.springboot.model.Rating
import com.example.springboot.service.RatingService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// TODO POST endpoint
// validate the fields
// please cover nested case
@RestController
@RequestMapping("/ratings")
class RatingController(private val ratingService: RatingService) {

    @ApiOperation(value = "Get movie by movieId")
    @ApiResponses(
            value = [
                ApiResponse(code = 200, message = """movie retrived sucessfully""", response = Rating::class),
                ApiResponse(code = 404, message = """movieId not found""", response = ErrorDto::class),
                ApiResponse(code = 400, message = "its 400"),
                ApiResponse(code = 403, message = "its 403"),
                ApiResponse(code = 409, message = "its 409"),
                ApiResponse(code = 500, message = "Internal server error has occurred")
            ]
    )
    @GetMapping("/movies/{movieId}", produces = ["application/json"])
    fun getMovieRatings(@PathVariable("movieId") movieId: Int ): Rating =
            ratingService.getMovieRating(movieId)



    @GetMapping("/{userId}")
    fun getUserRatings(@PathVariable("userId") userId: Int ) =
        ratingService.getUserRatings(userId)

}



