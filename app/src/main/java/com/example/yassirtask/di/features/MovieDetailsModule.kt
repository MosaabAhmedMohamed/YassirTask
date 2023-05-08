package com.example.yassirtask.di.features

import com.example.data.moviedetails.repository.MovieDetailsRepositoryImpl
import com.example.data.moviedetails.source.remote.api.MovieDetailsApi
import com.example.domain.moviedetails.repository.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class MovieDetailsModule {

    @Provides
    fun provideMovieDetailsApiService(retrofit: Retrofit): MovieDetailsApi {
        return retrofit.create(MovieDetailsApi::class.java)
    }

    @Provides
    fun provideMoviesRepository(
        movieDetailsApi: MovieDetailsApi
    ): MovieDetailsRepository =
        MovieDetailsRepositoryImpl(movieDetailsApi)
}