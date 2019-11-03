package com.example.springboot.dto


data class PetDto(
        val id: String,
        val category: CategoryDto,
        val name: String,
        val photoUrls: List<String>,
        val tags: List<TagsDto>,
        val status: String
)


data class CategoryDto(
        val id: String,
        val name: String
)

data class TagsDto(
        val id: String,
        val name: String
)
