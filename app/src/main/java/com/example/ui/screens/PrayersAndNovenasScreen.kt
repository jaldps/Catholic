package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.audio.LiturgicalTtsManager
import com.example.data.models.AppLanguage
import com.example.data.models.Novena
import com.example.data.models.PrayerCategory
import com.example.data.models.VaticanPrayer
import com.example.data.repository.CatholicDataRepository
import com.example.ui.theme.LiturgicalGold
import com.example.ui.theme.SacredBurgundy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrayersAndNovenasScreen(
    repository: CatholicDataRepository,
    ttsManager: LiturgicalTtsManager,
    currentLanguage: AppLanguage,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) } // 0 = Devocionario Vaticano, 1 = Novenas Milagrosas

    // Devocionario State
    var prayerSearchQuery by remember { mutableStateOf("") }
    var selectedThematicTag by remember { mutableStateOf<String?>(null) }

    // Novenas State
    var selectedNovena by remember { mutableStateOf<Novena?>(null) }
    var activeNovenaDay by remember { mutableIntStateOf(1) } // 1..9
    var novenaCompletedDays by remember { mutableStateOf(setOf(1)) }
    var personalIntention by remember { mutableStateOf("") }

    val isPlayingAudio by ttsManager.isPlaying.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("prayers_and_novenas_screen")
    ) {
        PrimaryTabRow(
            selectedTabIndex = selectedTab,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = SacredBurgundy
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = {
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.ES -> "Devocionario Oficial"
                            AppLanguage.EN -> "Vatican Prayers"
                            AppLanguage.PT -> "Devocionário Oficial"
                        },
                        fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 13.sp
                    )
                }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = {
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.ES -> "Novenas Milagrosas"
                            AppLanguage.EN -> "Miraculous Novenas"
                            AppLanguage.PT -> "Novenas Milagrosas"
                        },
                        fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 13.sp
                    )
                }
            )
            Tab(
                selected = selectedTab == 2,
                onClick = { selectedTab = 2 },
                text = {
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.ES -> "Oración de la Noche"
                            AppLanguage.EN -> "Night Prayers"
                            AppLanguage.PT -> "Oração da Noite"
                        },
                        fontWeight = if (selectedTab == 2) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 13.sp
                    )
                }
            )
        }

        when (selectedTab) {
            0 -> {
                // Vatican Devocionario View
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    // Search box
                    OutlinedTextField(
                        value = prayerSearchQuery,
                        onValueChange = { prayerSearchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("prayer_search_input"),
                        placeholder = {
                            Text(
                                when (currentLanguage) {
                                    AppLanguage.ES -> "Buscar oración o necesidad..."
                                    AppLanguage.EN -> "Search prayer or petition..."
                                    AppLanguage.PT -> "Buscar oração ou intenção..."
                                }
                            )
                        },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        },
                        shape = RoundedCornerShape(14.dp),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Thematic Filter Chips
                    val tags = listOf(
                        null to when (currentLanguage) { AppLanguage.ES -> "Todas"; AppLanguage.EN -> "All"; AppLanguage.PT -> "Todas" },
                        "health" to when (currentLanguage) { AppLanguage.ES -> "Salud y Sanación"; AppLanguage.EN -> "Health & Healing"; AppLanguage.PT -> "Saúde e Cura" },
                        "peace" to when (currentLanguage) { AppLanguage.ES -> "Paz y Serenidad"; AppLanguage.EN -> "Peace of Mind"; AppLanguage.PT -> "Paz de Espírito" },
                        "family" to when (currentLanguage) { AppLanguage.ES -> "Familia"; AppLanguage.EN -> "Family"; AppLanguage.PT -> "Família" },
                        "protection" to when (currentLanguage) { AppLanguage.ES -> "Protección"; AppLanguage.EN -> "Protection"; AppLanguage.PT -> "Proteção" },
                        "forgiveness" to when (currentLanguage) { AppLanguage.ES -> "Perdón y Confesión"; AppLanguage.EN -> "Forgiveness"; AppLanguage.PT -> "Perdão" }
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(tags) { (tagKey, tagLabel) ->
                            val isSelected = selectedThematicTag == tagKey
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(if (isSelected) SacredBurgundy else MaterialTheme.colorScheme.surface)
                                    .border(
                                        1.dp,
                                        if (isSelected) SacredBurgundy else MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                                        RoundedCornerShape(12.dp)
                                    )
                                    .clickable { selectedThematicTag = tagKey }
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = tagLabel,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    val filteredPrayers = repository.searchPrayers(
                        query = prayerSearchQuery,
                        tag = selectedThematicTag
                    )

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(14.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(filteredPrayers) { prayer ->
                            VaticanPrayerCard(
                                prayer = prayer,
                                currentLanguage = currentLanguage,
                                onPlayAudio = {
                                    ttsManager.speakDialogue(
                                        prayer.leaderText.get(currentLanguage),
                                        prayer.responseText?.get(currentLanguage) ?: ""
                                    )
                                }
                            )
                        }
                    }
                }
            }

            1 -> {
                // Miraculous Novenas View
                if (selectedNovena == null) {
                    // List of Novenas
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.ES -> "Novenas Oficiales con Control de 9 Días"
                                    AppLanguage.EN -> "Official Novenas with 9-Day Tracker"
                                    AppLanguage.PT -> "Novenas Oficiais com Controle de 9 Dias"
                                },
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = SacredBurgundy
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.ES -> "Lleva el seguimiento diario de tus oraciones, registra tus intenciones y recibe consuelo en la promesa de Dios."
                                    AppLanguage.EN -> "Track your 9-day prayer progress, record your deepest intentions, and receive divine consolation."
                                    AppLanguage.PT -> "Acompanhe diariamente suas novenas com registro de intenções e perseverança na oração."
                                },
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        items(repository.officialNovenas) { novena ->
                            NovenaOverviewCard(
                                novena = novena,
                                currentLanguage = currentLanguage,
                                onClick = {
                                    selectedNovena = novena
                                    activeNovenaDay = 1
                                }
                            )
                        }
                    }
                } else {
                    // Open Novena Day Tracker View
                    val novena = selectedNovena!!
                    val dayData = novena.days.firstOrNull { it.dayNumber == activeNovenaDay } ?: novena.days.first()

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextButton(
                                    onClick = { selectedNovena = null },
                                    modifier = Modifier.testTag("back_to_novenas_button")
                                ) {
                                    Text("← " + when (currentLanguage) {
                                        AppLanguage.ES -> "Lista de Novenas"
                                        AppLanguage.EN -> "All Novenas"
                                        AppLanguage.PT -> "Todas as Novenas"
                                    }, fontWeight = FontWeight.Bold)
                                }

                                Text(
                                    text = novena.category.get(currentLanguage),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = LiturgicalGold
                                )
                            }
                        }

                        item {
                            Text(
                                text = novena.title.get(currentLanguage),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = SacredBurgundy
                            )
                            Text(
                                text = novena.patron.get(currentLanguage),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Day Selector Circles (1 to 9)
                        item {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                tonalElevation = 2.dp
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "PROGRESO: DÍA $activeNovenaDay DE 9",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = LiturgicalGold
                                        )
                                        Text(
                                            text = "${novenaCompletedDays.size} rezados",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        (1..9).forEach { dayNum ->
                                            val isSelected = dayNum == activeNovenaDay
                                            val isCompleted = novenaCompletedDays.contains(dayNum)

                                            Box(
                                                modifier = Modifier
                                                    .size(32.dp)
                                                    .clip(CircleShape)
                                                    .background(
                                                        when {
                                                            isSelected -> SacredBurgundy
                                                            isCompleted -> LiturgicalGold
                                                            else -> MaterialTheme.colorScheme.surface
                                                        }
                                                    )
                                                    .border(
                                                        1.dp,
                                                        if (isSelected) LiturgicalGold else MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                                                        CircleShape
                                                    )
                                                    .clickable { activeNovenaDay = dayNum },
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = "$dayNum",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 12.sp,
                                                    color = when {
                                                        isSelected -> Color.White
                                                        isCompleted -> Color.Black
                                                        else -> MaterialTheme.colorScheme.onSurface
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Daily Scripture & Meditation
                        item {
                            ElevatedCard(
                                shape = RoundedCornerShape(18.dp),
                                colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface)
                            ) {
                                Column(modifier = Modifier.padding(18.dp)) {
                                    Text(
                                        text = dayData.theme.get(currentLanguage),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = SacredBurgundy
                                    )
                                    Text(
                                        text = dayData.scripture,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = LiturgicalGold
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Text(
                                        text = dayData.meditation.get(currentLanguage),
                                        style = MaterialTheme.typography.bodyMedium,
                                        lineHeight = 22.sp
                                    )

                                    Spacer(modifier = Modifier.height(14.dp))

                                    // Intention guidance
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(10.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(Icons.Default.Info, contentDescription = null, tint = SacredBurgundy, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = dayData.intentionGuidance.get(currentLanguage),
                                                fontSize = 11.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // Prayer of the Day & Action to Mark Completed
                        item {
                            ElevatedCard(
                                shape = RoundedCornerShape(18.dp),
                                colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                            ) {
                                Column(modifier = Modifier.padding(18.dp)) {
                                    Text(
                                        text = when (currentLanguage) {
                                            AppLanguage.ES -> "Oración del Día $activeNovenaDay"
                                            AppLanguage.EN -> "Prayer for Day $activeNovenaDay"
                                            AppLanguage.PT -> "Oração do Dia $activeNovenaDay"
                                        },
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp,
                                        color = SacredBurgundy
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = dayData.prayer.get(currentLanguage),
                                        fontFamily = FontFamily.Serif,
                                        style = MaterialTheme.typography.bodyLarge,
                                        lineHeight = 24.sp
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        ElevatedButton(
                                            onClick = {
                                                ttsManager.speakSingle(dayData.prayer.get(currentLanguage))
                                            },
                                            modifier = Modifier.weight(1f),
                                            colors = ButtonDefaults.elevatedButtonColors(
                                                containerColor = SacredBurgundy,
                                                contentColor = Color.White
                                            )
                                        ) {
                                            Icon(Icons.Default.VolumeUp, contentDescription = null, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text("Escuchar", fontSize = 12.sp)
                                        }

                                        FilledTonalButton(
                                            onClick = {
                                                novenaCompletedDays = novenaCompletedDays + activeNovenaDay
                                                if (activeNovenaDay < 9) activeNovenaDay++
                                            },
                                            modifier = Modifier.weight(1f),
                                            colors = ButtonDefaults.filledTonalButtonColors(
                                                containerColor = LiturgicalGold,
                                                contentColor = Color.Black
                                            )
                                        ) {
                                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text("Completar Día", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            2 -> {
                NightPrayersScreen(
                    repository = repository,
                    ttsManager = ttsManager,
                    currentLanguage = currentLanguage
                )
            }
        }
    }
}

@Composable
private fun VaticanPrayerCard(
    prayer: VaticanPrayer,
    currentLanguage: AppLanguage,
    onPlayAudio: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = CardDefaults.outlinedCardBorder().copy(width = 0.5.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = prayer.title.get(currentLanguage),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = SacredBurgundy
                    )
                    if (prayer.latinTitle != null) {
                        Text(
                            text = prayer.latinTitle,
                            fontSize = 11.sp,
                            fontFamily = FontFamily.Serif,
                            color = LiturgicalGold
                        )
                    }
                }

                IconButton(
                    onClick = onPlayAudio,
                    modifier = Modifier.testTag("play_prayer_audio_${prayer.id}")
                ) {
                    Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Listen to Prayer", tint = SacredBurgundy)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "V/. " + prayer.leaderText.get(currentLanguage),
                fontFamily = FontFamily.Serif,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 22.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            if (prayer.responseText != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "R/. " + prayer.responseText.get(currentLanguage),
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = LiturgicalGold,
                    lineHeight = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "⏱ " + prayer.whenToPray.get(currentLanguage),
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (prayer.indulgenceNote != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "✦ " + prayer.indulgenceNote.get(currentLanguage),
                    fontSize = 10.sp,
                    color = SacredBurgundy,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun NovenaOverviewCard(
    novena: Novena,
    currentLanguage: AppLanguage,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        border = CardDefaults.outlinedCardBorder().copy(width = 0.5.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = novena.title.get(currentLanguage),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = SacredBurgundy
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(LiturgicalGold.copy(alpha = 0.2f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "9 DÍAS",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = SacredBurgundy
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = novena.patron.get(currentLanguage),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = LiturgicalGold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = novena.description.get(currentLanguage),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Promesas y Milagros Registrados",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Comenzar / Continuar →",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
