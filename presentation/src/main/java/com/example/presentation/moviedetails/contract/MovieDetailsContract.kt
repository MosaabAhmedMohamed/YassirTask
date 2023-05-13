package com.example.presentation.moviedetails.contract

import com.example.presentation.base.ViewEvent
import com.example.presentation.base.ViewSideEffect
import com.example.presentation.base.ViewState
import com.example.presentation.moviedetails.model.MovieDetailsUiModel

class MovieDetailsContract {

    data class State(
        val movie: MovieDetailsUiModel? = null
    ) : ViewState

    sealed class Event : ViewEvent {
        object BackClick : Event()

    }

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object GoBack : Navigation()
        }
    }
}