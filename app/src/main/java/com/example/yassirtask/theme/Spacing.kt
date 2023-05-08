package com.example.yassirtask.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class YassirSpacing(
    val default: Dp = 0.dp,

    // normalized //TODO AGREE ON THE NAMING
    val unit: Dp = 1.dp,
    val extra_xxs: Dp = 2.dp,
    val xxs: Dp = 4.dp,
    val xs: Dp = 8.dp,
    val s: Dp = 12.dp,
    val m: Dp = 16.dp,
    val l: Dp = 24.dp,
    val xl: Dp = 32.dp,
    val xxl: Dp = 48.dp,

    val primaryPadding: Dp = 18.dp,
    val rowPadding: Dp = 20.dp,
    val spacer: Dp = 15.dp,
    val spacerMini: Dp = 10.dp,
    val cardPadding: Dp = s,

    val minWidthCard: Dp = 110.dp,
    val chipsHeight: Dp = 40.dp,

    val spacing2: Dp = 2.dp,
    val spacing4: Dp = 4.dp,
    val spacing6: Dp = 6.dp,
    val spacing8: Dp = 8.dp,
    val spacing10: Dp = 10.dp,
    val spacing12: Dp = 12.dp,
    val spacing16: Dp = 16.dp,
    val spacing18: Dp = 18.dp,
    val spacing20: Dp = 20.dp,
    val spacing24: Dp = 24.dp,
    val spacing26: Dp = 26.dp,
    val spacing32: Dp = 32.dp,
    val spacing36: Dp = 36.dp,
    val spacing40: Dp = 40.dp,
    val spacing56: Dp = 56.dp,
    val spacing84: Dp = 84.dp,
    val spacing144: Dp = 144.dp,
)

val LocalYassirSpacing = staticCompositionLocalOf { YassirSpacing() }
