package com.example.yassirtask.features.moviedetails

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.moviedetails.contract.MovieDetailsContract.State
import com.example.presentation.moviedetails.contract.MovieDetailsContract.Event
import com.example.yassirtask.composables.YassirToolbar

@Composable
fun MovieDetailsContentContainer(
    state: State,
    onEvent: (event: Event) -> Unit
) {



    if (state.movie != null) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Toolbar
            YassirToolbar(
                showBack = true,
                onBackClick = {
                    onEvent(Event.BackClick)
                }
            )
            state.movie?.let {
                MovieDetail(movie = it)
            }
        }
    }
}