package com.example.data.moviedetails.source.local

import com.example.data.DataFixtures
import com.example.data.moviedetails.source.local.dao.MovieDetailsDao
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

internal class MovieDetailsLocalDataSourceTest {


    @Mock
    internal lateinit var dao: MovieDetailsDao

    private lateinit var cut: MovieDetailsLocalDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        dao = org.mockito.kotlin.mock { }

        cut = MovieDetailsLocalDataSource(dao)
    }

    @Test
    fun `getMovie verify dao is called`() {
        // when
        runBlocking { cut.getMovie(DataFixtures.getMovie().id) }

        // verify
        runBlocking {
            verify(dao, times(1)).getMovie(DataFixtures.getMovie().id)
        }
    }

    @Test
    fun `getMovie DAO return Movie fetches Movie success`() {
        // given
        runBlocking {
            Mockito.`when`(dao.getMovie(DataFixtures.getMovie().id))
                .thenAnswer { DataFixtures.getMovie() }
        }

        // when
        val result = runBlocking { cut.getMovie(DataFixtures.getMovie().id) }

        // then
        result shouldBeEqualTo DataFixtures.getMovie()
    }

    @Test
    fun `getMovie DAO return null`() {
        // given
        runBlocking {
            Mockito.`when`(dao.getMovie(DataFixtures.getMovie().id))
                .thenAnswer { null }
        }

        // when
        val result = runBlocking { cut.getMovie(DataFixtures.getMovie().id) }

        // then
        result shouldBeEqualTo null
    }

    @Test
    fun `insertMovie verify dao is called`() {
        // when
        runBlocking { cut.insertMovie(DataFixtures.getMovie()) }

        // verify
        runBlocking {
            verify(dao, times(1)).insertMovie(DataFixtures.getMovie())
        }
    }

    @Test
    fun `deleteAllMovies verify dao is called`() {
        // when
        runBlocking { cut.deleteAllMovies() }

        // verify
        runBlocking {
            verify(dao, times(1)).deleteAllMovies()
        }
    }

}