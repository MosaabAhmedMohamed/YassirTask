package com.example.yassirtask.di.features


import com.example.core.util.DispatcherProvider
import com.example.data.db.YassirTaskDatabase
import com.example.data.movies.repository.MoviesRepositoryImpl
import com.example.data.movies.source.local.MoviesLocalDataSource
import com.example.data.movies.source.local.RemoteKeysLocalDataSource
import com.example.data.movies.source.local.dao.MoviesDao
import com.example.data.movies.source.local.dao.RemoteKeysDao
import com.example.data.movies.source.remote.MoviesRemoteDataSource
import com.example.data.movies.source.remote.api.MoviesApi
import com.example.domain.movies.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class MoviesModule {

    @Provides
    fun provideMoviesLocalDataSource(
        db: YassirTaskDatabase
    ): MoviesLocalDataSource =
        MoviesLocalDataSource(db.moviesDao())

    @Provides
    fun provideRemoteKeysLocalDataSource(
        db: YassirTaskDatabase
    ): RemoteKeysLocalDataSource =
        RemoteKeysLocalDataSource(db.remoteKeysDao())

    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    fun provideMoviesRemoteDataSource(
        moviesApi: MoviesApi,
        moviesLocalDataSource: MoviesLocalDataSource,
        remoteKeysLocalDataSource: RemoteKeysLocalDataSource,
    ): MoviesRemoteDataSource =
        MoviesRemoteDataSource(
            moviesApi,
            moviesLocalDataSource,
            remoteKeysLocalDataSource,
        )

    @Provides
    fun provideMoviesRepository(
        moviesLocalDataSource: MoviesLocalDataSource,
        moviesRemoteDataSource: MoviesRemoteDataSource
    ): MoviesRepository =
        MoviesRepositoryImpl(moviesLocalDataSource, moviesRemoteDataSource)

}