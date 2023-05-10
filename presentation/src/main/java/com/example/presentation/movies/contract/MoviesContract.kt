package com.example.presentation.movies.contract

import androidx.paging.PagingData
import com.example.presentation.base.ViewEvent
import com.example.presentation.base.ViewSideEffect
import com.example.presentation.base.ViewState
import com.example.presentation.movies.model.MovieUiModel
import kotlinx.coroutines.flow.Flow

class MoviesContract {

    data class State(
        val movies: Flow<PagingData<MovieUiModel>>? = null,
        ) : ViewState

    sealed class Event : ViewEvent {
        data class OnItemClick(val movieUiModel: MovieUiModel) : Event()
    }

    object Navigation {
        object Routes {
            const val MY_HOME = "myHome"
        }
    }

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            data class ToMovieDetails(val movieId: Long) : Effect()
        }
    }

}