package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Immutable
data class LanguageColors(
    val englishAccent: Color,
    val englishContainer: Color,
    val chineseAccent: Color,
    val chineseContainer: Color,
    val khmerAccent: Color,
    val khmerContainer: Color,
    val goldAccent: Color,
    val goldContainer: Color
)

val LocalLanguageColors = staticCompositionLocalOf {
    LanguageColors(
        englishAccent = EnglishBlue,
        englishContainer = EnglishBlueBg,
        chineseAccent = ChineseCoral,
        chineseContainer = ChineseCoralBg,
        khmerAccent = KhmerJade,
        khmerContainer = KhmerJadeBg,
        goldAccent = LotusGold,
        goldContainer = LotusGoldContainer
    )
}

private val LightColorScheme = lightColorScheme(
    primary = EmeraldJade,
    onPrimary = Color.White,
    primaryContainer = EmeraldJadeContainer,
    onPrimaryContainer = OnEmeraldJadeContainer,
    secondary = WarmAmber,
    onSecondary = Color.White,
    secondaryContainer = WarmAmberContainer,
    onSecondaryContainer = OnWarmAmberContainer,
    tertiary = LotusGold,
    onTertiary = Color.White,
    tertiaryContainer = LotusGoldContainer,
    onTertiaryContainer = DeepInk,
    background = SandstoneBackground,
    onBackground = DeepInk,
    surface = SandstoneSurface,
    onSurface = DeepInk,
    surfaceVariant = SandstoneSurfaceVariant,
    onSurfaceVariant = MutedInk,
    outline = SandstoneOutline
)

private val DarkColorScheme = darkColorScheme(
    primary = EmeraldJadeBright,
    onPrimary = EmeraldJadeDark,
    primaryContainer = EmeraldJadeDarkContainer,
    onPrimaryContainer = EmeraldJadeContainer,
    secondary = WarmAmber,
    onSecondary = Color.White,
    secondaryContainer = OnWarmAmberContainer,
    onSecondaryContainer = WarmAmberContainer,
    tertiary = LotusGold,
    onTertiary = DeepInk,
    background = ObsidianBackground,
    onBackground = LightInk,
    surface = ObsidianSurface,
    onSurface = LightInk,
    surfaceVariant = ObsidianSurfaceVariant,
    onSurfaceVariant = LightMutedInk,
    outline = ObsidianOutline
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun SontanaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val languageColors = if (darkTheme) {
        LanguageColors(
            englishAccent = EnglishBlueBright,
            englishContainer = EnglishBlueDarkBg,
            chineseAccent = ChineseCoralBright,
            chineseContainer = ChineseCoralDarkBg,
            khmerAccent = EmeraldJadeBright,
            khmerContainer = KhmerJadeDarkBg,
            goldAccent = LotusGold,
            goldContainer = Color(0xFF33270D)
        )
    } else {
        LanguageColors(
            englishAccent = EnglishBlue,
            englishContainer = EnglishBlueBg,
            chineseAccent = ChineseCoral,
            chineseContainer = ChineseCoralBg,
            khmerAccent = KhmerJade,
            khmerContainer = KhmerJadeBg,
            goldAccent = LotusGold,
            goldContainer = LotusGoldContainer
        )
    }

    CompositionLocalProvider(LocalLanguageColors provides languageColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}
