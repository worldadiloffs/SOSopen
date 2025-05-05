package uz.itschool.sos.screens.Saved

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlin.math.roundToInt

@Composable
fun SaveView(navController: NavController) {
    val viewModel: AudioPlayerViewModel = viewModel()
    val context = LocalContext.current

    val isPlaying by viewModel.isPlaying.collectAsState()
    val currentPosition by viewModel.currentPosition.collectAsState()
    val duration by viewModel.duration.collectAsState()
    val audioFiles by viewModel.audioFiles.collectAsState()

    var showAddDialog by remember { mutableStateOf(false) }
    var newFileName by remember { mutableStateOf("") }

    // File picker launcher
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            if (newFileName.isNotBlank()) {
                viewModel.addAudioFile(context, it, newFileName)
                showAddDialog = false
                newFileName = ""
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadAudioFiles(context)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Main content (scrollable)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display audio files list
            if (audioFiles.isNotEmpty()) {
                Text("Mavjud ovozlar:", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))

                audioFiles.forEach { file ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(file, modifier = Modifier.weight(1f))
                        Button(
                            onClick = { viewModel.playAudio(context, file) },
                            enabled = !isPlaying
                        ) {
                            Text("Ijro etish")
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            } else {
                Text("Ovozlar mavjud emas", style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Progress indicator when playing
            if (isPlaying) {
                val progress = if (duration > 0) {
                    (currentPosition.toFloat() / duration.toFloat() * 100).roundToInt()
                } else {
                    0
                }

                Text("Ijro etilmoqda...")
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = progress / 100f,
                    modifier = Modifier.fillMaxWidth()
                )
                Text("${currentPosition / 1000} sec / ${duration / 1000} sec")

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { viewModel.stopAudio() }) {
                    Text("To'xtatish")
                }
            }
        }

        // Add new audio button at the bottom
        Button(
            onClick = { showAddDialog = true },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Ovoz qo'shish")
        }
    }

    // Dialog for adding new audio
    if (showAddDialog) {
        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            title = { Text("Yangi ovoz qo'shish") },
            text = {
                Column {
                    Text("Audio fayl nomini kiriting (kengaytma bilan):")
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = newFileName,
                        onValueChange = { newFileName = it },
                        placeholder = { Text("*ovoz.mp3") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (newFileName.isNotBlank()) {
                            filePickerLauncher.launch("audio/*")
                        }
                    },
                    enabled = newFileName.isNotBlank()
                ) {
                    Text("Ovozni tanlash")
                }
            },
            dismissButton = {
                Button(onClick = { showAddDialog = false }) {
                    Text("Bekor qilish")
                }
            }
        )
    }
}