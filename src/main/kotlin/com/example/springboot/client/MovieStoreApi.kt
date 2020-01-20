package com.example.springboot.client

import com.example.springboot.model.MovieSummary
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieStoreApi {
    @GET("/{apiVersion}/movie/{movieId}")
    fun getMovieInfoByMovieId(
            @Path("apiVersion") apiVersion: Int,
            @Path("movieId") movieId: Int,
            @Query("api_key") api_key: String
    ): Call<MovieSummary>
}
