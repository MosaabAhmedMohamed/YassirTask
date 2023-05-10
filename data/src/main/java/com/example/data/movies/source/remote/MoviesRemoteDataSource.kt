package com.example.data.movies.source.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.data.movies.source.local.MoviesLocalDataSource
import com.example.data.movies.source.local.RemoteKeysLocalDataSource
import com.example.data.movies.source.remote.api.MoviesApi
import com.example.data.movies.source.remote.model.MovieModel
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteDataSource(
    private val moviesApi: MoviesApi,
    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val remoteKeysLocalDataSource: RemoteKeysLocalDataSource,
) : RemoteMediator<Int, MovieModel>() {

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)

        return if (System.currentTimeMillis() - (remoteKeysLocalDataSource.getCreationTime()
                ?: 0) < cacheTimeout
        ) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MovieModel>
    ): MediatorResult {
        val page: Int = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys =
                    remoteKeysLocalDataSource.getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: 1
            }
            LoadType.PREPEND -> {
                val remoteKeys = remoteKeysLocalDataSource.getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                prevKey ?: return MediatorResult
                    .Success(endOfPaginationReached = remoteKeys != null)

            }
            LoadType.APPEND -> {
                val remoteKeys = remoteKeysLocalDataSource.getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                nextKey ?: return MediatorResult
                    .Success(endOfPaginationReached = remoteKeys != null)
            }
        }
        return loadAndCache(loadType, page)
    }

    private suspend fun loadAndCache(loadType: LoadType, page: Int): MediatorResult {
        return try {
            val apiResponse = moviesApi.fetchMoviesList(page = page)

            val movies = apiResponse.results
            val endOfPaginationReached = movies.isEmpty()

            if (loadType == LoadType.REFRESH) {
                remoteKeysLocalDataSource.clearRemoteKeys()
                moviesLocalDataSource.deleteAllMovies()
            }
            val remoteKeys = remoteKeysLocalDataSource.buildRemoteKey(page, movies)

            remoteKeysLocalDataSource.insertAll(remoteKeys)
            moviesLocalDataSource.insertMovies(movies.onEachIndexed { _, movie ->
                movie.page = page
            })

            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (error: IOException) {
            MediatorResult.Error(error)
        } catch (error: HttpException) {
            MediatorResult.Error(error)
        }
    }
}