package com.example.data.moviedetails.source.remote.api

import com.example.data.moviedetails.source.remote.model.MovieDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApi {

    @GET("/3/movie/{movie_id}")
    suspend fun fetchMovieDetails(@Path("movie_id") movieId: Long): MovieDetailsResponse
}