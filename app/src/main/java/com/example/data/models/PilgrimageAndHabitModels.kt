package com.example.data.models

data class CatholicPilgrimageSanctuary(
    val id: String,
    val name: LocalizedText,
    val cityCountry: LocalizedText,
    val historicalOrigin: LocalizedText,
    val spiritualSignificance: LocalizedText,
    val relicsAndPatron: LocalizedText,
    val plenaryIndulgenceNote: LocalizedText,
    val practicalPilgrimAdvice: LocalizedText,
    val coordinateLatLong: Pair<Double, Double>
)

data class SpiritualHabitItem(
    val id: String,
    val title: LocalizedText,
    val category: LocalizedText,
    val timeSuggestion: String,
    val description: LocalizedText,
    val iconName: String
)

data class LiturgicalCalendarDay(
    val dayOfMonth: Int,
    val monthName: String,
    val liturgicalColorHex: Long,
    val seasonName: LocalizedText,
    val celebrationTitle: LocalizedText,
    val rank: LocalizedText, // Solemnity, Feast, Memorial, Ferial
    val fastingRule: LocalizedText? = null,
    val gospelVerseRef: String,
    val sundayCycle: LocalizedText? = null,
    val weekdayCycle: LocalizedText? = null,
    val isFastOrAbstinence: Boolean = false,
    val missalMeditation: LocalizedText? = null
)

data class SinAvoiderOption(
    val sinKey: String,
    val title: LocalizedText,
    val counterVirtue: LocalizedText,
    val advice: LocalizedText,
    val iconName: String
)

