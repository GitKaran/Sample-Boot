package com.example.springboot.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

data class Movie(
        val movieId: Int,
        val name: String,
        val description: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieSummary(
        val id: Int,
        val title: String?,
        val overview: String?
)
