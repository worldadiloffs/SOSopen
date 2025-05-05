package uz.itschool.sos.screens.Saved

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File

class AudioPlayerViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying = _isPlaying.asStateFlow()

    private val _currentPosition = MutableStateFlow(0)
    val currentPosition = _currentPosition.asStateFlow()

    private val _duration = MutableStateFlow(0)
    val duration = _duration.asStateFlow()

    private val _audioFiles = MutableStateFlow<List<String>>(emptyList())
    val audioFiles = _audioFiles.asStateFlow()

    fun loadAudioFiles(context: Context) {
        viewModelScope.launch {
            val files = context.externalCacheDir?.listFiles()?.filter {
                it.extension == "mp3" || it.extension == "wav" || it.extension == "ogg"
            }?.map { it.name } ?: emptyList()
            _audioFiles.value = files
        }
    }

    fun playAudio(context: Context, audioFile: String) {
        stopAudio() // Stop any currently playing audio

        mediaPlayer = MediaPlayer().apply {
            setDataSource(File(context.externalCacheDir, audioFile).absolutePath)
            prepare()
            start()

            _duration.value = this.duration
            _isPlaying.value = true

            setOnCompletionListener {
                _isPlaying.value = false
                _currentPosition.value = 0
            }
        }

        // Update progress
        viewModelScope.launch {
            while (_isPlaying.value) {
                mediaPlayer?.let {
                    _currentPosition.value = it.currentPosition
                }
                kotlinx.coroutines.delay(100)
            }
        }
    }

    fun stopAudio() {
        mediaPlayer?.release()
        mediaPlayer = null
        _isPlaying.value = false
        _currentPosition.value = 0
    }

    fun addAudioFile(context: Context, uri: Uri, fileName: String) {
        viewModelScope.launch {
            try {
                context.contentResolver.openInputStream(uri)?.use { inputStream ->
                    val outputFile = File(context.externalCacheDir, fileName)
                    outputFile.outputStream().use { outputStream ->
                        inputStream.copyTo(outputStream)
                    }
                }
                loadAudioFiles(context) // Refresh the list
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        stopAudio()
    }
}