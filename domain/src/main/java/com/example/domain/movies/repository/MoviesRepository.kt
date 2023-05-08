package com.example.domain.movies.repository

import com.example.domain.movies.model.MovieDomainModel
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun loadMovies(): Flow<List<MovieDomainModel>>

}