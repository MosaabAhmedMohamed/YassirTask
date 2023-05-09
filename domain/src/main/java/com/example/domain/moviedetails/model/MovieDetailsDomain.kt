package com.example.domain.moviedetails.model

data class MovieDetailsDomain(
    val originalLanguage: String? = null,
    val title: String? = null,
    val backdropPath: String? = null,
    val revenue: Long? = null,
    val genres: List<String>? = null,
    val id: Long? = null,
    val voteCount: Long? = null,
    val budget: Long? = null,
    val overview: String? = null,
    val originalTitle: String? = null,
    val runtime: Long? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Any? = null,
    val tagline: String? = null,
    val adult: Boolean? = null,
    val homepage: String? = null,
)
