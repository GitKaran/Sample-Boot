package com.example.springboot.service

import com.example.springboot.model.Rating
import com.example.springboot.model.UserRating
import org.springframework.stereotype.Service

@Service
class RatingService {

    fun getMovieRating(movieId: Int): Rating {
        return Rating(movieId,5)
    }

    fun getUserRatings(userId: Int ): UserRating {
        return UserRating(userId, listOf(Rating(105,8), Rating(106,9)))
    }

}
