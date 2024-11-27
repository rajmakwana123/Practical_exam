package com.example.eventease.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

// Define your color schemes (adjust colors as per your design)
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6200EE),  // Example dark color
    secondary = Color(0xFF03DAC5), // Example dark secondary color
    tertiary = Color(0xFFFFD700)   // Example dark tertiary color
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFBB86FC), // Example light primary color
    secondary = Color(0xFF03DAC5), // Example light secondary color
    tertiary = Color(0xFFFFD700)   // Example light tertiary color
)

// Create the custom EventEaseTheme composable
@Composable
fun EventEaseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Default to system theme
    dynamicColor: Boolean = true,  // Support for dynamic colors on Android 12+
    content: @Composable () -> Unit // Content of the UI that will use this theme
) {
    // Determine color scheme based on the system setting and dynamic color support
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Apply the MaterialTheme with the color scheme and content
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
