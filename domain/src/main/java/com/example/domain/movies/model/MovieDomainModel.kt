package com.example.domain.movies.model

data class MovieDomainModel(
    val overview: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Long? = null,
    val id: Long? = null,
    val adult: Boolean? = null,
    val voteCount: Int? = null
)