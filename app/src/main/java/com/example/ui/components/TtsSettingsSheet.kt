package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.audio.TtsLanguageStatus
import com.example.audio.TtsPlaybackState
import com.example.model.LanguageType
import com.example.ui.theme.LocalLanguageColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TtsSettingsSheet(
    showReadingText: Boolean,
    showKhmerPhonetic: Boolean,
    playbackState: TtsPlaybackState,
    onToggleReadingText: (Boolean) -> Unit,
    onToggleKhmerPhonetic: (Boolean) -> Unit,
    onOpenSystemTtsSettings: () -> Unit,
    onDismiss: () -> Unit
) {
    val langColors = LocalLanguageColors.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = stringResource(R.string.tts_settings_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Display preferences
            Surface(
                shape = RoundedCornerShape(18.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f))
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "បង្ហាញអក្សរអានខាងក្រោម",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "Pinyin, IPA & Romanized reading",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Switch(
                            checked = showReadingText,
                            onCheckedChange = onToggleReadingText,
                            modifier = Modifier.testTag("toggle_reading_switch")
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "បង្ហាញសូរអានជាអក្សរខ្មែរ",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "ជំនួយការអានអង់គ្លេស និងចិនជាអក្សរខ្មែរ",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Switch(
                            checked = showKhmerPhonetic && showReadingText,
                            enabled = showReadingText,
                            onCheckedChange = onToggleKhmerPhonetic,
                            modifier = Modifier.testTag("toggle_khmer_phonetic_switch")
                        )
                    }
                }
            }

            // Voice engine availability per language
            Text(
                text = "ស្ថានភាពសំឡេងលើទូរស័ព្ទ (TTS Voices)",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                LanguageType.entries.forEach { lang ->
                    val status = playbackState.languageStatus[lang] ?: TtsLanguageStatus.CHECKING
                    val isReady = status == TtsLanguageStatus.READY
                    val statusLabel = when (status) {
                        TtsLanguageStatus.READY -> "រួចរាល់ (Ready)"
                        TtsLanguageStatus.NEEDS_VOICE_DATA -> "ត្រូវការទាញយកសំឡេង"
                        TtsLanguageStatus.UNAVAILABLE -> "មិនទាន់មានក្នុងម៉ាស៊ីន TTS"
                        TtsLanguageStatus.CHECKING -> "កំពុងពិនិត្យ..."
                    }
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = if (isReady) Icons.Rounded.CheckCircle else Icons.Rounded.Info,
                                contentDescription = null,
                                tint = if (isReady) langColors.khmerAccent else langColors.goldAccent,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "${lang.khmerName} (${lang.nativeName})",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = statusLabel,
                                style = MaterialTheme.typography.labelMedium,
                                color = if (isReady) {
                                    langColors.khmerAccent
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                }
                            )
                        }
                    }
                }
            }

            Button(
                onClick = onOpenSystemTtsSettings,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("open_tts_settings_button"),
                shape = RoundedCornerShape(14.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = stringResource(R.string.tts_open_system_settings))
            }
        }
    }
}
