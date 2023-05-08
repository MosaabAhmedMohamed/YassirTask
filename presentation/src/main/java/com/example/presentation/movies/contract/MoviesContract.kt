package com.example.presentation.movies.contract

import com.example.presentation.base.ViewEvent
import com.example.presentation.base.ViewSideEffect
import com.example.presentation.base.ViewState
import com.example.presentation.movies.model.MovieUiModel

class MoviesContract {

    data class State(
        val movies: List<MovieUiModel>? = null,
        val isLoadingMore: Boolean = false,
        ) : ViewState

    sealed class Event : ViewEvent {
        data class OnItemClick(val index: Int) : Event()
        object ReachedListEnd : Event()
    }

    object Navigation {
        object Routes {
            const val MY_HOME = "myHome"
        }
    }

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            data class ToMovieDetails(val movieId: Int) : Effect()
        }
    }

}