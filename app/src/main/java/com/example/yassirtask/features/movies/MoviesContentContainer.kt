package com.example.yassirtask.features.movies

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.presentation.movies.contract.MoviesContract.State
import com.example.presentation.movies.contract.MoviesContract.Event
import com.example.yassirtask.theme.YassirTheme


@Composable
fun MoviesContentContainer (
    state: State,
    onEvent: (event: Event) -> Unit
) {

    val horizontalPadding = 16.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = horizontalPadding)

    ) {
        // My cozo projects text
        Text(
            text = "my_projects",
            style = YassirTheme.typography.mencoBold18,
            color = YassirTheme.colors.black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Space
        Spacer(modifier = Modifier.height(16.dp))

        // Contractors list
        MoviesList(
            movies = state.movies,
            onItemClick = { index,item->
                onEvent(Event.OnItemClick(index))
            },
            onReachedListEnd = {
                onEvent(Event.ReachedListEnd)
            },
            isLoadingMore = state.isLoadingMore,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            prefixContent = {
                // Subtitle text
                Column {
                    Text(
                        text = "test 1 ",
                        style = YassirTheme.typography.poppinsSemiBold16,
                        color = YassirTheme.colors.charcoalGrey,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(top = 28.dp)
                            .fillMaxWidth()
                    )

                    Text(
                        text = "test 2 ",
                        style = YassirTheme.typography.poppinsRegular14,
                        color = YassirTheme.colors.charcoalGrey,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        )
    }
}
