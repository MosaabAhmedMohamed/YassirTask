package com.example.yassirtask.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.yassirtask.theme.Gold
import com.example.yassirtask.theme.Shapes
import com.example.yassirtask.theme.TransCharcoalGrey
import com.example.yassirtask.theme.YassirTheme


@Preview
@Composable
fun FilledGoldButton(text: String = "", onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Gold),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 47.dp)
    ) {

        PrimaryButtonText(text = text, color = YassirTheme.colors.primaryText)
    }
}

@Preview
@Composable
fun FilledCharcoalGreyButton(
    text: String = "",
    enabled: Boolean = true,
    isDimmed: Boolean = false,
    backgroundColor: Color = YassirTheme.colors.primaryButtonColor,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isDimmed) TransCharcoalGrey else backgroundColor,
            disabledBackgroundColor = TransCharcoalGrey
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 47.dp)
    ) {
        PrimaryButtonText(text = text)
    }
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = YassirTheme.colors.primaryButtonColor,
            disabledBackgroundColor = YassirTheme.colors.primaryDisabledColor
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        enabled = isEnabled,
        modifier = modifier.defaultMinSize(minHeight = 47.dp)
    ) {
        PrimaryButtonText(text = text)
    }
}

@Composable
fun TextIconButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    isEnabled: Boolean = true,
    isUnderlined: Boolean = false,
    paddingVertical: Dp = 4.dp,
    paddingHorizontal: Dp = 8.dp,
    color: Color = YassirTheme.colors.black,
    iconSize: Dp? = null,
    iconSpacing: Dp = 8.dp,
    textStyle: TextStyle = YassirTheme.typography.poppinsRegular15,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = modifier
            .noRippleClickable(
                enabled = isEnabled,
                onClick = onClick
            )
            .padding(
                vertical = paddingVertical,
                horizontal = paddingHorizontal
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement
    ) {
        if (startIcon != null) {
            Image(
                imageVector = startIcon,
                colorFilter = ColorFilter.tint(color),
                contentDescription = text,
                modifier = if (iconSize != null) Modifier.size(iconSize) else Modifier
            )

            Spacer(modifier = Modifier.width(iconSpacing))
        }

        Text(
            text = text,
            style = textStyle.copy(
                textDecoration = if (isUnderlined) TextDecoration.Underline else TextDecoration.None,
                color = color
            )
        )

        if (endIcon != null) {
            Spacer(modifier = Modifier.width(iconSpacing))

            Image(
                imageVector = endIcon,
                colorFilter = ColorFilter.tint(color),
                contentDescription = text,
                modifier = if (iconSize != null) Modifier.size(iconSize) else Modifier
            )
        }
    }
}

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isUnderlined: Boolean = false,
    paddingVertical: Dp = 4.dp,
    paddingHorizontal: Dp = 8.dp,
    color: Color = YassirTheme.colors.black,
    textStyle: TextStyle = YassirTheme.typography.poppinsMedium14,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = modifier
            .noRippleClickable(
                enabled = isEnabled,
                onClick = onClick
            )
            .padding(
                vertical = paddingVertical,
                horizontal = paddingHorizontal
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement
    ) {
        Text(
            text = text,
            style = textStyle.copy(
                textDecoration = if (isUnderlined) TextDecoration.Underline else TextDecoration.None,
                color = color
            )
        )
    }
}

@Composable
fun StrokedTransparentBlackButton(
    text: String = "",
    onClick: () -> Unit,
    modifier: Modifier = Modifier

) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = YassirTheme.colors.transparent),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 47.dp)
            .border(
                shape = RoundedCornerShape(5.dp),
                width = 1.dp,
                color = YassirTheme.colors.cozoBlack
            )
    ) {

        PrimaryButtonText(text = text, color = YassirTheme.colors.primaryText)
    }
}
