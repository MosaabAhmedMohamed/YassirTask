package com.example.data.movies.source.local

import com.example.data.DataFixtures
import com.example.data.movies.source.local.dao.MoviesDao
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class MoviesLocalDataSourceTest{


    @Mock
    internal lateinit var dao: MoviesDao

    private lateinit var cut: MoviesLocalDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        dao = org.mockito.kotlin.mock { }

        cut = MoviesLocalDataSource(dao)
    }

    @Test
    fun `getMovies verify dao is called`() {
        runBlocking {
            // when
            cut.getMovies()

            // verify
            verify(dao, times(1)).getMovies()

        }
    }

    @Test
    fun `insertMovies verify dao is called`() {
        runBlocking {
            // when
            cut.insertMovies(DataFixtures.getMoviesResponse().results)

            // verify
            verify(dao, times(1)).insertMovies(DataFixtures.getMoviesResponse().results)
        }
    }

    @Test
    fun `deleteAllMovies verify dao is called`() {
        runBlocking {
            // when
            cut.deleteAllMovies()

            // verify
            verify(dao, times(1)).deleteAllMovies()
        }
    }
}