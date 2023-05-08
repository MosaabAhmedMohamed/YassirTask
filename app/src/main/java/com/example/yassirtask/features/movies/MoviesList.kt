package com.example.yassirtask.features.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.movies.model.MovieUiModel
import com.example.yassirtask.composables.loadingMoreIndicator.LoadingMoreIndicator

@Composable
fun MoviesList(
    movies: List<MovieUiModel>?,
    onItemClick: (Int, MovieUiModel) -> Unit,
    onReachedListEnd: () -> Unit,
    isLoadingMore: Boolean = false,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    prefixContent: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = contentPadding,
        modifier = modifier.fillMaxWidth()
    ) {
        // Render prefix content if exists
        if (prefixContent != null) item {
            prefixContent()
        }

        // Render contractor items
        movies?.let {
            itemsIndexed(
                items = movies,
                key = { index, _ -> index }
            ) { index, item ->
                // Render contractor item
                MoviesListItem(
                    movie = item,
                    onClick = {
                        onItemClick.invoke(index, item)
                    }
                )

                // Notify reached list end callback if it's list end
                if (index == movies.lastIndex) {
                    onReachedListEnd.invoke()
                }
            }
        }



        // Render loading more indicator if required
        if (isLoadingMore) item {
            LoadingMoreIndicator()
        }
    }
}

@Preview
@Composable
fun MoviesListPreview() {
    /* ContractorsList(
         contractors = listOf(
             ContractorListItemUIModel(
                 id = 0,
                 title = "Contractor Contracting LLC.",
                 address = "Los Angeles, CA",
                 firstService = "Roofing",
                 servicesCount = 5,
                 imageUrl = null
             ),
             ContractorListItemUIModel(
                 id = 0,
                 title = "Contractor Contracting LLC.",
                 address = "Los Angeles, CA",
                 firstService = "Plumbing",
                 servicesCount = 11,
                 imageUrl = null
             )
         ),
         onItemClick = { _, _ -> },
         onItemChecked = { _, _ -> },
         onReachedListEnd = {}
     )*/
}

