package com.example.domain.movies.usecase

import androidx.paging.PagingData
import com.example.domain.DataFixtures
import com.example.domain.movies.repository.MoviesRepository
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

class GetMoviesUseCaseTest{



    // https://proandroiddev.com/caching-and-pagination-with-paging-3-in-android-jetpack-compose-b636aaf116ce
    @Mock
    internal lateinit var  moviesRepository: MoviesRepository

    private lateinit var cut: GetMoviesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        moviesRepository = org.mockito.kotlin.mock {}

        cut = GetMoviesUseCase(moviesRepository)
    }


    @Test
    fun `loadMovies return PagingData verify Repo called`() {
        // given
        runBlocking {

            val pagingData = PagingData.from(DataFixtures.getMoviesList())
            Mockito.`when`(moviesRepository.loadMovies())
                .thenAnswer { flowOf(pagingData)  }

            cut.loadMovies()

            verify(moviesRepository, times(1)).loadMovies()
        }

    }

    @Test
    fun `loadMovies return PagingData Success`() {
        runBlocking {
            val pagingData = PagingData.from(DataFixtures.getMoviesList())
            Mockito.`when`(moviesRepository.loadMovies())
                .thenAnswer { flowOf(pagingData)  }

            val result =  cut.loadMovies().first()

            result shouldBeEqualTo pagingData
        }
    }

}