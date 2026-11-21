package com.example.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BusinessCenter
import androidx.compose.material.icons.rounded.DirectionsBus
import androidx.compose.material.icons.rounded.Groups
import androidx.compose.material.icons.rounded.LocalCafe
import androidx.compose.material.icons.rounded.MedicalServices
import androidx.compose.material.icons.rounded.PhoneIphone
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.WavingHand
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.model.TopicIconType
import com.example.ui.theme.LocalLanguageColors

fun TopicIconType.toMaterialIcon(): ImageVector = when (this) {
    TopicIconType.GREETINGS -> Icons.Rounded.WavingHand
    TopicIconType.DINING -> Icons.Rounded.Restaurant
    TopicIconType.SHOPPING -> Icons.Rounded.ShoppingBag
    TopicIconType.TRAVEL -> Icons.Rounded.DirectionsBus
    TopicIconType.WORK -> Icons.Rounded.BusinessCenter
    TopicIconType.HEALTH -> Icons.Rounded.MedicalServices
    TopicIconType.PHONE_WIFI -> Icons.Rounded.PhoneIphone
    TopicIconType.DAILY_LIFE -> Icons.Rounded.LocalCafe
}

@Composable
fun TopicIconType.accentColors(): Pair<Color, Color> {
    val langColors = LocalLanguageColors.current
    return when (this) {
        TopicIconType.GREETINGS -> langColors.khmerAccent to langColors.khmerContainer
        TopicIconType.DINING -> langColors.goldAccent to langColors.goldContainer
        TopicIconType.SHOPPING -> langColors.chineseAccent to langColors.chineseContainer
        TopicIconType.TRAVEL -> langColors.englishAccent to langColors.englishContainer
        TopicIconType.WORK -> langColors.englishAccent to langColors.englishContainer
        TopicIconType.HEALTH -> langColors.chineseAccent to langColors.chineseContainer
        TopicIconType.PHONE_WIFI -> langColors.khmerAccent to langColors.khmerContainer
        TopicIconType.DAILY_LIFE -> langColors.goldAccent to langColors.goldContainer
    }
}
