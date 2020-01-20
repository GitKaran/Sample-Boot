package com.example.springboot.client

import com.example.springboot.context.MovieNotFoundException
import com.example.springboot.converter.MovieConverter
import com.example.springboot.model.CatalogItem
import com.example.springboot.model.Movie
import com.example.springboot.repository.CatalogRepository
import com.example.springboot.repository.MovieRepository
import com.example.springboot.repository.RatingRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MovieService(
    private val movieConverter: MovieConverter,
    private val movieClient: MovieClient,
    private val movieRepository: MovieRepository,
    private val ratingRepository: RatingRepository,
    private val catalogRepository: CatalogRepository
) {

    private val log = LoggerFactory.getLogger(MovieService::class.java)

    @Value("\${api.key}")
    private lateinit var apiKey: String

    fun getMovieInfo(movieId: Int): Movie? {

        val movieSummary = movieClient.getMovieInfoByMovieId(3, movieId, apiKey)

        return movieSummary.body()
            ?.let {
                movieConverter.convertMovieSummaryToMovie(it, movieId)
            }
    }

    @Transactional
    fun addNewMovie(movieDto: Movie) {
        val userId = (500..599).shuffled().first()
        val ratingId = (20..99).shuffled().first()
        movieRepository.insertMovie(movieDto)
            .also { ratingRepository.addMovieRating(movieDto.movieId, ratingId, userId) }
            .also { catalogRepository.addMovieToCatalog(movieDto, ratingId) }
    }

    @Transactional
    fun deleteMovie(movieId: Int) {
        val movie = getMovieInfo(movieId)
        movie?.movieId
            ?.let {
                ratingRepository.deleteMovieRating(movieId)
                    .also { catalogRepository.deleteMovieFromCatalog(movieId) }
                    .also { movieRepository.deleteMovie(movieId) }
            }
            ?: log.error("Movie Id not found")
                .also { throw MovieNotFoundException() }
    }
}
