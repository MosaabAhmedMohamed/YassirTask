package com.example.yassirtask.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.yassirtask.ext.appendRequiredAsterisk
import com.example.yassirtask.theme.YassirTheme


@Composable
fun ScreenTitle(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    maxLines: Int = Int.MAX_VALUE,
    textStyle: TextStyle = YassirTheme.typography.h3Bold,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = textStyle
    )
}

@Composable
fun ScreenSubTitle(
    text: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = YassirTheme.spacing.xl),
    maxLines: Int = Int.MAX_VALUE,
    textStyle: TextStyle = YassirTheme.typography.poppinsRegular16,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.middleGray
) {
    Text(
        text = text,
        style = textStyle,
        color = color,
        textAlign = textAlign,
        modifier = modifier,
        maxLines = maxLines
    )
}


@Composable
fun MessageHeader(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = YassirTheme.typography.h2Bold
    )
}

@Composable
fun MessageBody(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText,
    style: TextStyle = YassirTheme.typography.h3
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = style
    )
}


@Composable
fun CardHeader(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText,
    style: TextStyle = YassirTheme.typography.poppinsRegular14,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    MediumText(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = style,
        overflow = overflow
    )
}

@Composable
fun ExpandableCardHeader(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText,
    style: TextStyle = YassirTheme.typography.poppinsRegular14,
    isExpanded: Boolean,
    onExpanding: () -> Unit
) {
    Row(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onExpanding.invoke()
        }
    ) {
        MediumText(
            text = text,
            modifier = modifier.padding(top = 2.dp),
            maxLines = maxLines,
            textAlign = textAlign,
            color = color,
            style = style
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            tint = YassirTheme.colors.black,
            imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = "",
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun MediumText(
    text: String,
    modifier: Modifier = Modifier,
    isUnderlined: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText,
    style: TextStyle = YassirTheme.typography.poppinsRegular14,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        text = text,
        style = style.copy(
            textDecoration = if (isUnderlined) TextDecoration.Underline else TextDecoration.None,
            color = color
        ),
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = overflow
    )
}

@Composable
fun SmallText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText,
    style: TextStyle = YassirTheme.typography.poppinsSmall
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = style,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun PrimaryButtonText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.gold
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = YassirTheme.typography.poppinsBold16
    )
}

@Composable
fun TextInputField(
    text: String,
    label: String? = null,
    // TODO: use text styles after fix the field height is too big issue
    textStyle: TextStyle = LocalTextStyle.current,
    labelStyle: TextStyle = LocalTextStyle.current,
    onValueChange: ((String) -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    startIconModifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    backgroundColor: Color = Color.White,
    singleLine: Boolean = true,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    showRequiredAsterisk: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    textColor: Color = YassirTheme.colors.charcoalGrey,
    maxLength: Int = Int.MAX_VALUE,
    maxLines: Int = Int.MAX_VALUE,
    minHeight: Dp = 0.dp,
    error: String? = null,
    textFieldModifier: Modifier = Modifier,
    endIcon: ImageVector? = null,
    startIcon: ImageVector? = null,
    iconTintColor: Color? = null,
    placeholder: String? = null
) {
    val strokeColor = animateColorAsState(
        targetValue = if (error == null) YassirTheme.colors.stroke else YassirTheme.colors.errorRed,
        animationSpec = tween(
            durationMillis = 200, delayMillis = 10, easing = LinearOutSlowInEasing
        )
    )

    val interactionSource = remember { MutableInteractionSource() }
    if (onClick != null) interactionSource.also {
        LaunchedEffect(it) {
            it.interactions.collect {
                if (it is PressInteraction.Release) {
                    onClick.invoke()
                }
            }
        }
    }

    Column(modifier = modifier) {
        TextField(
            readOnly = readOnly,
            value = text,
            label = if (label != null) {
                {
                    Text(
                        text = label.appendRequiredAsterisk(showRequiredAsterisk),
                        color = YassirTheme.colors.doveGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            } else null,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange?.invoke(it)
                }
            },
            modifier = textFieldModifier
                .fillMaxWidth()
                .heightIn(min = minHeight)
                .border(
                    width = 1.dp, color = strokeColor.value, shape = RoundedCornerShape(6.dp)
                ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType, imeAction = imeAction, capitalization = capitalization
            ),
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            enabled = enabled,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                textColor = textColor,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(6.dp),
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            trailingIcon = if (endIcon != null) {
                {
                    Image(
                        imageVector = endIcon,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(iconTintColor ?: YassirTheme.colors.stroke),
                        modifier = Modifier,
                        contentScale = ContentScale.FillBounds
                    )
                }
            } else null,
            leadingIcon = if (startIcon != null) {
                {
                    Image(
                        imageVector = startIcon,
                        contentDescription = null,
                        modifier = startIconModifier,
                        colorFilter = ColorFilter.tint(iconTintColor ?: YassirTheme.colors.stroke),
                        contentScale = ContentScale.FillBounds
                    )
                }
            } else null,
            placeholder = if (placeholder != null) {
                {
                    Text(
                        text = placeholder,
                        color = YassirTheme.colors.middleGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            } else null
        )

        AnimatedVisibility(error != null) {
            Text(
                text = error.orEmpty(),
                style = YassirTheme.typography.mencoRegular12.copy(
                    color = YassirTheme.colors.errorRed
                )
            )
        }
    }
}

@Composable
fun Subtitle(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText,
    style: TextStyle = YassirTheme.typography.subtitle1
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = style
    )
}

@Composable
fun HorizontalTitleTextInputField(
    title: String,
    text: String = "",
    label: String? = null,
    onValueChange: ((String) -> Unit)? = null,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    backgroundColor: Color = Color.White,
    singleLine: Boolean = true,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    textColor: Color = YassirTheme.colors.charcoalGrey,
    maxLength: Int = Int.MAX_VALUE,
    error: String? = null,
    textFieldWidth: Dp = 94.dp,
    acceptIntegersOnly: Boolean = false,
    placeholder: String? = null
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MediumText(
            text = title,
            color = textColor,
            style = YassirTheme.typography.poppinsRegular16
        )

        TextInputField(
            text = text,
            label = label,
            onValueChange = {
                if (acceptIntegersOnly.not()) {
                    onValueChange?.invoke(it)
                    return@TextInputField
                }

                if (it.isEmpty()) {
                    onValueChange?.invoke("")
                    return@TextInputField
                }

                val intValue = it.toIntOrNull()?.toString() ?: return@TextInputField
                onValueChange?.invoke(intValue)
            },
            modifier = Modifier.width(textFieldWidth),
            keyboardType = keyboardType,
            imeAction = imeAction,
            keyboardActions = keyboardActions,
            capitalization = capitalization,
            backgroundColor = backgroundColor,
            singleLine = singleLine,
            enabled = enabled,
            readOnly = readOnly,
            visualTransformation = visualTransformation,
            textColor = textColor,
            maxLength = maxLength,
            error = error,
            placeholder = placeholder
        )
    }
}

@Composable
fun HorizontalTitleTextLabel(
    title: String,
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = YassirTheme.colors.charcoalGrey,
    textFieldWidth: Dp = 94.dp
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MediumText(
            text = title,
            color = textColor,
            style = YassirTheme.typography.poppinsRegular16
        )

        TextH1(
            text = text,
            color = textColor,
            style = YassirTheme.typography.poppinsBold16,
            modifier = Modifier.width(textFieldWidth),
        )
    }
}

@Composable
fun TextH1(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = YassirTheme.colors.primaryText,
    style: TextStyle = YassirTheme.typography.h1
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        style = style
    )
}
