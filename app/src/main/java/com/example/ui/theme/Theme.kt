package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = LiturgicalGoldLight,
    onPrimary = SacredBurgundyDark,
    primaryContainer = SacredBurgundy,
    onPrimaryContainer = LiturgicalGoldLight,
    secondary = LiturgicalGold,
    onSecondary = Color.Black,
    secondaryContainer = GoldContainerDark,
    onSecondaryContainer = LiturgicalGoldLight,
    tertiary = SacredBurgundyLight,
    onTertiary = Color.White,
    background = DarkSanctuaryBg,
    onBackground = TextSacredLight,
    surface = DarkSanctuarySurface,
    onSurface = TextSacredLight,
    surfaceVariant = DarkSanctuaryCard,
    onSurfaceVariant = TextMutedLight,
    outline = BorderDarkSanctuary
)

private val LightColorScheme = lightColorScheme(
    primary = SacredBurgundy,
    onPrimary = Color.White,
    primaryContainer = GoldContainerLight,
    onPrimaryContainer = SacredBurgundyDark,
    secondary = LiturgicalGold,
    onSecondary = Color.White,
    secondaryContainer = ParchmentSurface,
    onSecondaryContainer = SacredBurgundy,
    tertiary = SacredBurgundyLight,
    onTertiary = Color.White,
    background = WarmAlabasterBg,
    onBackground = TextSacredDark,
    surface = ParchmentSurface,
    onSurface = TextSacredDark,
    surfaceVariant = ParchmentCard,
    onSurfaceVariant = TextMutedBrown,
    outline = BorderParchment
)

@Composable
fun SanctaFidesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep liturgical identity consistent
    content: @Composable () -> Unit
) {
    SanctaFidesTheme(darkTheme = darkTheme, content = content)
}
