package com.example.springboot.client

import com.example.springboot.model.MovieSummary
import org.springframework.stereotype.Component
import retrofit2.Response

@Component
class MovieClient(
        private val movieStoreApi: MovieStoreApi
) {

    fun getMovieInfoByMovieId(apiVersion: Int, movieId: Int, apiKey: String): Response<MovieSummary> {
        return movieStoreApi.getMovieInfoByMovieId(apiVersion, movieId, apiKey)
                .execute()
    }

}
