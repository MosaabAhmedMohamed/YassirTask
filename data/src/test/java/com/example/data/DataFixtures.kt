package com.example.data

import androidx.paging.PagingSource
import com.example.data.moviedetails.source.local.model.MovieDetailsLocal
import com.example.data.moviedetails.source.remote.model.GenresItem
import com.example.data.moviedetails.source.remote.model.MovieDetailsResponse
import com.example.data.movies.source.local.model.RemoteKeys
import com.example.data.movies.source.remote.model.MovieModel
import com.example.data.movies.source.remote.model.MoviesResponseModel
import com.example.domain.moviedetails.model.MovieDetailsDomain


object DataFixtures {

    internal fun getMovieDomain() = MovieDetailsDomain(
        title = "title",
        backdropPath = "backdropPath",
        genres = listOf("genres1", "genres2"),
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
        genres = listOf("genres1", "genres2"),
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
        genres = listOf(GenresItem(name = "genres1"), GenresItem(name = "genres2")),
        id = 10,
        overview = "overview",
        originalTitle = "originalTitle",
        runtime = 100,
        posterPath = "posterPath",
        releaseDate = "releaseDate",
        voteAverage = 8.5F,
        tagline = "tagline",
    )

    internal fun getMoviesResponse() = MoviesResponseModel(
        results = listOf(
            MovieModel(id = 10, page = 0), MovieModel(id = 1, page = 0)
        )
    )


    internal fun getRemoteKeys() = listOf(
        RemoteKeys(
            movieID = 10L,
            prevKey = 10,
            currentPage = 0,
            nextKey = 0,
            createdAt = 11L
        )
    )

    internal fun getPagesList() =
        listOf(PagingSource.LoadResult.Page(getMoviesResponse().results, 0, 1))
}
