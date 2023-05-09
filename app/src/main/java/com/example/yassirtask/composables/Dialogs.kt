package com.example.yassirtask.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.yassirtask.theme.YassirTheme
import com.example.yassirtask.R

@Composable
fun DefaultMessageDialog(
    title: String,
    body: String,
    buttonText: String,
    onNegative: () -> Unit,
    onPositive: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.background
) {
    Dialog(onDismissRequest = onNegative) {
        Card(
            modifier = Modifier.padding(YassirTheme.spacing.primaryPadding),
            shape = MaterialTheme.shapes.large,
            backgroundColor = backgroundColor,
        ) {

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    modifier = Modifier.clickable { onNegative() }
                )

                MessageBody(
                    text = title,
                    modifier = Modifier.fillMaxWidth(),
                    style = YassirTheme.typography.poppinsBold16
                )

                Spacer(modifier = Modifier.padding(YassirTheme.spacing.l))

                MessageBody(
                    text = body,
                    modifier = Modifier.fillMaxWidth(),
                    style = YassirTheme.typography.poppinsH3.copy(
                        lineHeight = 18.sp
                    )
                )

                Spacer(modifier = Modifier.padding(YassirTheme.spacing.xl))

                FilledCharcoalGreyButton(
                    text = buttonText,
                    onClick = onPositive
                )
            }
        }
    }
}

@Composable
fun ChoicesDialog(
    title: String,
    choices: List<String>,
    onChoiceSelected: (String, Int) -> Unit,
    onDismissed: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.background
) {

    Dialog(onDismissRequest = onDismissed) {
        Card(
            modifier = Modifier.padding(YassirTheme.spacing.primaryPadding),
            shape = MaterialTheme.shapes.large,
            backgroundColor = backgroundColor,
        ) {

            Column(
                modifier = Modifier.padding(YassirTheme.spacing.primaryPadding),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    modifier = Modifier.clickable { onDismissed() }
                )

                MessageBody(
                    text = title,
                    modifier = Modifier.fillMaxWidth(),
                    style = YassirTheme.typography.mencoBold16
                )

                Spacer(modifier = Modifier.padding(YassirTheme.spacing.xs))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    contentPadding = PaddingValues(bottom = 12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 175.dp)
                ) {
                    itemsIndexed(
                        items = choices,
                        key = { index, _ -> index }
                    ) { index, item ->
                        FilledCharcoalGreyButton(
                            text = item,
                            backgroundColor = YassirTheme.colors.primaryText,
                            onClick = { onChoiceSelected(item, index) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmationMessageDialog(
    title: String,
    body: String,
    positiveButtonText: String,
    negativeButtonText: String,
    onNegative: () -> Unit,
    onPositive: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.background
) {
    Dialog(onDismissRequest = onNegative) {
        Card(
            shape = MaterialTheme.shapes.large,
            backgroundColor = backgroundColor,
        ) {

            Column(
                modifier = Modifier.padding(YassirTheme.spacing.primaryPadding),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    modifier = Modifier.clickable { onNegative() }
                )

                MessageBody(
                    text = title,
                    modifier = Modifier.fillMaxWidth(),
                    style = YassirTheme.typography.mencoBold16
                )

                Spacer(modifier = Modifier.padding(YassirTheme.spacing.l))

                MessageBody(
                    text = body,
                    modifier = Modifier.fillMaxWidth(),
                    style = YassirTheme.typography.poppinsRegular16
                )

                Spacer(modifier = Modifier.padding(YassirTheme.spacing.xl))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        StrokedTransparentBlackButton(
                            text = negativeButtonText,
                            onClick = onNegative
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        FilledCharcoalGreyButton(
                            text = positiveButtonText,
                            onClick = onPositive
                        )
                    }
                }
            }
        }
    }
}



@Preview
@Composable
fun DialogPreview() {

}
