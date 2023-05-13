package com.example.yassirtask.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.yassirtask.R

internal val Menco = FontFamily(
    Font(R.font.menco_medium),
    Font(R.font.menco_bold, FontWeight.Bold)
)

internal val Poppins = FontFamily(
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_thin, FontWeight.Thin)
)

internal val Roboto = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_thin, FontWeight.Thin),
)

@Immutable
data class YassirTypography(
    val h1: TextStyle =
        TextStyle(
            fontFamily = Menco,
            fontSize = 23.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 27.sp
        ),
    val h2Bold: TextStyle =
        TextStyle(
            fontFamily = Menco,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp
        ),
    val h3Bold: TextStyle =
        TextStyle(
            fontFamily = Menco,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 20.sp
        ),
    val h3: TextStyle =
        TextStyle(
            fontFamily = Menco,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp
        ),
    val h5: TextStyle =
        TextStyle(
            fontFamily = Menco,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 14.sp
        ),
    val poppinsH3: TextStyle =
        TextStyle(
            fontFamily = Poppins,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp
        ),
    val poppinsBold: TextStyle =
        TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold
        ),
    val poppinsBoldH1: TextStyle = poppinsBold.copy(
        fontSize = 37.sp
    ),
    val poppinsRegular: TextStyle =
        TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal
        ),
    val mencoBold: TextStyle =
        TextStyle(
            fontFamily = Menco,
            fontWeight = FontWeight.Bold
        ),
    val mencoRegular: TextStyle =
        TextStyle(
            fontFamily = Menco,
            fontWeight = FontWeight.Normal
        ),
    val poppinsBold14: TextStyle =
        poppinsBold.copy(
            fontSize = 14.sp
        ),
    val poppinsBold12: TextStyle =
        poppinsBold.copy(
            fontSize = 12.sp
        ),
    val poppinsBold16: TextStyle =
        poppinsBold.copy(
            fontSize = 16.sp
        ),
    val poppinsBold19: TextStyle =
        poppinsBold.copy(
            fontSize = 19.sp
        ),
    val poppinsBold24: TextStyle =
        poppinsBold.copy(
            fontSize = 24.sp
        ),
    val mencoBold16: TextStyle =
        mencoBold.copy(
            fontSize = 16.sp,
        ),
    val mencoBold18: TextStyle =
        mencoBold.copy(
            fontSize = 18.sp,
        ),
    val mencoBold20: TextStyle =
        mencoBold.copy(
            fontSize = 20.sp,
        ),
    val mencoBold24: TextStyle =
        mencoBold.copy(
            fontSize = 24.sp,
        ),
    val mencoRegular12: TextStyle =
        mencoRegular.copy(
            fontSize = 12.sp
        ),
    val mencoRegular14: TextStyle =
        mencoRegular.copy(
            fontSize = 14.sp
        ),
    val mencoRegular18: TextStyle =
        mencoRegular.copy(
            fontSize = 18.sp
        ),
    val mencoRegular36: TextStyle =
        mencoRegular.copy(
            fontSize = 36.sp,
            lineHeight = 38.sp
        ),
    val mencoRegular48: TextStyle =
        mencoRegular.copy(
            fontSize = 48.sp,
            lineHeight = 50.sp
        ),
    val poppinsRegular12: TextStyle =
        poppinsRegular.copy(
            fontSize = 12.sp
        ),
    val poppinsRegular14: TextStyle =
        poppinsRegular.copy(
            fontSize = 14.sp
        ),
    val poppinsRegular14Gray: TextStyle =
        poppinsRegular.copy(
            fontSize = 14.sp,
        ),
    val poppinsRegular15: TextStyle =
        poppinsRegular.copy(
            fontSize = 15.sp
        ),
    val poppinsRegular16: TextStyle =
        poppinsRegular.copy(
            fontSize = 16.sp
        ),
    val poppinsBodyMedium: TextStyle =
        TextStyle(
            fontFamily = Poppins,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 21.sp
        ),
    val poppinsSemiBold: TextStyle =
        TextStyle(
            fontFamily = Poppins,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 21.sp
        ),
    val poppinsMedium12: TextStyle =
        poppinsBodyMedium.copy(
            fontSize = 12.sp
        ),
    val poppinsMedium14: TextStyle =
        poppinsBodyMedium.copy(
            fontSize = 14.sp
        ),
    val poppinsMedium16: TextStyle =
        poppinsBodyMedium.copy(
            fontSize = 16.sp
        ),
    val poppinsMedium18: TextStyle =
        poppinsBodyMedium.copy(
            fontSize = 18.sp
        ),
    val poppinsSemiBold12: TextStyle =
        poppinsSemiBold.copy(
            fontSize = 12.sp
        ),
    val poppinsSemiBold14: TextStyle =
        poppinsSemiBold.copy(
            fontSize = 14.sp
        ),
    val poppinsSemiBold16: TextStyle =
        poppinsSemiBold.copy(
            fontSize = 16.sp
        ),
    val poppinsBodyMediumUnderlined: TextStyle =
        poppinsBodyMedium.copy(textDecoration = TextDecoration.Underline),
    val poppinsSmall: TextStyle =
        TextStyle(
            fontFamily = Poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 18.sp
        ),
    val subtitle1: TextStyle =
        TextStyle(
            fontFamily = Poppins,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
    val roboto: TextStyle = TextStyle(
        fontFamily = Roboto
    ),
    val robotoBlack: TextStyle = roboto.copy(
        fontWeight = FontWeight.Black
    ),
    val robotoBold: TextStyle = roboto.copy(
        fontWeight = FontWeight.Bold
    ),
    val robotoMedium: TextStyle = roboto.copy(
        fontWeight = FontWeight.Medium
    ),
    val robotoRegular: TextStyle = roboto.copy(
        fontWeight = FontWeight.Normal
    ),
    val robotoLight: TextStyle = roboto.copy(
        fontWeight = FontWeight.Light
    ),
    val robotoThin: TextStyle = roboto.copy(
        fontWeight = FontWeight.Thin
    ),
    val robotoBold14: TextStyle = robotoBold.copy(
        fontSize = 14.sp
    ),
    val robotoRegular14: TextStyle = robotoRegular.copy(
        fontSize = 14.sp
    ),
    val mencoMedium: TextStyle = TextStyle(
        fontFamily = Menco,
        fontWeight = FontWeight.Medium
    ),
    val mencoMedium24: TextStyle = mencoMedium.copy(
        fontSize = 24.sp
    ),
    val mencoMedium26: TextStyle = mencoMedium.copy(
        fontSize = 26.sp
    ),
    val mencoMedium36: TextStyle = mencoMedium.copy(
        fontSize = 36.sp
    ),
    val mencoMedium54: TextStyle = mencoMedium.copy(
        fontSize = 54.sp
    ),
    val mencoMedium60: TextStyle = mencoMedium.copy(
        fontSize = 60.sp
    )
)

val LocalYassirTypography = staticCompositionLocalOf { YassirTypography() }
