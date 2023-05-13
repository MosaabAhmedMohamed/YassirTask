package com.example.yassirtask.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.LoadStates
import com.example.yassirtask.R
import com.example.yassirtask.theme.YassirTheme


@Composable
fun PagingState(
    loadState: LoadStates?,
    itemCount: Int,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        if (loadState?.refresh == LoadState.Loading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    style = YassirTheme.typography.mencoBold16,
                    color = YassirTheme.colors.textPrimary,
                    text = stringResource(id = R.string.refresh_loading)
                )

                CircularProgressIndicator(color = YassirTheme.colors.gold)
            }
        }

        if (loadState?.append == LoadState.Loading) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(color = YassirTheme.colors.gold)
            }
        }

        if (loadState?.refresh is LoadState.Error || loadState?.append is LoadState.Error) {
            val isPaginatingError = (loadState.append is LoadState.Error) || itemCount > 1
            val error = if (loadState.append is LoadState.Error)
                (loadState.append as LoadState.Error).error
            else
                (loadState.refresh as LoadState.Error).error

            val modifier = if (isPaginatingError) {
                Modifier.padding(8.dp)
            } else {
                Modifier.fillMaxSize()
            }
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (!isPaginatingError) {
                    Icon(
                        modifier = Modifier.size(64.dp),
                        imageVector = Icons.Rounded.Warning,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = null
                    )
                }

                Text(
                    modifier = Modifier.padding(8.dp),
                    text = error.message ?: error.toString(),
                    color = YassirTheme.colors.textPrimaryVariant,
                    textAlign = TextAlign.Center,
                )

                FilledCharcoalGreyButton(
                    text = stringResource(id = R.string.refresh),
                    onClick = { onRefresh() }
                )
            }
        }
    }
}