package com.example.presentation.movies.model.mapper

import com.example.domain.movies.model.MovieDomainModel
import com.example.presentation.movies.model.MovieUiModel


fun MovieDomainModel.mapToUi(): MovieUiModel {
    return MovieUiModel(
        overview = overview,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        video = video,
        title = title,
        genreIds = genreIds,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
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