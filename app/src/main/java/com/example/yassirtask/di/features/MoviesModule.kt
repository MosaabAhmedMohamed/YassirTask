package com.example.yassirtask.di.features

import com.example.data.movies.repository.MoviesRepositoryImpl
import com.example.data.movies.source.remote.api.MoviesApi
import com.example.domain.movies.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class ArticlesModule {

    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    fun provideMoviesRepository(
        moviesApi: MoviesApi
    ): MoviesRepository =
        MoviesRepositoryImpl(moviesApi)
}