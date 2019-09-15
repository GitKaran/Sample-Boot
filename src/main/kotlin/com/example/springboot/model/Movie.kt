package com.example.springboot.model

data class Movie(
        val movieId: Int,
        val name: String,
        val description: String
)

data class MovieSummary(
        val id: Int,
        val title: String?,
        val overview: String?
)
