package com.example.data.movies.source.remote.model.mapper

import com.example.data.movies.source.remote.model.MovieModel
import com.example.domain.movies.model.MovieDomainModel


fun MovieModel.mapToDomain(): MovieDomainModel {
    return MovieDomainModel(
        overview = overview,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        video = video,
        title = title,
        genreIds = genreIds,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        popularity = popularity,
        voteAverage = voteAverage,
        id = id,
        adult = adult,
        voteCount = voteCount
    )
}

fun List<MovieModel>.mapToDomain(): List<MovieDomainModel> {
    return this.map {
        it.mapToDomain()
    }
}