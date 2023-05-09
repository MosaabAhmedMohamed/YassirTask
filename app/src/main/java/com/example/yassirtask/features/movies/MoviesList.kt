package com.example.yassirtask.features.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.presentation.movies.model.MovieUiModel

@Composable
fun MoviesList(
    movies: LazyPagingItems<MovieUiModel>,
    onItemClick: (Int, MovieUiModel) -> Unit,
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

        items(
            count = movies.itemCount
        ) { index ->
            val item = movies[index]
            item?.let {
                MoviesListItem(
                    movie = it,
                    onClick = {
                        onItemClick.invoke(index, item)
                    }
                )
            }
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

