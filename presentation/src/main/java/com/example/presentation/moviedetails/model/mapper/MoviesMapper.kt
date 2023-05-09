package com.example.presentation.moviedetails.model.mapper

import com.example.core.BuildConfig
import com.example.domain.moviedetails.model.MovieDetailsDomain
import com.example.presentation.moviedetails.model.MovieDetailsUiModel


fun MovieDetailsDomain.mapToUi(): MovieDetailsUiModel {
    return MovieDetailsUiModel(
        originalLanguage = originalLanguage,
        title = title,
        backdropPath = backdropPath,
        revenue = revenue,
        genres = genres.mapToUi(),
        id = id,
        voteCount = voteCount,
        budget = budget,
        overview = overview,
        voteAverage = voteAverage,
        originalTitle = originalTitle,
        runtime = runtime,
        posterPath = BuildConfig.IMAGE_BASE_URL.plus(posterPath),
        releaseDate = releaseDate,
        tagline = tagline,
        adult = adult,
        homepage = homepage
    )
}

fun List<String>?.mapToUi(): List<String> {
    return this?.map { it }?: emptyList()

}
