package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.VolumeUp
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.GraphicEq
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material.icons.rounded.StopCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.audio.TtsPlaybackState
import com.example.model.ConversationLine
import com.example.model.LanguageType
import com.example.model.PhraseTranslation
import com.example.ui.theme.LocalLanguageColors

@Composable
fun PhraseCard(
    line: ConversationLine,
    isFavorite: Boolean,
    showReadingText: Boolean,
    showKhmerPhonetic: Boolean,
    playbackState: TtsPlaybackState,
    onSpeakLanguage: (LanguageType) -> Unit,
    onSpeakAllThree: () -> Unit,
    onToggleFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    val langColors = LocalLanguageColors.current
    val isPlayingThisCardSequence = playbackState.isPlayingSequence && playbackState.activePhraseId == line.id

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .testTag("phrase_card_${line.id}"),
        shape = RoundedCornerShape(22.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(
            width = if (playbackState.activePhraseId == line.id) 1.5.dp else 1.dp,
            color = if (playbackState.activePhraseId == line.id) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)
            }
        ),
        tonalElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Card Header: Role pill + Play All 3 + Favorite
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(50),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = line.speakerRoleKm,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Surface(
                    onClick = onSpeakAllThree,
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .testTag("play_all_${line.id}"),
                    shape = RoundedCornerShape(50),
                    color = if (isPlayingThisCardSequence) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f)
                    }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = if (isPlayingThisCardSequence) {
                                Icons.Rounded.StopCircle
                            } else {
                                Icons.Rounded.PlayCircle
                            },
                            contentDescription = null,
                            tint = if (isPlayingThisCardSequence) {
                                MaterialTheme.colorScheme.onPrimary
                            } else {
                                MaterialTheme.colorScheme.onPrimaryContainer
                            },
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = if (isPlayingThisCardSequence) {
                                stringResource(R.string.stop_audio)
                            } else {
                                stringResource(R.string.play_all_three)
                            },
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isPlayingThisCardSequence) {
                                MaterialTheme.colorScheme.onPrimary
                            } else {
                                MaterialTheme.colorScheme.onPrimaryContainer
                            }
                        )
                    }
                }

                IconButton(
                    onClick = onToggleFavorite,
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .testTag("favorite_button_${line.id}")
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = stringResource(R.string.cd_toggle_favorite),
                        tint = if (isFavorite) langColors.chineseAccent else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // 1. Khmer Language Row
            LanguagePhraseBlock(
                language = LanguageType.KHMER,
                translation = line.khmer,
                accentColor = langColors.khmerAccent,
                containerColor = langColors.khmerContainer,
                showReadingText = showReadingText,
                showKhmerPhonetic = showKhmerPhonetic,
                isSpeaking = playbackState.activePhraseId == line.id &&
                    playbackState.activeLanguage == LanguageType.KHMER,
                speakContentDescription = stringResource(R.string.cd_speak_khmer),
                testTag = "speak_km_${line.id}",
                onSpeak = { onSpeakLanguage(LanguageType.KHMER) }
            )

            // 2. English Language Row
            LanguagePhraseBlock(
                language = LanguageType.ENGLISH,
                translation = line.english,
                accentColor = langColors.englishAccent,
                containerColor = langColors.englishContainer,
                showReadingText = showReadingText,
                showKhmerPhonetic = showKhmerPhonetic,
                isSpeaking = playbackState.activePhraseId == line.id &&
                    playbackState.activeLanguage == LanguageType.ENGLISH,
                speakContentDescription = stringResource(R.string.cd_speak_english),
                testTag = "speak_en_${line.id}",
                onSpeak = { onSpeakLanguage(LanguageType.ENGLISH) }
            )

            // 3. Chinese Language Row
            LanguagePhraseBlock(
                language = LanguageType.CHINESE,
                translation = line.chinese,
                accentColor = langColors.chineseAccent,
                containerColor = langColors.chineseContainer,
                showReadingText = showReadingText,
                showKhmerPhonetic = showKhmerPhonetic,
                isSpeaking = playbackState.activePhraseId == line.id &&
                    playbackState.activeLanguage == LanguageType.CHINESE,
                speakContentDescription = stringResource(R.string.cd_speak_chinese),
                testTag = "speak_zh_${line.id}",
                onSpeak = { onSpeakLanguage(LanguageType.CHINESE) }
            )
        }
    }
}

@Composable
fun LanguagePhraseBlock(
    language: LanguageType,
    translation: PhraseTranslation,
    accentColor: Color,
    containerColor: Color,
    showReadingText: Boolean,
    showKhmerPhonetic: Boolean,
    isSpeaking: Boolean,
    speakContentDescription: String,
    testTag: String,
    onSpeak: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "speakingPulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isSpeaking) 1.12f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 520),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = if (isSpeaking) containerColor else containerColor.copy(alpha = 0.48f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(4.dp))
                    .background(accentColor)
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "${language.shortCode} • ${language.khmerName}",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = accentColor
                )

                Text(
                    text = translation.text,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                AnimatedVisibility(visible = showReadingText) {
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        if (showKhmerPhonetic && !translation.khmerPhonetic.isNullOrBlank()) {
                            Text(
                                text = "អាន៖ ${translation.khmerPhonetic}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                color = accentColor.copy(alpha = 0.92f)
                            )
                        }
                        Text(
                            text = translation.romanizedOrPinyin,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Surface(
                onClick = onSpeak,
                modifier = Modifier
                    .size(48.dp)
                    .scale(if (isSpeaking) pulseScale else 1f)
                    .testTag(testTag),
                shape = CircleShape,
                color = if (isSpeaking) accentColor else MaterialTheme.colorScheme.surface,
                border = BorderStroke(
                    width = 1.dp,
                    color = accentColor.copy(alpha = if (isSpeaking) 1f else 0.35f)
                )
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = if (isSpeaking) {
                            Icons.Rounded.GraphicEq
                        } else {
                            Icons.AutoMirrored.Rounded.VolumeUp
                        },
                        contentDescription = speakContentDescription,
                        tint = if (isSpeaking) Color.White else accentColor,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}
