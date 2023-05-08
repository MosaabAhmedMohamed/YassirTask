package com.example.presentation.movies.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.domain.movies.usecase.GetMoviesUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.base.IGlobalState
import com.example.presentation.movies.contract.MoviesContract.Event
import com.example.presentation.movies.contract.MoviesContract.State
import com.example.presentation.movies.contract.MoviesContract.Effect
import com.example.presentation.movies.model.mapper.mapToUi
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    globalState: IGlobalState,
    private val getMoviesUseCase: GetMoviesUseCase
) : BaseViewModel<Event,
       State,
       Effect>(globalState)  {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadMovies()
        }
    }

    suspend fun loadMovies() {
        getMoviesUseCase.loadMovies()
            .onCompletion {
                Log.d("TestTAG", ":${it} ")
            }
            // .onStart { uiState.value = ArticlesViewState.Loading }
            .flowOn(Dispatchers.IO)
            .collectLatest {

                // Update state
                setState { copy(movies = it.map { it.mapToUi() }) }
            }
    }

    override fun setInitialState() = State()

    override fun handleEvents(event: Event) = when(event){
        is Event.OnItemClick -> handleMovieItemClick(event.index)
        Event.ReachedListEnd -> {

        }
    }

    private fun handleMovieItemClick(index: Int) {
        // Get contractor data item
        val movieId = viewState.value.movies?.getOrNull(index)?.id?: return

        // Then navigate to contractor profile
        setEffect { Effect.Navigation.ToMovieDetails(movieId) }
    }

/* private fun loadMoreMovies() = executeCatching(
        withLoading = false,
        block = {
            // Validate first
            val paging = moviesPaging ?: return@executeCatching
            if (paging.page >= paging.pageCount) return@executeCatching // Loaded all pages

            // Show loading more progress
            setState { copy(isLoadingMore = true) }

            // Load next contractors page
            val response = getMoviesUseCase.loadMovies(
                page = paging.page.plus(1),
                pageSize = PAGE_SIZE
            )

            // Update current paging
            contractorsPaging = response.meta?.pagination

            // Create the new contractors list
            val updatedContractors = viewState.value.movies.orEmpty().toMutableList()
            updatedContractors.addAll(response.data.orEmpty())

            // Update state
            setState {
                copy(
                    movies = updatedContractors,
                    isLoadingMore = false
                )
            }
        },
        onError = { _, _ ->
            // Hide loading more progress
            setState { copy(isLoadingMore = false) }
        }
    )*/


}