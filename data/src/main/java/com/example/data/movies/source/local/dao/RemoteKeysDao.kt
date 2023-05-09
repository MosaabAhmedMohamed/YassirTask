package com.example.data.movies.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.movies.source.local.model.RemoteKeys

@Dao
interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("Select * From RemoteKeys Where movie_id = :id")
    suspend fun getRemoteKeyByMovieID(id: Int): RemoteKeys?

    @Query("Delete From RemoteKeys")
    suspend fun clearRemoteKeys()

    @Query("Select created_at From RemoteKeys Order By created_at DESC LIMIT 1")
    suspend fun getCreationTime(): Long?
}