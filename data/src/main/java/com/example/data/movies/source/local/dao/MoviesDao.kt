package com.example.data.movies.source.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.movies.source.remote.model.MovieModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieModel>)

    @Query("select * from MovieModel Order By page")
    fun getMovies(): PagingSource<Int, MovieModel>

    @Query("delete from MovieModel")
    suspend fun deleteAllMovies()

}