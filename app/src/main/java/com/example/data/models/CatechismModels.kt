package com.example.data.models

data class CatechismSection(
    val partNumber: Int, // 1, 2, 3, 4
    val sectionNumber: Int,
    val title: LocalizedText,
    val chapters: List<CatechismChapter>
)

data class CatechismChapter(
    val chapterNumber: Int,
    val title: LocalizedText,
    val articleRangeDisplay: String, // e.g. "§§ 1 - 25"
    val articles: List<CatechismNumberedArticle>
)

data class CatechismNumberedArticle(
    val cccNumber: Int, // e.g. 1, 27, 1324, 1857
    val title: LocalizedText,
    val content: LocalizedText,
    val biblicalReferences: String? = null,
    val inBriefSummary: LocalizedText? = null
)

data class CatechismPart(
    val partNumber: Int, // 1 to 4
    val title: LocalizedText,
    val subtitle: LocalizedText,
    val cccRange: String, // e.g. "§§ 1 - 1065"
    val description: LocalizedText,
    val sections: List<CatechismSection>
)
