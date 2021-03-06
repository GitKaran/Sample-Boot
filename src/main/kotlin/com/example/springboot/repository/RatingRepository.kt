package com.example.springboot.repository

import com.example.springboot.model.Rating
import org.jooq.generated.tables.Rating.RATING
import org.jooq.DSLContext

import org.springframework.stereotype.Repository

@Repository
class RatingRepository(
        private val dsl: DSLContext
) {

    fun getMovieRating(movieId: Int): Rating? {

        return dsl.select(RATING.asterisk())
                .from(RATING)
                .where(RATING.MOVIE_ID.eq(movieId))
                .fetchOne()
                ?.map { record ->
                    Rating(
                            record[RATING.MOVIE_ID],
                            record[RATING.RATING_]
                    )
                }

    }

    fun getUserRating(userId: Int): List<Rating> {

        return dsl.select(RATING.asterisk())
                .from(RATING)
                .where(RATING.USER_ID.eq(userId))
                .map { record ->
                    Rating(
                            record[RATING.MOVIE_ID],
                            record[RATING.RATING_]
                    )
                }
    }

    fun deleteMovieRating(movieId: Int) =
        dsl.deleteFrom(RATING)
            .where(RATING.MOVIE_ID.eq(movieId))
            .execute()

    fun addMovieRating(movieId: Int, ratingId: Int, userId: Int) =
        dsl.insertInto(RATING)
            .set(RATING.MOVIE_ID, movieId)
            .set(RATING.RATING_, ratingId)
            .set(RATING.USER_ID, userId)
            .execute()
}
