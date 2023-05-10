package com.example.yassirtask.features.moviedetails

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.base.SIDE_EFFECTS_KEY
import com.example.presentation.moviedetails.contract.MovieDetailsContract.Effect
import com.example.presentation.moviedetails.viewmodel.MovieDetailsViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.onEach


@Destination
@Composable
fun MovieDetailsScreen(
    navigator: DestinationsNavigator,
    movieId: Long? = null,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    // Handle side effects
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
              Effect.Navigation.GoBack -> navigator.navigateUp()
            }
        }.collect{}
    }

    // Init view model
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.init(
            movieId = movieId,
        )
    }

    // Then render content
    MovieDetailsContentContainer(
        state = viewModel.viewState.value,
        onEvent = viewModel::setEvent
    )

}