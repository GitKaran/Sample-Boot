package com.example.springboot.service

import com.example.springboot.config.RetrofitConfig
import com.example.springboot.converter.MovieConverter
import com.example.springboot.model.Movie
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MovieService(
        private val movieConverter: MovieConverter,
        private val objectMapper: ObjectMapper
) {

    /*
    *
    * For JSON de-serialization there are two ways either use Object Mapper or custom converter
    *
    * */

    @Value("\${api.key}")
    private lateinit var apiKey: String

    @Autowired
    private lateinit var retrofitConfig: RetrofitConfig

    fun getMovieInfo(movieId: Int): Movie? {

        val movieSummary = retrofitConfig.movieStoreClientApi().getMovieInfoByMovieId(3 ,movieId, apiKey ).execute()
//        return objectMapper.readValue(movieSummary.body().toString(), Movie::class.java)
        return movieSummary.body()?.let {
            movieConverter.convertMovieSummaryToMovie(it, movieId) }
    }
}
