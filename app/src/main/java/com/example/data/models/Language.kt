package com.example.data.models

import java.util.Locale

enum class AppLanguage(val code: String, val displayName: String, val flag: String) {
    ES("es", "Español", "🇪🇸"),
    EN("en", "English", "🇺🇸"),
    PT("pt", "Português", "🇧🇷");

    companion object {
        fun fromCode(code: String): AppLanguage {
            return when (code.lowercase()) {
                "es" -> ES
                "pt" -> PT
                "en" -> EN
                else -> {
                    val defaultLang = Locale.getDefault().language
                    when (defaultLang) {
                        "es" -> ES
                        "pt" -> PT
                        else -> EN
                    }
                }
            }
        }
    }
}

data class LocalizedText(
    val es: String,
    val en: String,
    val pt: String
) {
    fun get(lang: AppLanguage): String = when (lang) {
        AppLanguage.ES -> es
        AppLanguage.EN -> en
        AppLanguage.PT -> pt
    }
}
