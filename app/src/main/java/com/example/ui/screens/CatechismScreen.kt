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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import com.example.data.models.AppLanguage
import com.example.data.models.CatechismChapter
import com.example.data.models.CatechismNumberedArticle
import com.example.data.models.CatechismPart
import com.example.data.repository.CatholicDataRepository
import com.example.ui.theme.LiturgicalGold
import com.example.ui.theme.SacredBurgundy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatechismScreen(
    repository: CatholicDataRepository,
    currentLanguage: AppLanguage,
    modifier: Modifier = Modifier
) {
    var selectedPartIndex by remember { mutableIntStateOf(0) } // 0..3 (Parts 1 to 4)
    var selectedChapter by remember { mutableStateOf<CatechismChapter?>(null) }
    var selectedArticleDetail by remember { mutableStateOf<CatechismNumberedArticle?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var fontSizeMultiplier by remember { mutableFloatStateOf(1f) }
    var useSerifFont by remember { mutableStateOf(true) }

    val parts = repository.catechismParts
    val currentPart = parts.getOrNull(selectedPartIndex) ?: parts.first()

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("catechism_screen")
    ) {
        // Search bar with CCC number quick search
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("ccc_search_input"),
                placeholder = {
                    Text(
                        when (currentLanguage) {
                            AppLanguage.ES -> "Buscar por n° de art. (ej. 1324) o tema..."
                            AppLanguage.EN -> "Search by CCC # (e.g. 1324) or topic..."
                            AppLanguage.PT -> "Buscar por nº art. (ex. 1324) ou tema..."
                        },
                        fontSize = 13.sp
                    )
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = SacredBurgundy)
                },
                trailingIcon = {
                    if (searchQuery.isNotBlank()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear")
                        }
                    }
                },
                shape = RoundedCornerShape(14.dp),
                singleLine = true
            )
        }

        if (searchQuery.isNotBlank()) {
            // Search Results Mode
            val numQuery = searchQuery.trim().toIntOrNull()
            val searchResults = remember(searchQuery, currentLanguage) {
                if (numQuery != null) {
                    val found = repository.findCatechismArticle(numQuery)
                    if (found != null) listOf(found) else emptyList()
                } else {
                    parts.flatMap { it.sections }
                        .flatMap { it.chapters }
                        .flatMap { it.articles }
                        .filter { art ->
                            art.title.get(currentLanguage).contains(searchQuery, ignoreCase = true) ||
                                    art.content.get(currentLanguage).contains(searchQuery, ignoreCase = true) ||
                                    art.cccNumber.toString() == searchQuery.trim()
                        }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(
                        text = "Resultados encontrados (${searchResults.size}):",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = SacredBurgundy
                    )
                }

                if (searchResults.isEmpty()) {
                    item {
                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "No se encontraron artículos con ese criterio de búsqueda.",
                                modifier = Modifier.padding(18.dp),
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                } else {
                    items(searchResults) { article ->
                        ArticleItemCard(
                            article = article,
                            currentLanguage = currentLanguage,
                            fontSizeMultiplier = fontSizeMultiplier,
                            useSerif = useSerifFont
                        )
                    }
                }
            }
        } else if (selectedChapter == null) {
            // 4 Pillars Tabs
            ScrollableTabRow(
                selectedTabIndex = selectedPartIndex,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = SacredBurgundy,
                edgePadding = 12.dp
            ) {
                parts.forEachIndexed { idx, p ->
                    Tab(
                        selected = selectedPartIndex == idx,
                        onClick = { selectedPartIndex = idx },
                        text = {
                            Text(
                                text = "Parte ${p.partNumber} (${p.cccRange})",
                                fontWeight = if (selectedPartIndex == idx) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 12.sp
                            )
                        }
                    )
                }
            }

            // Part Overview & Hierarchical Chapter Tree
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    ElevatedCard(
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Text(
                                text = currentPart.title.get(currentLanguage),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = SacredBurgundy
                            )
                            Text(
                                text = currentPart.subtitle.get(currentLanguage) + " • " + currentPart.cccRange,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = LiturgicalGold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = currentPart.description.get(currentLanguage),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                item {
                    Text(
                        text = "Índice de Secciones y Capítulos:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = SacredBurgundy
                    )
                }

                currentPart.sections.forEach { section ->
                    item {
                        Text(
                            text = section.title.get(currentLanguage),
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = LiturgicalGold,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }

                    items(section.chapters) { chapter ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .clickable { selectedChapter = chapter },
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                            border = CardDefaults.outlinedCardBorder().copy(width = 0.5.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                    Box(
                                        modifier = Modifier
                                            .size(34.dp)
                                            .clip(CircleShape)
                                            .background(MaterialTheme.colorScheme.primaryContainer),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "§",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column {
                                        Text(
                                            text = chapter.title.get(currentLanguage),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        Text(
                                            text = "Artículos: ${chapter.articleRangeDisplay} (${chapter.articles.size} destacados)",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }

                                Text("Leer →", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }
        } else {
            // Chapter Reading View with full articles
            val chapter = selectedChapter!!

            BackHandler {
                selectedChapter = null
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Header with back button & font scaling
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { selectedChapter = null },
                        modifier = Modifier.testTag("back_to_catechism_index")
                    ) {
                        Text("← Índice del Catecismo", fontWeight = FontWeight.Bold)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (fontSizeMultiplier > 0.85f) fontSizeMultiplier -= 0.15f }) {
                            Text("A-", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                        IconButton(onClick = { if (fontSizeMultiplier < 1.45f) fontSizeMultiplier += 0.15f }) {
                            Text("A+", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        }
                        IconButton(onClick = { useSerifFont = !useSerifFont }) {
                            Text(if (useSerifFont) "Serif" else "Sans", fontSize = 11.sp)
                        }
                    }
                }

                Text(
                    text = chapter.title.get(currentLanguage),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = SacredBurgundy
                )
                Text(
                    text = "Catecismo de la Iglesia Católica: ${chapter.articleRangeDisplay}",
                    fontSize = 11.sp,
                    color = LiturgicalGold
                )

                Spacer(modifier = Modifier.height(14.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(chapter.articles) { article ->
                        ArticleItemCard(
                            article = article,
                            currentLanguage = currentLanguage,
                            fontSizeMultiplier = fontSizeMultiplier,
                            useSerif = useSerifFont
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ArticleItemCard(
    article: CatechismNumberedArticle,
    currentLanguage: AppLanguage,
    fontSizeMultiplier: Float,
    useSerif: Boolean
) {
    ElevatedCard(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(SacredBurgundy)
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = "CIC § ${article.cccNumber}",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 11.sp
                    )
                }

                if (article.biblicalReferences != null) {
                    Text(
                        text = "Ref: ${article.biblicalReferences}",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = LiturgicalGold
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = article.title.get(currentLanguage),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = SacredBurgundy
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = article.content.get(currentLanguage),
                fontFamily = if (useSerif) FontFamily.Serif else FontFamily.Default,
                fontSize = (14.5f * fontSizeMultiplier).sp,
                lineHeight = (23 * fontSizeMultiplier).sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            if (article.inBriefSummary != null) {
                Spacer(modifier = Modifier.height(12.dp))
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
                            text = "En Resumen: " + article.inBriefSummary.get(currentLanguage),
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}
