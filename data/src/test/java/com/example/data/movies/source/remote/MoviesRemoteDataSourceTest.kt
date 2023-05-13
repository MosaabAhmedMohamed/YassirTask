package com.example.data.movies.source.remote

import androidx.paging.*
import com.example.data.DataFixtures
import com.example.data.movies.source.local.MoviesLocalDataSource
import com.example.data.movies.source.local.RemoteKeysLocalDataSource
import com.example.data.movies.source.remote.api.MoviesApi
import com.example.data.movies.source.remote.model.MovieModel
import com.example.data.movies.source.remote.model.MoviesResponseModel
import junit.framework.Assert.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okio.IOException
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn

class MoviesRemoteDataSourceTest{


    @Mock
    internal lateinit var moviesApi: MoviesApi
    @Mock
    internal lateinit var  moviesLocalDataSource: MoviesLocalDataSource
    @Mock
    internal lateinit var  remoteKeysLocalDataSource: RemoteKeysLocalDataSource


    private lateinit var cut: MoviesRemoteDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        moviesApi = org.mockito.kotlin.mock {
            runBlocking {
                on( mock.fetchMoviesList(0)) doReturn DataFixtures.getMoviesResponse()
            }


        }
        moviesLocalDataSource = org.mockito.kotlin.mock {}
        remoteKeysLocalDataSource = org.mockito.kotlin.mock {}

        cut = MoviesRemoteDataSource(moviesApi,moviesLocalDataSource,remoteKeysLocalDataSource)
    }


    @OptIn(ExperimentalPagingApi::class)
    @Test
// Since load is a suspend function, runTest is used to ensure that it
// runs on the test thread.
    fun refreshLoadReturnsSuccessResultWhenMoreDataIsPresent() =  runTest {
        // Add mock results for the API to return.

        Mockito.`when`(moviesApi.fetchMoviesList(1))
            .thenAnswer { MoviesResponseModel(page = 1, totalPages = 5,DataFixtures.getMoviesResponse().results) }

        val pagingState = PagingState<Int, MovieModel>(
            listOf(),
            null,
            PagingConfig(10),
            10
        )
        val result = cut.load(LoadType.REFRESH, pagingState)


        assert(result is  RemoteMediator.MediatorResult.Success)
        assert(!(result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadSuccessAndEndOfPaginationWhenNoMoreData() = runTest {
        // To test endOfPaginationReached, don't set up the mockApi to return post
        // data here.
        Mockito.`when`(moviesApi.fetchMoviesList(1))
            .thenAnswer { MoviesResponseModel(page = 1, totalPages = 1) }


        val pagingState = PagingState<Int, MovieModel>(
            listOf(),
            null,
            PagingConfig(10),
            10
        )
        val result = cut.load(LoadType.REFRESH, pagingState)

        assert ( result is RemoteMediator.MediatorResult.Success )
        assert((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnsErrorResultWhenErrorOccurs() = runTest {
        // Set up failure message to throw exception from the mock API.
        Mockito.`when`(moviesApi.fetchMoviesList(1))
            .thenAnswer { throw IOException() }

        val pagingState = PagingState<Int, MovieModel>(
            listOf(),
            null,
            PagingConfig(10),
            10
        )
        val result = cut.load(LoadType.REFRESH, pagingState)

        assert (result is RemoteMediator.MediatorResult.Error )
    }


}