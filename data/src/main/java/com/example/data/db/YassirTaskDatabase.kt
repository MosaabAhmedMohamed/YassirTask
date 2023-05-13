package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.moviedetails.source.local.dao.MovieDetailsDao
import com.example.data.moviedetails.source.local.model.MovieDetailsLocal
import com.example.data.movies.source.local.dao.MoviesDao
import com.example.data.movies.source.local.dao.RemoteKeysDao
import com.example.data.movies.source.local.model.RemoteKeys
import com.example.data.movies.source.remote.model.MovieModel

@Database(
    entities = [MovieModel::class,
        RemoteKeys::class,
        MovieDetailsLocal::class],
    version = YassirTask_DATABASE_VERSION_NUMBER
)
@TypeConverters(Converters::class)
abstract class YassirTaskDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao
    abstract fun remoteKeysDao(): RemoteKeysDao
    abstract fun movieDetailsDao(): MovieDetailsDao

}


const val DB_NAME = "YassirTaskDatabase.db"
const val YassirTask_DATABASE_VERSION_NUMBER = 3