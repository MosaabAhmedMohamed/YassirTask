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
        // My Movies text
        Text(
            text =  stringResource(R.string.app_name),
            style = YassirTheme.typography.mencoBold18,
            color = YassirTheme.colors.black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Space
        Spacer(modifier = Modifier.height(16.dp))

        if (state.movies != null)
        // Movies list
            MoviesList(
                movies = state.movies!!.collectAsLazyPagingItems(),
                onItemClick = { index, item ->
                    onEvent(Event.OnItemClick(item))
                },
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
