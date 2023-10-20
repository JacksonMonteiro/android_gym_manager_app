package space.jacksonmonteiro.gymmanager.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat


private val themeColors = lightColorScheme(
    primary = Color(0xFFfdbb20),
    onPrimary = Color(0xFFffffff),
    primaryContainer = Color(0xFFffdea5),
    onPrimaryContainer = Color(0xFF261900),
    secondary = Color(0xFFb3c5ff),
    onSecondary = Color(0xFFffffff),
    secondaryContainer = Color(0xFFdbe1ff),
    onSecondaryContainer = Color(0xFF00174a),
    error = Color(0xFFba1a1a),
    errorContainer = Color(0xFFffdad6),
    onError = Color(0xFFffffff),
    onErrorContainer = Color(0xFF410002),
    background = Color(0xFFf8fdff),
    onBackground = Color(0xFF001f25),
    surface = Color(0xFFf8fdff),
    onSurface = Color(0xFF001f25),
)


@Composable
fun GymManagerTheme(content: @Composable() () -> Unit) {
    val colors = themeColors

    val view = LocalView.current
    SideEffect {
        (view.context as Activity).window.statusBarColor = colors.primary.toArgb()
        ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = true
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}