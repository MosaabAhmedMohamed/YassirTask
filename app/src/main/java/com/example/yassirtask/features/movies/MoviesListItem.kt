package com.example.yassirtask.features.movies

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.movies.model.MovieUiModel
import com.example.yassirtask.R
import com.example.yassirtask.composables.GrayRemoteImage
import com.example.yassirtask.composables.KeyValueRowTV
import com.example.yassirtask.composables.noRippleClickable
import com.example.yassirtask.theme.SmallRoundedCornerCard
import com.example.yassirtask.theme.SmallRoundedCornerImage
import com.example.yassirtask.theme.YassirTheme

@Composable
fun MoviesListItem(
    movie: MovieUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        contentColor = YassirTheme.colors.white,
        elevation = 0.dp,
        shape = SmallRoundedCornerCard,
        border = BorderStroke(
            width = YassirTheme.spacing.unit,
            color = YassirTheme.colors.stroke
        ),
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
                .fillMaxWidth()
        ) {

            // Contractor image
            GrayRemoteImage(
                imageUrl = movie.posterPath,
                description = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = YassirTheme.spacing.m)
                    .size(70.dp)
                    .clip(SmallRoundedCornerImage)
            )

            // Texts column
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(YassirTheme.spacing.extra_xxs)
            ) {
                // Title text
                movie.title?.let {
                    Text(
                        text = it,
                        style = YassirTheme.typography.mencoBold16,
                        color = YassirTheme.colors.textPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // overview text
                movie.overview?.let {
                    Text(
                        text = it,
                        style = YassirTheme.typography.poppinsRegular14,
                        color = YassirTheme.colors.middleGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Release Date
                movie.releaseDate?.let {
                    KeyValueRowTV(
                        key = stringResource(id = R.string.release_date),
                        value = it
                    )
                }
            }

            // Arrow icon
            Image(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                modifier = Modifier
                    .height(14.dp)
                    .padding(end = YassirTheme.spacing.m),
            )
        }
    }
}

@Preview
@Composable
fun MoviesListItemPreview() {
    MoviesListItem(
        movie = MovieUiModel(
             id = 0,
             title = "Contractor Contracting LLC.",
             overview = "Los Angeles, CA",
             releaseDate = "2023",
         ),
         onClick = {},
     )
}
