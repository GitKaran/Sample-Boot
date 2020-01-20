package com.example.springboot.repository

import com.example.springboot.model.Movie
import org.jooq.DSLContext
import org.jooq.generated.Tables.CATALOG_ITEM
import org.springframework.stereotype.Repository

@Repository
class CatalogRepository(
    private val dsl: DSLContext
) {
    fun deleteMovieFromCatalog(movieId: Int) =
        dsl.deleteFrom(CATALOG_ITEM)
            .where(CATALOG_ITEM.MOVIE_ID.eq(movieId))
            .execute()

    fun addMovieToCatalog(movie: Movie, rating:Int) =
        dsl.insertInto(CATALOG_ITEM)
            .set(CATALOG_ITEM.MOVIE_ID, movie.movieId)
            .set(CATALOG_ITEM.NAME, movie.name)
            .set(CATALOG_ITEM.DESCRIPTION, movie.description)
            .set(CATALOG_ITEM.RATING, rating)
            .execute()
}
