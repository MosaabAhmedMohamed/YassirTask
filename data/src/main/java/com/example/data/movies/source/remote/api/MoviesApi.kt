package com.example.data.movies.source.remote.api

import com.example.data.movies.source.remote.model.MoviesResponseModel
import retrofit2.http.GET

interface MoviesApi {

    @GET("/3/discover/movie")
    suspend fun fetchMoviesList(): MoviesResponseModel
}