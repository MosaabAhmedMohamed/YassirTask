package com.example.presentation.movies.viewmodel

import androidx.paging.map
import com.example.core.util.DispatcherProvider
import com.example.domain.movies.usecase.GetMoviesUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.base.IGlobalState
import com.example.presentation.movies.contract.MoviesContract.Event
import com.example.presentation.movies.contract.MoviesContract.State
import com.example.presentation.movies.contract.MoviesContract.Effect
import com.example.presentation.movies.model.MovieUiModel
import com.example.presentation.movies.model.mapper.mapToUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    globalState: IGlobalState,
    private val getMoviesUseCase: GetMoviesUseCase,
    private val dispatchers: DispatcherProvider,
    ) : BaseViewModel<Event,
       State,
       Effect>(globalState)  {

    suspend fun loadMovies() {
        executeCatching({
            val flow = getMoviesUseCase.loadMovies()
                .flowOn(dispatchers.io)
                .map { it.map { it.mapToUi() } }

            setState { copy(movies = flow ) }
        })
    }

    override fun setInitialState() = State()

    override fun handleEvents(event: Event) = when(event){
        is Event.OnItemClick -> handleMovieItemClick(event.movieUiModel)
    }

    private fun handleMovieItemClick(movieUiModel: MovieUiModel) {
        movieUiModel.id?:return

        // Then navigate to contractor profile
        setEffect { Effect.Navigation.ToMovieDetails(movieUiModel.id) }
    }

}