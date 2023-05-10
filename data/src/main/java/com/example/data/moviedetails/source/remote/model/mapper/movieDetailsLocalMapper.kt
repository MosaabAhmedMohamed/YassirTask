package com.example.data.moviedetails.source.remote.model.mapper

import com.example.data.moviedetails.source.remote.model.GenresItem
import com.example.data.moviedetails.source.remote.model.MovieDetailsResponse
import com.example.domain.moviedetails.model.MovieDetailsDomain

fun MovieDetailsResponse.mapToDomain(): MovieDetailsDomain {
    return MovieDetailsDomain(
        title = title,
        backdropPath = backdropPath,
        revenue = revenue,
        genres = genres.mapToDomain(),
        id = id,
        voteCount = voteCount,
        budget = budget,
        overview = overview,
        voteAverage = voteAverage,
        originalTitle = originalTitle,
        runtime = runtime,
        posterPath = posterPath,
        releaseDate = releaseDate,
        tagline = tagline,
        adult = adult,
        homepage = homepage
    )
}

fun List<GenresItem>?.mapToDomain(): List<String> {
    return this?.map { it.name?:"" }?: emptyList()
}
