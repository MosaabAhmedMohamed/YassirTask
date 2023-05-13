package com.example.yassirtask.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yassirtask.theme.YassirTheme

@Composable
fun ErrorWithAction(
    title: String,
    body: String,
    buttonText: String,
    onNegative: () -> Unit,
    onPositive: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.background
) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Close",
            tint = YassirTheme.colors.textPrimaryVariant,
            modifier = Modifier.clickable { onNegative() }
        )

        Error(title = title, body = body)

        Spacer(modifier = Modifier.padding(YassirTheme.spacing.xl))

        FilledCharcoalGreyButton(
            text = buttonText,
            onClick = onPositive
        )
    }

}

@Composable
fun Error(
    title: String,
    body: String,
    backgroundColor: Color = MaterialTheme.colors.background,
    horizontalAlignment: Alignment.Horizontal = Alignment.End,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        modifier = modifier.padding(horizontal = 16.dp).wrapContentHeight(),
    ) {

        MessageBody(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            color = YassirTheme.colors.textPrimary,
            style = YassirTheme.typography.poppinsBold16
        )

        Spacer(modifier = Modifier.padding(YassirTheme.spacing.l))

        MessageBody(
            text = body,
            modifier = Modifier.fillMaxWidth(),
            color = YassirTheme.colors.textSecondary,
            style = YassirTheme.typography.poppinsH3.copy(
                lineHeight = 18.sp
            )
        )
    }

}