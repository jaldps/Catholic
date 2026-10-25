package com.example.data.audio

import android.content.Context
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import com.example.data.models.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

enum class RecitationVoiceMode {
    MALE,
    FEMALE,
    DUAL_DIALOGUE // Leader in male, response in female (or vice versa)
}

class LiturgicalTtsManager(private val context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isInitialized = false

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _currentlySpeaking = MutableStateFlow<String?>(null)
    val currentlySpeaking: StateFlow<String?> = _currentlySpeaking.asStateFlow()

    private val _voiceMode = MutableStateFlow(RecitationVoiceMode.DUAL_DIALOGUE)
    val voiceMode: StateFlow<RecitationVoiceMode> = _voiceMode.asStateFlow()

    private val mainHandler = Handler(Looper.getMainLooper())
    private var toneGenerator: ToneGenerator? = null

    init {
        tts = TextToSpeech(context.applicationContext, this)
        try {
            toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 70)
        } catch (_: Exception) {
            toneGenerator = null
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isInitialized = true
            setLanguage(AppLanguage.ES)
            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _isPlaying.value = true
                }

                override fun onDone(utteranceId: String?) {
                    mainHandler.post {
                        _isPlaying.value = false
                        _currentlySpeaking.value = null
                    }
                }

                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) {
                    mainHandler.post {
                        _isPlaying.value = false
                        _currentlySpeaking.value = null
                    }
                }
            })
        }
    }

    fun setLanguage(lang: AppLanguage) {
        if (!isInitialized) return
        val targetLocale = when (lang) {
            AppLanguage.ES -> Locale("es", "ES")
            AppLanguage.EN -> Locale("en", "US")
            AppLanguage.PT -> Locale("pt", "BR")
        }
        tts?.language = targetLocale
    }

    fun setVoiceMode(mode: RecitationVoiceMode) {
        _voiceMode.value = mode
    }

    fun playSacredChime() {
        try {
            toneGenerator?.startTone(ToneGenerator.TONE_PROP_BEEP, 300)
        } catch (_: Exception) {}
    }

    fun speakSingle(text: String, isFemaleVoice: Boolean = false) {
        if (!isInitialized || text.isBlank()) return
        stop()

        val pitch = if (isFemaleVoice) 1.25f else 0.85f
        tts?.setPitch(pitch)
        tts?.setSpeechRate(0.92f)

        _currentlySpeaking.value = text
        _isPlaying.value = true
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "PRAYER_SINGLE_${System.currentTimeMillis()}")
    }

    fun speakDialogue(leaderText: String, responseText: String) {
        if (!isInitialized) return
        stop()

        playSacredChime()

        mainHandler.postDelayed({
            // Leader voice (Male)
            tts?.setPitch(0.85f)
            tts?.setSpeechRate(0.92f)
            _currentlySpeaking.value = leaderText
            _isPlaying.value = true
            tts?.speak(leaderText, TextToSpeech.QUEUE_FLUSH, null, "LEADER_PART")

            // Response voice (Female)
            if (responseText.isNotBlank()) {
                mainHandler.postDelayed({
                    tts?.setPitch(1.22f)
                    tts?.setSpeechRate(0.92f)
                    _currentlySpeaking.value = responseText
                    tts?.speak(responseText, TextToSpeech.QUEUE_ADD, null, "RESPONSE_PART")
                }, 1200)
            }
        }, 400)
    }

    fun stop() {
        tts?.stop()
        _isPlaying.value = false
        _currentlySpeaking.value = null
    }

    fun release() {
        stop()
        tts?.shutdown()
        tts = null
        toneGenerator?.release()
        toneGenerator = null
    }
}
