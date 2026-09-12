package com.paita.playground.ui.theme

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import kotlin.math.roundToInt

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

/**
 * Draw a grid pattern on a white background .
 *
 * It is the default background of this Playground App.
 * @return
 */
fun Modifier.playgroundBackground() : Modifier {
    return this
        .background(Color.White)
        .drawBehind {
            // Draw vertical Lines
            val verticalLinesCount = 20
            val gapSize = this.size.width / verticalLinesCount

            for (v in 1 ..< verticalLinesCount) {
                drawLine(
                    color = LightGrey,
                    start = Offset(gapSize * v, 0f),
                    end = Offset(gapSize * v, this.size.height)
                )
            }

            // Draw horizontal Lines
            val horizontalLinesCount = (this.size.height / gapSize).roundToInt()

            for (h in 1 ..< horizontalLinesCount) {
                drawLine(
                    color = LightGrey,
                    start = Offset(0f, gapSize * h),
                    end = Offset(this.size.width, gapSize * h)
                )
            }

        }
}

/**
 * Default Theme of Playground App
 *
 * @param darkTheme
 * @param dynamicColor
 * @param content
 */
@Composable
fun PlaygroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}