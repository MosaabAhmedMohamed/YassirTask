package com.example.presentation

import com.example.domain.moviedetails.model.MovieDetailsDomain
import com.example.presentation.moviedetails.model.MovieDetailsUiModel

object DataFixtures {

    internal fun getMovieDomain() = MovieDetailsDomain(
        title = "title",
        backdropPath = "backdropPath",
        genres = listOf("genres1","genres2"),
        id = 10,
        overview = "overview",
        originalTitle = "originalTitle",
        runtime = 100,
        posterPath = "posterPath",
        releaseDate = "releaseDate",
        voteAverage = 8.5F,
        tagline = "tagline",
    )

    internal fun getMovieUi() = MovieDetailsUiModel(
        title = "title",
        backdropPath = "backdropPath",
        genres = listOf("genres1","genres2"),
        id = 10,
        overview = "overview",
        originalTitle = "originalTitle",
        runtime = 100,
        posterPath = com.example.core.BuildConfig.IMAGE_BASE_URL.plus("posterPath"),
        releaseDate = "releaseDate",
        voteAverage = 8.5F,
        tagline = "tagline",
    )

}
