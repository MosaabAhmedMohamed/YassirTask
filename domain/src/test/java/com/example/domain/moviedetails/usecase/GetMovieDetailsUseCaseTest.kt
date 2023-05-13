package com.example.domain.moviedetails.usecase

import com.example.domain.DataFixtures
import com.example.domain.moviedetails.repository.MovieDetailsRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class GetMovieDetailsUseCaseTest {


    @Mock
    internal lateinit var movieDetailsRepository: MovieDetailsRepository

    private lateinit var cut: GetMovieDetailsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        movieDetailsRepository = org.mockito.kotlin.mock { }

        cut = GetMovieDetailsUseCase(movieDetailsRepository)
    }

    @Test
    fun `loadMovieDetails verify Repository is called`() {
        // given
        val movieId = 10L
        runBlocking {
            Mockito.`when`(movieDetailsRepository.loadMovieDetails(movieId))
                .thenAnswer { DataFixtures.getMovieDomain() }

            // when
            cut.loadMovieDetails(movieId)

            // verify
            verify(movieDetailsRepository, times(1)).loadMovieDetails(movieId)
        }
    }

    @Test
    fun `loadMovieDetails return Movie success`() {
        // given
        val movieId = 10L
        runBlocking {
            Mockito.`when`(movieDetailsRepository.loadMovieDetails(movieId))
                .thenAnswer { flowOf(DataFixtures.getMovieDomain()) }

            // when
            val result = cut.loadMovieDetails(movieId).first()

            // then
            result shouldBeEqualTo DataFixtures.getMovieDomain()
        }
    }

    @Test
    fun `loadMovieDetails return null`() {
        // given
        val movieId = 10L

        runBlocking {
            Mockito.`when`(movieDetailsRepository.loadMovieDetails(movieId = movieId))
                .thenAnswer { flowOf(null) }

            // when
            val result = cut.loadMovieDetails(movieId).first()

            // then
            runBlocking {
                result shouldBeEqualTo null
            }
        }
    }

}