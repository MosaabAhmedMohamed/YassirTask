package com.example.domain.moviedetails.model

data class MovieDetailsDomain(
    val originalLanguage: String? = null,
    val title: String? = null,
    val backdropPath: String? = null,
    val revenue: Int? = null,
    val genres: List<GenresItemDomain>? = null,
    val id: Int? = null,
    val voteCount: Int? = null,
    val budget: Int? = null,
    val overview: String? = null,
    val originalTitle: String? = null,
    val runtime: Int? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Any? = null,
    val tagline: String? = null,
    val adult: Boolean? = null,
    val homepage: String? = null,
)

data class GenresItemDomain(
    val name: String? = null,
    val id: Int? = null
)