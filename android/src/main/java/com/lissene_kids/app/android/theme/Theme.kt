package com.lissene_kids.app.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val DarkColorScheme = darkColorScheme(
    primary = Blue1,
    secondary = Green1,
    tertiary = Green3,
    surface = Blue5,
    background = White1,

    onPrimary = Blue2,
    onSecondary = Green2,
    onTertiary = Blue4,
    onSurface = Blue6,
    onBackground = Blue3,

    outline = Black1,
    primaryContainer = Black2,
    secondaryContainer = Black3,
    tertiaryContainer = Black4,
)

private val LightColorScheme = lightColorScheme(
    primary = Blue1,
    secondary = Green1,
    tertiary = Green3,
    surface = Blue5,
    background = White1,

    onPrimary = Blue2,
    onSecondary = Green2,
    onTertiary = Blue4,
    onSurface = Blue6,
    onBackground = Blue3,

    outline = Black1,
    primaryContainer = Black2,
    secondaryContainer = Black3,
    tertiaryContainer = Black4,

    )
@Composable
fun ImTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}