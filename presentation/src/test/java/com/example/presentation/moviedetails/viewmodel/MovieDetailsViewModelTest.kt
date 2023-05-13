package com.example.presentation.moviedetails.viewmodel

import com.example.core.util.DispatcherProvider
import com.example.domain.moviedetails.usecase.GetMovieDetailsUseCase
import com.example.presentation.DataFixtures
import com.example.presentation.base.IGlobalState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class MovieDetailsViewModelTest {


    @Mock
    internal lateinit var globalState: IGlobalState

    @Mock
    internal lateinit var getMovieDetailsUseCase: GetMovieDetailsUseCase

    private var testDispatcher: TestDispatcher = UnconfinedTestDispatcher(TestCoroutineScheduler())
    private val testScope = CoroutineScope(testDispatcher)

    private lateinit var cut: MovieDetailsViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        globalState = org.mockito.kotlin.mock { }
        getMovieDetailsUseCase = org.mockito.kotlin.mock { }

        cut = MovieDetailsViewModel(
            globalState,
            getMovieDetailsUseCase,
            DispatcherProvider(main = testDispatcher, io = testDispatcher)
        )

    }

    @Test
    fun `loadMovieDetails verify usecase is called`() {
        // given
        val movieId = 10L
        runBlocking {
            Mockito.`when`(getMovieDetailsUseCase.loadMovieDetails(movieId))
                .thenAnswer { flowOf(DataFixtures.getMovieDomain()) }

            // when
            cut.init(movieId)

            // verify

            verify(getMovieDetailsUseCase, times(1)).loadMovieDetails(movieId)

            cut.viewState.value.movie shouldBeEqualTo DataFixtures.getMovieUi()

        }
    }

    @Test
    fun `loadMovieDetails verify usecase not called`() {
        // given
        val movieId = null

        // verify
        runBlocking {
            // when
            cut.init(movieId)
            verify(getMovieDetailsUseCase, times(0)).loadMovieDetails(0)

            cut.viewState.value.movie shouldBeEqualTo null
        }
    }

    @Test
    fun `loadMovieDetails return Movie success`() {
        // given
        val movieId = 10L

        runBlocking {
            Mockito.`when`(getMovieDetailsUseCase.loadMovieDetails(movieId))
                .thenAnswer { flowOf(DataFixtures.getMovieDomain()) }

            // when
            cut.init(movieId)

            // then
            cut.viewState.value.movie shouldBeEqualTo DataFixtures.getMovieUi()
        }
    }

    @Test
    fun `loadMovieDetails return null state error`() {
        // given
        val movieId = 10L

        runBlocking {
            Mockito.`when`(getMovieDetailsUseCase.loadMovieDetails(movieId = movieId))
                .thenAnswer { throw NullPointerException() }

            // when
            cut.init(movieId)

            // then
            runBlocking {
                cut.viewState.value.movie shouldBeEqualTo null
            }
        }
    }
}