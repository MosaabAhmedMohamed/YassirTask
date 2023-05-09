package com.example.data.moviedetails.repository

import android.annotation.SuppressLint
import com.example.data.moviedetails.source.local.MovieDetailsLocalDataSource
import com.example.data.moviedetails.source.remote.api.MovieDetailsApi
import com.example.data.moviedetails.source.local.model.mapper.mapToDomain
import com.example.data.moviedetails.source.local.model.mapper.mapToLocal
import com.example.domain.moviedetails.repository.MovieDetailsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDetailsApi: MovieDetailsApi,
    private val movieDetailsLocalDataSource: MovieDetailsLocalDataSource
) : MovieDetailsRepository {


    @SuppressLint("SuspiciousIndentation")
    override suspend fun loadMovieDetails(movieId: Int) = flow {
        val localMovie = movieDetailsLocalDataSource.getMovie(movieId)

        localMovie?.let {
            emit(it.mapToDomain())
        } ?: run {
          val remoteToLocal = movieDetailsApi
                .fetchMovieDetails(movieId).mapToLocal()
            movieDetailsLocalDataSource
                .insertMovie(remoteToLocal)
            emit(remoteToLocal.mapToDomain())
        }
    }

}