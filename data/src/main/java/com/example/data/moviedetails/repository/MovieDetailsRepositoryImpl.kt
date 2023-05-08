package com.example.data.moviedetails.repository

import com.example.data.moviedetails.source.remote.api.MovieDetailsApi
import com.example.data.moviedetails.source.remote.model.mapper.mapToDomain
import com.example.domain.moviedetails.repository.MovieDetailsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailsRepositoryImpl@Inject constructor(
    private val movieDetailsApi: MovieDetailsApi
) : MovieDetailsRepository {



    override suspend fun loadMovieDetails(movieId: Int) = flow {
        emit(movieDetailsApi.fetchMovieDetails(movieId).mapToDomain())
    }

}