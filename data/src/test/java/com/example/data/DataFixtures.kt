package com.example.data

import com.example.data.moviedetails.source.local.model.MovieDetailsLocal
import com.example.data.moviedetails.source.remote.model.GenresItem
import com.example.data.moviedetails.source.remote.model.MovieDetailsResponse
import com.example.domain.moviedetails.model.MovieDetailsDomain


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

    internal fun getMovie() = MovieDetailsLocal(
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

    internal fun getMovieResponse() = MovieDetailsResponse(
        title = "title",
        backdropPath = "backdropPath",
        genres = listOf(GenresItem(name = "genres1"),GenresItem(name = "genres2")),
        id = 10,
        overview = "overview",
        originalTitle = "originalTitle",
        runtime = 100,
        posterPath = "posterPath",
        releaseDate = "releaseDate",
        voteAverage = 8.5F,
        tagline = "tagline",
    )
}
