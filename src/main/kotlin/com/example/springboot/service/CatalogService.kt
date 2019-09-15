package com.example.springboot.service

import com.example.springboot.model.CatalogItem
import com.example.springboot.model.Movie
import com.example.springboot.model.UserRating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CatalogService {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    fun getCatalog(userId: String): List<CatalogItem>? {


        val  userRating = restTemplate.getForObject("http://localhost:9095/ratings/$userId", UserRating::class.java)

        return userRating?.userRating?.map { rating ->

            val movie = restTemplate.getForObject("http://localhost:9095/movies/${rating.movieId}", Movie::class.java)

            CatalogItem(rating.movieId, movie?.name, movie?.description, rating.rating)
        }
    }
}
