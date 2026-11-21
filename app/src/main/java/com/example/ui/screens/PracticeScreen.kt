package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.ConversationLine
import com.example.model.LanguageType
import com.example.model.SpeechSpeed
import com.example.ui.components.PhraseCard
import com.example.ui.components.SpeedSelectorBar
import com.example.ui.viewmodel.ConversationUiState

@Composable
fun PracticeScreen(
    uiState: ConversationUiState,
    onSelectPracticeCategory: (String) -> Unit,
    onSelectSpeed: (SpeechSpeed) -> Unit,
    onSpeakPhrase: (ConversationLine, LanguageType) -> Unit,
    onSpeakAllThree: (ConversationLine) -> Unit,
    onToggleFavorite: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val phrases = uiState.practicePhrases
    var currentIndex by rememberSaveable { mutableIntStateOf(0) }
    var localHideReading by remember { mutableStateOf(false) }

    LaunchedEffect(phrases.size, uiState.practiceCategoryId) {
        if (currentIndex >= phrases.size) {
            currentIndex = 0
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 840.dp)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.practice_title),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "ស្តាប់ និងអានតាមល្បឿន ៣ កំរិត",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                if (phrases.isNotEmpty()) {
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Text(
                            text = "${currentIndex + 1} / ${phrases.size}",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp)
                        )
                    }
                }
            }

            // Category Filter Chips
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(end = 8.dp)
            ) {
                item {
                    FilterChip(
                        selected = uiState.practiceCategoryId == "all",
                        onClick = { onSelectPracticeCategory("all") },
                        label = { Text("ទាំងអស់") }
                    )
                }
                item {
                    FilterChip(
                        selected = uiState.practiceCategoryId == "favorites",
                        onClick = { onSelectPracticeCategory("favorites") },
                        label = { Text("រក្សាទុក (${uiState.favoritePhrases.size})") }
                    )
                }
                items(uiState.categories) { cat ->
                    FilterChip(
                        selected = uiState.practiceCategoryId == cat.id,
                        onClick = { onSelectPracticeCategory(cat.id) },
                        label = { Text(cat.titleKm) }
                    )
                }
            }

            // 3-Speed Bar
            SpeedSelectorBar(
                selectedSpeed = uiState.speechSpeed,
                onSelectSpeed = onSelectSpeed
            )

            // Toggle Hide/Show Reading for self-quiz
            Surface(
                onClick = { localHideReading = !localHideReading },
                modifier = Modifier
                    .fillMaxWidth()
                    .minimumInteractiveComponentSize()
                    .testTag("practice_toggle_reading_button"),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = if (localHideReading) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = if (localHideReading) {
                            stringResource(R.string.practice_show_reading)
                        } else {
                            stringResource(R.string.practice_hide_reading)
                        },
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            if (phrases.isEmpty()) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Text(
                        text = stringResource(R.string.favorites_empty_subtitle),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(24.dp)
                    )
                }
            } else {
                val activeLine = phrases[currentIndex.coerceIn(0, phrases.lastIndex)]
                PhraseCard(
                    line = activeLine,
                    isFavorite = activeLine.id in uiState.favoriteIds,
                    showReadingText = uiState.showReadingText && !localHideReading,
                    showKhmerPhonetic = uiState.showKhmerPhonetic,
                    playbackState = uiState.playbackState,
                    onSpeakLanguage = { lang -> onSpeakPhrase(activeLine, lang) },
                    onSpeakAllThree = { onSpeakAllThree(activeLine) },
                    onToggleFavorite = { onToggleFavorite(activeLine.id) }
                )

                // Prev / Next Controls
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            currentIndex = if (currentIndex > 0) currentIndex - 1 else phrases.lastIndex
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .testTag("practice_prev_button"),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(text = stringResource(R.string.practice_prev))
                    }

                    Button(
                        onClick = {
                            currentIndex = if (currentIndex < phrases.lastIndex) currentIndex + 1 else 0
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .testTag("practice_next_button"),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(text = stringResource(R.string.practice_next))
                        Spacer(modifier = Modifier.size(6.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}
