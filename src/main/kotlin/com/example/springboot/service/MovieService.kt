package com.example.springboot.service

import com.example.springboot.model.Movie
import com.example.springboot.model.MovieSummary
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class MovieService {

    @Value("\${api.key}")
    private lateinit var apiKey: String

    @Autowired
    private lateinit var restTemplate: RestTemplate

    fun getMovieInfo(movieId: Int): Movie? {

        val movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/$movieId?api_key=$apiKey", MovieSummary::class.java)
        return Movie(
                movieId,
                movieSummary?.title!!,
                movieSummary.overview!!
        )

    }
}
