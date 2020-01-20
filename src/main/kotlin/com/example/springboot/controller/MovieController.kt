package com.example.springboot.controller

import com.example.springboot.client.MovieService
import com.example.springboot.model.Movie
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/movies")
class MovieController(
    private val movieService: MovieService) {

    @GetMapping("{movieId}")
    fun getMovieInfo(@PathVariable("movieId") movieId: Int) =
            movieService.getMovieInfo(movieId)

    @ApiOperation(value = "Add a new Movie")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "New movie added successfully."),
            ApiResponse(code = 400, message = "Client Error"),
            ApiResponse(code = 500, message = "Internal server error")
        ]
    )
    @PostMapping
    fun addNewMovie(
        @Valid @RequestBody movieDto: Movie) =
        movieService.addNewMovie(movieDto)

    @ApiOperation(value = "Delete movie by movieId")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "Movie deleted successfully."),
            ApiResponse(code = 400, message = "Client Error"),
            ApiResponse(code = 500, message = "Internal server error")
        ]
    )
    @DeleteMapping("{movieId}")
    fun deleteMovie(@PathVariable("movieId") movieId: Int?): ResponseEntity<Unit>? =
        movieId
            ?.let {
                movieService.deleteMovie(movieId)
                return ResponseEntity.status(HttpStatus.OK).build()
            }
}
