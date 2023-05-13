package com.example.yassirtask.features.moviedetails

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.presentation.moviedetails.contract.MovieDetailsContract.State
import com.example.presentation.moviedetails.contract.MovieDetailsContract.Event
import com.example.yassirtask.R
import com.example.yassirtask.composables.YassirToolbar

@Composable
fun MovieDetailsContentContainer(
    state: State,
    onEvent: (event: Event) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        BackHandler(enabled = true){
            onEvent(Event.BackClick)
        }

        // Toolbar
        YassirToolbar(
            showBack = true,
            title = stringResource(id = R.string.movie_details),
            onBackClick = {
                onEvent(Event.BackClick)
            }
        )
        state.movie?.let {
            MovieDetail(movie = it)
        }
    }

}