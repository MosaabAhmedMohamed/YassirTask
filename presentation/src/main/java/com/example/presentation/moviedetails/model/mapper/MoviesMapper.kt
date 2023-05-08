package com.example.presentation.moviedetails.model.mapper

import com.example.domain.moviedetails.model.GenresItemDomain
import com.example.domain.moviedetails.model.MovieDetailsDomain
import com.example.presentation.moviedetails.model.GenresItemUiModel
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
        posterPath = posterPath,
        releaseDate = releaseDate,
        tagline = tagline,
        adult = adult,
        homepage = homepage
    )
}

fun List<GenresItemDomain>?.mapToUi(): List<GenresItemUiModel> {
    return this?.map { GenresItemUiModel(it.name,it.id) }?: emptyList()

}
