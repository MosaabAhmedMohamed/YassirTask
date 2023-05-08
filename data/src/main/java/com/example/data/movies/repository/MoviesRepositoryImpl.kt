package com.example.data.movies.repository

import com.example.data.movies.source.remote.api.MoviesApi
import com.example.data.movies.source.remote.model.mapper.mapToDomain
import com.example.domain.movies.repository.MoviesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi
) : MoviesRepository {


    override suspend fun loadMovies() = flow {
        emit(moviesApi.fetchMoviesList().results.mapToDomain())
    }
}