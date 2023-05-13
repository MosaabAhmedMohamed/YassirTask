package com.example.yassirtask.features.movies

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.movies.contract.MoviesContract.State
import com.example.presentation.movies.contract.MoviesContract.Event
import com.example.yassirtask.R
import com.example.yassirtask.composables.PagingState
import com.example.yassirtask.theme.YassirTheme

@Composable
fun MoviesContentContainer(
    state: State,
    onEvent: (event: Event) -> Unit
) {

    val horizontalPadding = 16.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = horizontalPadding)

    ) {

        // Space
        Spacer(modifier = Modifier.height(16.dp))
        val moviesState = state.movies.collectAsLazyPagingItems()

        when(moviesState.itemCount){
            0-> {
                // Handle Loading error state
                Column {
                    PagingState(
                        loadState = moviesState.loadState.mediator,
                        itemCount = moviesState.itemCount,
                        onRefresh = { moviesState.refresh() }
                    )
                }
            }else->{
            // Movies list
            MoviesList(
                movies = moviesState,
                onItemClick = { _, item ->
                    onEvent(Event.OnItemClick(item))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                prefixContent = {
                    // Subtitle text
                    Column {
                        Text(
                            text = stringResource(id = R.string.trending_movies),
                            style = YassirTheme.typography.poppinsSemiBold16,
                            color = YassirTheme.colors.textPrimary,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )

                        Text(
                            text = stringResource(id = R.string.trending_movies_desc),
                            style = YassirTheme.typography.poppinsRegular14,
                            color = YassirTheme.colors.textPrimary,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
            )
            }
        }
    }
}
