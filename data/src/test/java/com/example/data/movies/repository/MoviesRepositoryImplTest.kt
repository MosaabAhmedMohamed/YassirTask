package com.example.data.movies.repository

import com.example.data.movies.source.local.MoviesLocalDataSource
import com.example.data.movies.source.remote.MoviesRemoteDataSource
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MoviesRepositoryImplTest{


    @Mock
    internal lateinit var  moviesLocalDataSource: MoviesLocalDataSource
    @Mock
    internal lateinit var  oviesRemoteDataSource: MoviesRemoteDataSource


    private lateinit var cut: MoviesRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        moviesLocalDataSource = org.mockito.kotlin.mock {}
        oviesRemoteDataSource = org.mockito.kotlin.mock {}

        cut = MoviesRepositoryImpl(moviesLocalDataSource,oviesRemoteDataSource)
    }

}