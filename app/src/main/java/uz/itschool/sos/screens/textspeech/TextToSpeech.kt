package uz.itschool.sos.screens.textspeech

import android.Manifest
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.sos.R


@Composable
fun TextToSpeech(navController: NavController) {
    val context = LocalContext.current
    val voiceToText by lazy {
        VoiceToTextParser(context)
    }
    var textFieldState by remember { mutableStateOf("") }
    var canRecord by remember {
        mutableStateOf(false)
    }

    // Creates an permission request
    val recordAudioLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            canRecord = isGranted
        }
    )

    LaunchedEffect(key1 = recordAudioLauncher) {
        // Launches the permission request
        recordAudioLauncher.launch(Manifest.permission.RECORD_AUDIO)
    }

    val state by voiceToText.state.collectAsState()
    Column {
        OutlinedTextField(
            value = textFieldState,
            onValueChange = { textFieldState = it },
            label = {
                Text(
                    text = "Tovushga o`girish"
                )
            },
            placeholder = {
                Text(
                    text = "Shu yerga yozing"
                )
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(10.dp)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            FloatingActionButton(
                onClick = {
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.volume_up_ic),
                    contentDescription = null
                )
            }
            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )
            FloatingActionButton(
                onClick = {
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.save_ic),
                    contentDescription = null
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(16.dp)
                .background(color = Color.Black)
        )
        Scaffold(
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        if (canRecord) {
                            if (!state.isSpeaking) {
                                voiceToText.startListening("uz")
                            } else {
                                voiceToText.stopListening()
                            }
                        }
                    }
                ) {
                    AnimatedContent(targetState = state.isSpeaking) { isSpeaking ->
                        if (isSpeaking) {
                            Icon(
                                painterResource(id = R.drawable.mic_off_ic),
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                painterResource(id = R.drawable.mic_ic),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedContent(targetState = state.isSpeaking) { isSpeaking ->
                    if (isSpeaking) {
                        Text(
                            text = "Gapiring...",
                            style = MaterialTheme.typography.titleMedium
                        )
                    } else {
                        Text(
                            text = state.spokenText.ifEmpty { "Gapirish uchun bosing" },
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}

