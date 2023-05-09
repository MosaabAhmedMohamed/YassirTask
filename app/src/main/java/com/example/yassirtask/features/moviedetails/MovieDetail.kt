package com.example.yassirtask.features.moviedetails

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.moviedetails.model.MovieDetailsUiModel
import com.example.yassirtask.composables.GrayRemoteImage
import com.example.yassirtask.theme.SmallRoundedCornerImage
import com.example.yassirtask.theme.YassirTheme

@Composable
fun MovieDetail(
    modifier: Modifier = Modifier,
    movie: MovieDetailsUiModel,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 15.dp,
                end = 15.dp,
            ).scrollable(
                state = scrollState,
                orientation = Orientation.Vertical
            )
    ) {

        Row(modifier = modifier) {
            // Poster
            GrayRemoteImage(
                imageUrl = movie.posterPath,
                description = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(end = YassirTheme.spacing.m)
                    .requiredWidth(180.dp)
                    .requiredHeight(250.dp)
                    .clip(SmallRoundedCornerImage)
            )

            // Meta
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                // Rating
                MovieMeta(key = "Rating", value = movie.voteAverage.toString())

                // Director
                MovieMeta(
                    key = "Duration",
                    value = movie.runtime.toString().plus(" Minutes")
                )

                // Genre
                movie.genres?.joinToString(separator = ", ")
                    ?.let { MovieMeta(key = "Genre", value = it) }
            }
        }

        // Title
        movie.title?.let {
            Text(
                text = it,
                modifier = Modifier.padding(
                    top = 10.dp,
                    bottom = 4.dp
                ),
                style = YassirTheme.typography.mencoBold18,
                color = YassirTheme.colors.black,
            )
        }

        // Desc
        movie.overview?.let {
            Text(
                text = it,
                modifier = Modifier.padding(
                    bottom = 10.dp
                ),
                style = YassirTheme.typography.poppinsRegular14,
                color = YassirTheme.colors.middleGray,
            )
        }
    }
}


@Composable
fun MovieMeta(
    modifier: Modifier = Modifier,
    key: String,
    value: String
) {
    Column(modifier = modifier) {
        // Key
        Text(
            text = key,
            style = YassirTheme.typography.poppinsRegular14,
            color = YassirTheme.colors.middleGray.copy(alpha = 0.5f)
        )

        // Value
        Text(
            style = YassirTheme.typography.mencoBold16,
            text = value
        )

        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Preview
@Composable
fun MovieDetailPreview() {
    MovieDetail(
            movie = MovieDetailsUiModel()
        )
}