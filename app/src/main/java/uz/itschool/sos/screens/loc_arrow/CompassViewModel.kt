package uz.itschool.sos.screens.loc_arrow

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.itschool.sos.screens.loc_arrow.CompassSensorManager

class CompassViewModel(context: Context) : ViewModel() {
    private val compassManager = CompassSensorManager(context)

    private val _azimuth = MutableStateFlow(0f)
    val azimuth: StateFlow<Float> = _azimuth

    private val _soundDirection = MutableStateFlow(240.3f)
    val soundDirection: StateFlow<Float> = _soundDirection

    init {
        compassManager.start()
        viewModelScope.launch {
            compassManager.azimuth.observeForever { azimuth ->
                _azimuth.value = azimuth
            }
        }
    }

    fun updateSoundDirection(direction: Float) {
        _soundDirection.value = direction
    }

    override fun onCleared() {
        super.onCleared()
        compassManager.stop()
    }

    companion object {
        fun provideFactory(context: Context): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CompassViewModel(context) as T
                }
            }
        }
    }
}