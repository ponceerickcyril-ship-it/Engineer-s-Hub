package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val HighDensityColorScheme = darkColorScheme(
    primary = TechCyan,
    onPrimary = DeepNavy,
    primaryContainer = SurfaceVariantDark,
    onPrimaryContainer = TechCyan,
    secondary = ElectricBlue,
    onSecondary = DeepNavy,
    secondaryContainer = SurfaceElevated,
    onSecondaryContainer = TextPrimary,
    tertiary = WarningYellow,
    onTertiary = DeepNavy,
    tertiaryContainer = Color(0xFF451A03),
    onTertiaryContainer = WarningYellowLight,
    background = BackgroundDark,
    onBackground = TextPrimary,
    surface = SurfaceDark,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = TextSecondary,
    outline = BorderLight,
    outlineVariant = BorderDark,
    error = ErrorRed,
    onError = DeepNavy
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = HighDensityColorScheme,
        typography = Typography,
        content = content
    )
}
