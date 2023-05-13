package com.example.data.moviedetails.source.local

import com.example.data.moviedetails.source.local.dao.MovieDetailsDao
import com.example.data.moviedetails.source.local.model.MovieDetailsLocal
import java.io.IOException
import javax.inject.Inject

class MovieDetailsLocalDataSource @Inject constructor(
    private val movieDetailsDao: MovieDetailsDao
) {

    suspend fun getMovie(id: Long): MovieDetailsLocal? {
        return  try {
            movieDetailsDao.getMovie(id)
        }catch (error: IOException){
            null
        }
    }

    suspend fun insertMovie(movies: MovieDetailsLocal) {
        movieDetailsDao.insertMovie(movies)
    }

    suspend fun deleteAllMovies() {
        movieDetailsDao.deleteAllMovies()
    }
}