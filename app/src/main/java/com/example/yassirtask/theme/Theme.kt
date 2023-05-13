package com.example.yassirtask.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

/**
 * will behave as our theme source
 */
object YassirTheme {
    val colors
        @Composable
        @ReadOnlyComposable
        get() = localYassirColors(isSystemInDarkTheme()).current

    val typography
        @Composable
        @ReadOnlyComposable
        get() = LocalYassirTypography.current

    val sizing
        @Composable
        @ReadOnlyComposable
        get() = LocalYassirSizing.current

    val spacing
        @Composable
        @ReadOnlyComposable
        get() = LocalYassirSpacing.current
}

@Composable
fun YassirComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    if (darkTheme)
        MaterialTheme(
            darkColorPalette,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    else
        MaterialTheme(
            colors = LightColorPalette,
            typography = Typography,
            shapes = Shapes,
            content = content
        )

}
