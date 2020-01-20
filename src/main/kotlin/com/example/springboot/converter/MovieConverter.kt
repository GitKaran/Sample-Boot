package com.example.springboot.converter

import com.example.springboot.model.Movie
import com.example.springboot.model.MovieSummary
import org.springframework.stereotype.Component

@Component
class MovieConverter {

    fun convertMovieSummaryToMovie(movieSummary: MovieSummary, movieId: Int): Movie? =
        movieSummary.title
            ?.let {
                movieSummary.overview
                    ?.let {
                        Movie(
                            movieId = movieId,
                            name = movieSummary.title,
                            description = movieSummary.overview

                        )
                    }
            }
}
