package uz.itschool.sos.screens.Saved

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SaveView(navController: NavController){
    Text(text = "Saqlangan ovozlar yo`q", textAlign = TextAlign.Center, modifier = Modifier.padding(top= 100.dp))
}