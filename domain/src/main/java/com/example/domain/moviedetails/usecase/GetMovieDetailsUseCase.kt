package com.example.domain.moviedetails.usecase

import com.example.domain.moviedetails.repository.MovieDetailsRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) {

    suspend fun loadMovieDetails(movieId: Long) = movieDetailsRepository
        .loadMovieDetails(movieId)
}