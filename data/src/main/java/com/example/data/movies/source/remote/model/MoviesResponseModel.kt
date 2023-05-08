package com.example.data.movies.source.remote.model


data class MoviesResponseModel(
    val page: Int? = null,
    val totalPages: Int? = null,
    val results: List<MovieModel> = emptyList(),
    val totalResults: Int? = null
)