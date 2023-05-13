package com.example.data.movies.source.local

import androidx.paging.PagingSource
import com.example.data.movies.source.local.dao.MoviesDao
import com.example.data.movies.source.remote.model.MovieModel
import javax.inject.Inject

class MoviesLocalDataSource @Inject constructor(private val moviesDao: MoviesDao) {


    fun getMovies(): PagingSource<Int, MovieModel> {
        return moviesDao.getMovies()
    }

    suspend fun insertMovies(movies: List<MovieModel>) {
        moviesDao.insertMovies(movies)
    }

    suspend fun deleteAllMovies() {
        moviesDao.deleteAllMovies()
    }
}