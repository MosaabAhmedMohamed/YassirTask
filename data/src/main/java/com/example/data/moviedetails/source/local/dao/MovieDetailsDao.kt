package com.example.data.moviedetails.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.moviedetails.source.local.model.MovieDetailsLocal

@Dao
interface MovieDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieDetailsLocal)

    @Query("select * from MovieDetailsLocal WHERE id = :id")
    suspend fun getMovie(id: Int): MovieDetailsLocal?

    @Query("delete from MovieDetailsLocal")
    suspend fun deleteAllMovies()

}