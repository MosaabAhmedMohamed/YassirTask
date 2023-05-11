package com.example.presentation.movies.viewmodel

import androidx.paging.PagingData
import com.example.core.util.DispatcherProvider
import com.example.domain.movies.usecase.GetMoviesUseCase
import com.example.presentation.DataFixtures
import com.example.presentation.base.IGlobalState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class MoviesViewModelTest {


    @Mock
    internal lateinit var globalState: IGlobalState

    @Mock
    internal lateinit var getMoviesUseCase: GetMoviesUseCase

    private var testDispatcher: TestDispatcher = UnconfinedTestDispatcher(TestCoroutineScheduler())

    private lateinit var cut: MoviesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        globalState = org.mockito.kotlin.mock { }
        getMoviesUseCase = org.mockito.kotlin.mock { }

        cut = MoviesViewModel(
            globalState,
            getMoviesUseCase,
            DispatcherProvider(main = testDispatcher, io = testDispatcher)
        )

    }

    @Test
    fun `loadMovies verify usecase is called`() {
        runBlocking {
            // when
            cut.loadMovies()

            verify(getMoviesUseCase, times(1)).loadMovies()

        }
    }

    @Test
    fun `loadMovies return Movies success and state contain Ui model`() {
        runBlocking {

            // given
            val pagingData = flowOf(PagingData.from(DataFixtures.getMoviesDomainList()))
            Mockito.`when`(getMoviesUseCase.loadMovies())
                .thenAnswer { flowOf(pagingData) }

            // when
            cut.loadMovies()


            // then
            assert(cut.viewState.value.movies != null)
        }
    }

}