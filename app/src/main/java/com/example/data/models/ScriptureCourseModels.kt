package com.example.data.models

data class ScriptureCourseTrack(
    val id: String,
    val title: LocalizedText,
    val description: LocalizedText,
    val iconName: String,
    val lessons: List<ScriptureLesson>
)

data class ScriptureLesson(
    val id: String,
    val trackId: String,
    val lessonNumber: Int,
    val title: LocalizedText,
    val biblicalReference: String,
    val biblicalPassageText: LocalizedText,
    val vaticanContext: LocalizedText,
    val lectioStep: LocalizedText,
    val meditatioStep: LocalizedText,
    val oratioStep: LocalizedText,
    val contemplatioStep: LocalizedText,
    val catechismRefs: List<String> = emptyList()
)
