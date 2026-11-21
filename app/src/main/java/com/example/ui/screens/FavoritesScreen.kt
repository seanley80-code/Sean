package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.ConversationLine
import com.example.model.LanguageType
import com.example.model.SpeechSpeed
import com.example.ui.components.PhraseCard
import com.example.ui.components.SpeedSelectorBar
import com.example.ui.viewmodel.ConversationUiState

@Composable
fun FavoritesScreen(
    uiState: ConversationUiState,
    onSelectSpeed: (SpeechSpeed) -> Unit,
    onSpeakPhrase: (ConversationLine, LanguageType) -> Unit,
    onSpeakAllThree: (ConversationLine) -> Unit,
    onToggleFavorite: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 840.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Text(
                    text = stringResource(R.string.favorites_title),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            item {
                SpeedSelectorBar(
                    selectedSpeed = uiState.speechSpeed,
                    onSelectSpeed = onSelectSpeed
                )
            }

            if (uiState.favoritePhrases.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 28.dp, horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_empty_favorites),
                            contentDescription = stringResource(R.string.cd_empty_favorites),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(width = 220.dp, height = 165.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                        Text(
                            text = stringResource(R.string.favorites_empty_title),
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(R.string.favorites_empty_subtitle),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                items(uiState.favoritePhrases, key = { it.id }) { line ->
                    PhraseCard(
                        line = line,
                        isFavorite = true,
                        showReadingText = uiState.showReadingText,
                        showKhmerPhonetic = uiState.showKhmerPhonetic,
                        playbackState = uiState.playbackState,
                        onSpeakLanguage = { lang -> onSpeakPhrase(line, lang) },
                        onSpeakAllThree = { onSpeakAllThree(line) },
                        onToggleFavorite = { onToggleFavorite(line.id) }
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }
        }
    }
}
