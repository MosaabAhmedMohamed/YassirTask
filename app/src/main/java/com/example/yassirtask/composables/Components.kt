@file:OptIn(ExperimentalMaterialApi::class)

package com.example.yassirtask.composables

import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.yassirtask.theme.YassirTheme
import kotlinx.coroutines.launch
import com.example.yassirtask.R.drawable
import com.example.yassirtask.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemTypeCard(
    modifier: Modifier = Modifier,
    icon: String? = null,
    title: String,
    isSelected: Boolean = false,
    onSelectItem: () -> Unit
) {
    val background = animateColorAsState(
        targetValue = if (isSelected) YassirTheme.colors.cozoCardBlack else MaterialTheme.colors.background,
        animationSpec = tween(
            durationMillis = 100,
            delayMillis = 10,
            easing = LinearOutSlowInEasing
        )
    )
    val stroke = animateColorAsState(
        targetValue = if (isSelected) YassirTheme.colors.cozoCardBlack else YassirTheme.colors.strokeDark,
        animationSpec = tween(
            durationMillis = 100,
            delayMillis = 10,
            easing = LinearOutSlowInEasing
        )
    )
    val contentColor = animateColorAsState(
        targetValue = if (isSelected) YassirTheme.colors.gold else Color.Black,
        animationSpec = tween(
            durationMillis = 100,
            delayMillis = 10,
            easing = LinearOutSlowInEasing
        )
    )
    Card(
        modifier = modifier
            .size(92.dp),
        border = BorderStroke(width = 1.dp, stroke.value),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = background.value,
        onClick = { onSelectItem() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 12.dp,
                    bottom = 4.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RemoteImage(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(34.dp)
                    .height(34.dp),
                imageUrl = icon,
                colorFilter = ColorFilter.tint(contentColor.value),
                description = "hometype"
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                SmallText(
                    text = title,
                    textAlign = TextAlign.Center,
                    color = contentColor.value,
                    maxLines = 2
                )
            }
        }
    }
}

@Composable
fun DotShape(
    size: Dp = 6.dp,
    color: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
fun RemoteImage(
    imageUrl: String?,
    description: String? = null,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    placeHolder: ImageVector? = null,
    error: ImageVector? = null,
    fallback: ImageVector? = null
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = description,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        colorFilter = colorFilter,
        placeholder = if (placeHolder != null) rememberVectorPainter(placeHolder) else null,
        error = if (error != null) rememberVectorPainter(error) else null,
        fallback = if (fallback != null) rememberVectorPainter(fallback) else null
    )
}

@Composable
fun GrayRemoteImage(
    imageUrl: String?,
    description: String? = null,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = description,
        modifier = modifier.background(YassirTheme.colors.placeholder),
        alignment = alignment,
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}



@Preview
@Composable
fun PropertyTypeCardPreview() {
    ItemTypeCard(
        title = "Exercise",
        icon = null,
        isSelected = true,
        onSelectItem = {}
    )
}

@Composable
fun DashLine(
    modifier: Modifier = Modifier,
    height: Dp = YassirTheme.spacing.xs,
    width: Dp = 112.dp,
    background: Color = Color.Black
) {
    Spacer(
        modifier = modifier
            .height(height)
            .width(width)
            .background(background, Shapes.medium)
    )
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    backgroundColor: Color = YassirTheme.colors.transparent,
    sheetContentBackgroundColor: Color = YassirTheme.colors.white,
    sheetGesturesEnabled: Boolean = true,
    sheetShape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    sheetElevation: Dp = BottomSheetScaffoldDefaults.SheetElevation,
    sheetPeekHeight: Dp = 0.dp,
    dimEmptySpace: Boolean = false,
    sheetContent: @Composable ColumnScope.() -> Unit,
    onDismissedByBackEvent: (() -> Unit)? = null,
    onBottomSheetCollapsed: (() -> Unit)? = null,
    topBar: (@Composable () -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    BackHandler(enabled = bottomSheetScaffoldState.bottomSheetState.isExpanded) {
        coroutineScope.launch {
            bottomSheetScaffoldState.bottomSheetState.collapse()
            focusManager.clearFocus(true)
            onDismissedByBackEvent?.invoke()
        }
    }

    val isExpanding = bottomSheetScaffoldState.bottomSheetState.isCollapsed &&
        bottomSheetScaffoldState.bottomSheetState.progress < 1
    val isExpanded = bottomSheetScaffoldState.bottomSheetState.isExpanded

    val showDimmedSpace = isExpanding || isExpanded

    BottomSheetScaffold(
        topBar = topBar,
        sheetContent = sheetContent,
        modifier = modifier,
        scaffoldState = bottomSheetScaffoldState,
        backgroundColor = backgroundColor,
        sheetBackgroundColor = sheetContentBackgroundColor,
        sheetGesturesEnabled = sheetGesturesEnabled,
        sheetShape = sheetShape,
        sheetElevation = sheetElevation,
        sheetPeekHeight = sheetPeekHeight,
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                content(it)

                if (dimEmptySpace) {
                    AnimatedVisibility(
                        visible = showDimmedSpace,
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 200,
                                delayMillis = 10,
                                easing = LinearOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 100,
                                delayMillis = 10,
                                easing = LinearOutSlowInEasing
                            )
                        )
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(YassirTheme.colors.blackAlpha44)
                                .noRippleClickable {
                                    coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.collapse() }
                                }
                        )
                    }
                }
            }
        }
    )


    LaunchedEffect ("bottomSheetState"){
        coroutineScope.launch {
            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed ) {
                onBottomSheetCollapsed?.invoke()
            }
        }
    }

}


@Composable
fun CoverImageSection(
    uri: Uri? = null,
    uploadedUrl: String? = null,
    onClearImage: () -> Unit,
    showDelete: Boolean = true,
    modifier: Modifier = Modifier.size(164.dp)
) {
    Box {

        Card(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = YassirTheme.colors.stroke),
            modifier = modifier.padding(top = 12.dp),
            elevation = 0.dp
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = uri ?: uploadedUrl
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        if (showDelete) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clickable { onClearImage() }
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp),
                    painter = painterResource(id = drawable.ic_close_circle),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun StepLayout(
    stepsCount: Int,
    currentStep: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(stepsCount) {
            Step(
                modifier = Modifier.weight(1f),
                isComplete = currentStep >= it
            )
        }
    }
}

@Composable
fun Step(modifier: Modifier = Modifier, isComplete: Boolean = true) {
    val background = animateColorAsState(
        targetValue = if (isComplete) YassirTheme.colors.gold else YassirTheme.colors.pickerOption,
        animationSpec = tween(
            durationMillis = 100,
            delayMillis = 10,
            easing = LinearOutSlowInEasing
        )
    )

    Box(modifier = modifier) {
        // Line
        Divider(
            modifier = Modifier.align(Alignment.CenterStart),
            color = background.value,
            thickness = 4.dp
        )
    }
}
