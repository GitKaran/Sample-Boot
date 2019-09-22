package com.example.springboot.service

import com.example.springboot.model.Rating
import com.example.springboot.model.UserRating
import com.example.springboot.repository.RatingRepository
import org.springframework.stereotype.Service

@Service
class RatingService(
        private val ratingRepository: RatingRepository
) {

    fun getMovieRating(movieId: Int): Rating? {
        return ratingRepository.getMovieRating(movieId)
    }

    fun getUserRatings(userId: Int ): UserRating {
        return UserRating(userId, ratingRepository.getUserRating(userId))
    }

}
