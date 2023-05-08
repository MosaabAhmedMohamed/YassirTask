package com.example.yassirtask.features.movies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.base.SIDE_EFFECTS_KEY
import com.example.presentation.movies.contract.MoviesContract.Effect
import com.example.presentation.movies.viewmodel.MoviesViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.onEach


@Destination(start = true)
@Composable
fun MoviesScreen(navigator: DestinationsNavigator,
                 viewModel: MoviesViewModel = hiltViewModel()
) {

    // Handle side effects
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        viewModel.effect.onEach { effect ->
            when (effect) {
                is Effect.Navigation.ToMovieDetails -> {

                    // navigator.navigate(ArticleDetailScreenDestination(project = effect.project))
                }
            }
        }.collect{}
    }
    // Render movies content
    MoviesContentContainer(
        state = viewModel.viewState.value,
        onEvent = viewModel::setEvent
    )
}