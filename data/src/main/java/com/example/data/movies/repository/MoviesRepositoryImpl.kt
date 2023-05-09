package com.example.data.movies.repository

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.example.core.util.DispatcherProvider
import com.example.data.movies.source.local.MoviesLocalDataSource
import com.example.data.movies.source.remote.MoviesRemoteDataSource
import com.example.data.movies.source.remote.api.MoviesApi
import com.example.data.movies.source.remote.model.mapper.mapToDomain
import com.example.domain.movies.model.MovieDomainModel
import com.example.domain.movies.repository.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val  moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun loadMovies() =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = 10,
                initialLoadSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
               moviesLocalDataSource.getMovies()
            },
            remoteMediator = moviesRemoteDataSource
        ).flow.map {
            it.map { it.mapToDomain() }
        }

}