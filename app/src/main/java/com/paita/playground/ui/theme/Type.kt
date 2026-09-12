package com.paita.playground.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.paita.playground.R

// Fonts
val PlaygroundFontFamily = FontFamily(
    Font(R.font.sf_compact_black, FontWeight.Black),
    Font(R.font.sf_compact_bold, FontWeight.Bold),
    Font(R.font.sf_compact_heavy, FontWeight.ExtraBold),
    Font(R.font.sf_compact_light, FontWeight.Light),
    Font(R.font.sf_compact_medium, FontWeight.Medium),
    Font(R.font.sf_compact_regular, FontWeight.Normal),
    Font(R.font.sf_compact_semibold, FontWeight.SemiBold),
    Font(R.font.sf_compact_thin, FontWeight.Thin),
    Font(R.font.sf_compact_ultralight, FontWeight.ExtraLight),
)


// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 36.sp,
        color = LightBlack
    ),
    displayMedium = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp,
        color = LightBlack
    ),
    displaySmall = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
        color = LightBlack
    ),
    headlineLarge = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = LightBlack
    ),
    headlineMedium = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = LightBlack
    ),
    headlineSmall = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = LightBlack
    ),
    titleLarge = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        color = LightBlack
    ),
    titleMedium = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = LightBlack
    ),
    titleSmall = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = LightBlack
    ),
    bodyLarge = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = LightBlack
    ),
    bodyMedium = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = LightBlack
    ),
    bodySmall = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = LightBlack
    ),
    labelLarge = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = LightBlack
    ),
    labelMedium = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = LightBlack
    ),
    labelSmall = TextStyle(
        fontFamily = PlaygroundFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = LightBlack
    )
)