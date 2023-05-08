package com.example.yassirtask.theme

import androidx.compose.material.lightColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Gold = Color(0xFFF5AB32)
val CharcoalGrey = Color(0xFF212121)
val TransCharcoalGrey = Color(0x88212121)
val StrokeGrey = Color(0xFFDFDACC)
val StrokeGreyDark = Color(0xFF939393)
val CozoBlack = Color(0xFF010101)
val CozoCardBlack = Color(0xFF262626)
val CozoGrey = Color(0xFFFAF9F8)
val PlaceholderGrey = Color(0XFFD4D4D4)
val Brown = Color(0XFF633D22)
val GHOST_WHITE = Color(0XFFF9F9F9)
val TAUPE_GRAY = Color(0XFF888888)
val DARK_CHARCOAL = Color(0XFF333333)
val GREEN_CACOPHONY = Color(0xFF9FBA4E)

val LightColorPalette =
    lightColors(
        primary = CharcoalGrey,
        primaryVariant = CharcoalGrey,
        secondary = CharcoalGrey,
        background = CozoGrey
    )

@Immutable
data class YassirColors(
    val primaryButtonColor: Color = CharcoalGrey,
    val primaryDisabledColor: Color = TransCharcoalGrey,
    val charcoalGrey: Color = CharcoalGrey,
    val primaryText: Color = Color.Black,
    val gold: Color = Gold,
    val stroke: Color = StrokeGrey,
    val strokeDark: Color = StrokeGreyDark,
    val cozoBlack: Color = CozoBlack,
    val cozoCardBlack: Color = CozoCardBlack,
    val white: Color = Color(0XFFFFFFFF),
    val whiteAlpha30: Color = Color(0x4DFFFFFF),
    val whiteAlpha50: Color = Color(0x80FFFFFF),
    val transparent: Color = Color(0x00FFFFFF),
    val placeholder: Color = PlaceholderGrey,
    val brown: Color = Brown,
    val pickerHeader: Color = GHOST_WHITE,
    val pickerOption: Color = TAUPE_GRAY,
    val pickerText: Color = DARK_CHARCOAL,
    val cozoGray: Color = CozoGrey,
    val black: Color = Color(0xFF010101),
    val blue: Color = Color(0xFF2B5DDE),
    val blueLight: Color = Color(0x332B5DDE),
    val blackAlpha44: Color = Color(0x70010101),
    val errorRed: Color = Color(0xFFFE2E30),
    val reverseGray: Color = Color(0xFFDCDCDC),
    val gray79: Color = Color(0xFFC9C9C9),
    val reverseGrayDark: Color = Color(0xFFB9B9B9),
    val brownTone: Color = Color(0xFF79715B),
    val doveGray: Color = Color(0xFF666666),
    val darkGray: Color = Color(0xFF616161),
    val middleGray: Color = Color(0xFF747474),
    val softBromeliad: Color = Color(0xFF5DA3A9),
    val yellow: Color = Color(0xFFFEBB12),
    val gray61: Color = Color(0xFF9C9C9C),
    val spanishGray: Color = Color(0xFF9C9C9C),
)

val LocalYassirColors = staticCompositionLocalOf { YassirColors() }
