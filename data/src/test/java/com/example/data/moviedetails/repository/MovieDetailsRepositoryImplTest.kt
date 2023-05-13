package com.example.data.moviedetails.repository

import com.example.data.DataFixtures
import com.example.data.DataFixtures.getMovieResponse
import com.example.data.moviedetails.source.local.MovieDetailsLocalDataSource
import com.example.data.moviedetails.source.remote.api.MovieDetailsApi
import com.example.data.moviedetails.source.remote.model.MovieDetailsResponse
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

internal class MovieDetailsRepositoryImplTest {

    @Mock
    internal lateinit var movieApi: MovieDetailsApi

    @Mock
    internal lateinit var movieLocalDS: MovieDetailsLocalDataSource

    private lateinit var cut: MovieDetailsRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        movieApi = org.mockito.kotlin.mock { }
        movieLocalDS = org.mockito.kotlin.mock {
        }

        cut = MovieDetailsRepositoryImpl(movieApi, movieLocalDS)
    }

    /*  @Test
      fun `getMovie verify local data source is called`() {
          // given
          runBlocking {
              Mockito.`when`(movieLocalDS.getMovie(DataFixtures.getMovie().id))
                  .thenAnswer { DataFixtures.getMovie() }
          }

          // when
          runBlocking { cut.loadMovieDetails(DataFixtures.getMovie().id) }

          // verify
          runBlocking {
              verify(movieLocalDS, times(1)).getMovie(DataFixtures.getMovie().id)
          }
      }*/

    @Test
    fun `getMovie local return null verify API called`() {
        // given
        runBlocking {
            Mockito.`when`(movieLocalDS.getMovie(DataFixtures.getMovie().id))
                .thenAnswer { null }

            Mockito.`when`(movieApi.fetchMovieDetails(DataFixtures.getMovie().id))
                .thenAnswer { MovieDetailsResponse(id = DataFixtures.getMovie().id) }

            // when
            cut.loadMovieDetails(DataFixtures.getMovie().id).first()

            // then
            verify(movieApi, times(1)).fetchMovieDetails(DataFixtures.getMovie().id)
        }
    }

    @Test
    fun `getMovie local return Movie verify API not called`() {
        // given
        runBlocking {
            Mockito.`when`(movieLocalDS.getMovie(DataFixtures.getMovie().id))
                .thenAnswer { DataFixtures.getMovie() }

            // when
            cut.loadMovieDetails(DataFixtures.getMovie().id)

            // then

            verify(movieApi, times(0)).fetchMovieDetails(DataFixtures.getMovie().id)

        }


    }

    @Test
    fun `getMovie local return Movie success`() {
        // given
        runBlocking {
            Mockito.`when`(movieLocalDS.getMovie(DataFixtures.getMovie().id))
                .thenAnswer { DataFixtures.getMovie() }

            // when
            val result = cut.loadMovieDetails(DataFixtures.getMovie().id).first()

            // then
            result shouldBeEqualTo DataFixtures.getMovieDomain()
        }


    }

    @Test
    fun `getMovie local return null call API return Movie success`() {
        // given
        runBlocking {
            Mockito.`when`(movieLocalDS.getMovie(getMovieResponse().id))
                .thenAnswer { null }

            Mockito.`when`(movieApi.fetchMovieDetails(DataFixtures.getMovie().id))
                .thenAnswer { DataFixtures.getMovieResponse() }

            // when
            val result = cut.loadMovieDetails(DataFixtures.getMovie().id).first()

            // then
            runBlocking {
                result shouldBeEqualTo DataFixtures.getMovieDomain()
            }
        }


    }
}