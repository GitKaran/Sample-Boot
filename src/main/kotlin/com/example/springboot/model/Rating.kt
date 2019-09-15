package com.example.springboot.model

data class Rating(
        val movieId: Int,
        val rating: Int
)

data class UserRating(
       val userId: Int,
       val userRating: List<Rating>

)
