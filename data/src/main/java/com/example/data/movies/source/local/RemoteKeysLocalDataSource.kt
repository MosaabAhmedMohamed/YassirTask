package com.example.data.movies.source.local

import androidx.paging.PagingState
import com.example.data.movies.source.local.dao.RemoteKeysDao
import com.example.data.movies.source.local.model.RemoteKeys
import com.example.data.movies.source.remote.model.MovieModel
import javax.inject.Inject

class RemoteKeysLocalDataSource @Inject constructor(private val dao: RemoteKeysDao) {


    suspend fun insertAll(remoteKey: List<RemoteKeys>) = dao.insertAll(remoteKey)

    suspend fun getRemoteKeyByMovieID(id: Int) = dao.getRemoteKeyByMovieID(id)

    suspend fun clearRemoteKeys() = dao.clearRemoteKeys()

    suspend fun getCreationTime() = dao.getCreationTime()

    suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, MovieModel>): RemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                getRemoteKeyByMovieID(id)
            }
        }
    }

    suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, MovieModel>): RemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { movie ->
            getRemoteKeyByMovieID(movie.id)
        }
    }

    suspend fun getRemoteKeyForLastItem(state: PagingState<Int, MovieModel>): RemoteKeys? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { movie ->
            getRemoteKeyByMovieID(movie.id)
        }
    }

    fun buildRemoteKey(
        page: Int,
        movies: List<MovieModel>
    ): List<RemoteKeys> {
        val prevKey = if (page > 1) page - 1 else null
        val nextKey = if (movies.isEmpty()) null else page + 1
        val remoteKeys = movies.map {
            RemoteKeys(
                movieID = it.id,
                prevKey = prevKey,
                currentPage = page,
                nextKey = nextKey
            )
        }
        return remoteKeys
    }
}