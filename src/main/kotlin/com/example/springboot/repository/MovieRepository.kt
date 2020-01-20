package com.example.springboot.repository

import com.example.springboot.model.Movie
import org.jooq.DSLContext
import org.jooq.generated.tables.Movie.MOVIE
import org.springframework.stereotype.Repository

@Repository
class MovieRepository(
    private val dsl: DSLContext
) {
    fun insertMovie(movie: Movie) =
        dsl.insertInto(MOVIE)
            .set(MOVIE.MOVIE_ID, movie.movieId)
            .set(MOVIE.NAME, movie.name)
            .set(MOVIE.DESCRIPTION, movie.description)
            .execute()

    fun deleteMovie(movieId: Int) =
        dsl.deleteFrom(MOVIE)
            .where(MOVIE.MOVIE_ID.eq(movieId))
            .execute()

}
