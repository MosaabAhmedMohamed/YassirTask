package com.example.yassirtask.di.module

import android.content.Context
import androidx.room.Room
import com.example.data.db.DB_NAME
import com.example.data.db.YassirTaskDatabase
import com.example.data.moviedetails.source.local.dao.MovieDetailsDao
import com.example.data.movies.source.local.dao.MoviesDao
import com.example.data.movies.source.local.dao.RemoteKeysDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): YassirTaskDatabase {
        return Room.databaseBuilder(context, YassirTaskDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesDao(db:YassirTaskDatabase): MoviesDao {
        return db.moviesDao()
    }

    @Provides
    @Singleton
    fun provideRemoteKeysDao(db:YassirTaskDatabase): RemoteKeysDao {
        return db.remoteKeysDao()
    }

    @Provides
    @Singleton
    fun provideMovieDetailsDao(db:YassirTaskDatabase): MovieDetailsDao {
        return db.movieDetailsDao()
    }

}