package com.example.presentation.movies.model.mapper

import com.example.core.BuildConfig
import com.example.domain.movies.model.MovieDomainModel
import com.example.presentation.movies.model.MovieUiModel

fun MovieDomainModel.mapToUi(): MovieUiModel {
    return MovieUiModel(
        overview = overview,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        video = video,
        title = title,
        posterPath = BuildConfig.IMAGE_BASE_URL.plus(posterPath),
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        id = id,
        adult = adult,
        voteCount = voteCount
    )
}

fun List<MovieDomainModel>.mapToUi(): List<MovieUiModel> {
    return this.map {
        it.mapToUi()
    }
}