package com.example.domain.moviedetails.repository

import com.example.domain.moviedetails.model.MovieDetailsDomain
import kotlinx.coroutines.flow.Flow

interface MovieDetailsRepository {

    suspend fun loadMovieDetails(movieId: Long): Flow<MovieDetailsDomain>

}