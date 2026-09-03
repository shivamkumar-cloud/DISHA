package com.example.disha.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = DishaPrimary,
    secondary = DishaPrimaryLight,
    background = DishaBackground,
    surface = DishaSurface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = DishaTextPrimary,
    onSurface = DishaTextPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = DishaPrimaryLight,
    secondary = DishaPrimary,
    background = DishaTextPrimary,
    surface = Color(0xFF1F2937),
    onPrimary = DishaTextPrimary,
    onSecondary = DishaTextPrimary,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun DishaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}