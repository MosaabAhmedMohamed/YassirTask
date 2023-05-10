package com.example.presentation.moviedetails.viewmodel

import com.example.core.util.DispatcherProvider
import com.example.domain.moviedetails.usecase.GetMovieDetailsUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.base.IGlobalState
import com.example.presentation.moviedetails.contract.MovieDetailsContract.Event
import com.example.presentation.moviedetails.contract.MovieDetailsContract.Effect
import com.example.presentation.moviedetails.contract.MovieDetailsContract.State
import com.example.presentation.moviedetails.model.mapper.mapToUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    globalState: IGlobalState,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val dispatchers: DispatcherProvider,
    ) : BaseViewModel<Event,
        State,
        Effect>(globalState,dispatchers) {

    private var isInitialized = false

    fun init(
        movieId: Long?
    ) = executeCatching({
        // Validate
        if (isInitialized) return@executeCatching
        if (movieId == null) return@executeCatching

         getMovieDetailsUseCase.loadMovieDetails(movieId)
             .flowOn(dispatchers.io)
             .collectLatest {
                 // Update movie in the state
                 setState {
                     copy(
                         movie = it.mapToUi(),
                     )
                 }
         }

        // Update isInitialized flag
        isInitialized = true
    })


    override fun setInitialState() = State()


    override fun handleEvents(event: Event) = when (event) {
       Event.BackClick -> setEffect { Effect.Navigation.GoBack }
    }

}