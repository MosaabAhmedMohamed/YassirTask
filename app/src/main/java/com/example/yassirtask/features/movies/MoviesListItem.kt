package com.example.yassirtask.features.movies

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.movies.model.MovieUiModel
import com.example.yassirtask.composables.GrayRemoteImage
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
                imageUrl = movie.backdropPath,
                description = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(end = YassirTheme.spacing.m)
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
                        color = YassirTheme.colors.black,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Address text
                movie.overview?.let {
                    Text(
                        text = it,
                        style = YassirTheme.typography.poppinsRegular14,
                        color = YassirTheme.colors.middleGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }


                // Services text
                Text(
                    text = "servicesStr",
                    style = YassirTheme.typography.poppinsRegular14,
                    color = YassirTheme.colors.black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Arrow icon
            Image(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = null,
                colorFilter = ColorFilter.tint(YassirTheme.colors.stroke),
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
    /* ContractorListItem(
         contractor = ContractorListItemUIModel(
             id = 0,
             title = "Contractor Contracting LLC.",
             address = "Los Angeles, CA",
             firstService = "Roofing",
             servicesCount = 5,
             imageUrl = null
         ),
         onClick = {},
         onChecked = {}
     )*/
}
