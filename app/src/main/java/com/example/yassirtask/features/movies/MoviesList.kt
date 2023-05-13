package com.example.yassirtask.features.movies

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.presentation.movies.model.MovieUiModel
import com.example.yassirtask.composables.PagingState

@Composable
fun MoviesList(
    movies: LazyPagingItems<MovieUiModel>,
    onItemClick: (Int, MovieUiModel) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    prefixContent: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val listState: LazyListState = rememberLazyListState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = contentPadding,
        modifier = modifier.fillMaxWidth(),
        state = listState

    ) {
        // Render prefix content if exists
        if (prefixContent != null) item {
            prefixContent()
        }
            items(
                count = movies.itemCount,
            ) { index ->
                val item = movies[index]
                item?.let {
                    MoviesListItem(
                        movie = it,
                        onClick = {
                            onItemClick.invoke(index, item)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        item {
            PagingState(
                loadState = movies.loadState.mediator,
                itemCount = movies.itemCount,
                onRefresh = { movies.refresh() }
            )
        }

    }
}


