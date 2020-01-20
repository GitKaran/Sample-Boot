package com.example.springboot.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class Movie(
    @get: NotNull val movieId: Int,
    @get: NotBlank val name: String,
    @get: NotBlank val description: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieSummary(
    val id: Int,
    val title: String?,
    val overview: String?
)
