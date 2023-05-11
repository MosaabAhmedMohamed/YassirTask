package com.example.domain

import com.example.domain.moviedetails.model.MovieDetailsDomain
import com.example.domain.movies.model.MovieDomainModel

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


    internal fun getMoviesList() = listOf(MovieDomainModel())
}
