package uz.itschool.sos.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.sos.navigation.ScreenType
import uz.itschool.sos.ui.theme.Registration_Button
import uz.itschool.sos.ui.theme.Registration_label
import uz.itschool.sos.ui.theme.Registration_line

@Composable
fun LoginView(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Card(elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .align(Alignment.Center)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Kirish",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    value = email,
                    onValueChange = {email = it},
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Email", color = Registration_label) },
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Registration_line,
                        focusedIndicatorColor = Registration_label,
                        focusedLabelColor = Registration_label,
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = password,
                    onValueChange = {password = it},
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Parol", color = Registration_label)},
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Registration_line,
                        focusedIndicatorColor = Registration_label,
                        focusedLabelColor = Registration_label,
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Spacer(modifier = Modifier.height(50.dp))
                Button(onClick = { navController.navigate(ScreenType.Main.route) }, colors = ButtonDefaults.buttonColors(Registration_Button)) {
                    Text(text = "Kirish", color = Registration_label, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 20.dp, end = 20.dp), fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Parolni unutdingizmi?", fontSize = 13.sp, modifier = Modifier.clickable {  })
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(text = "Akkauntingiz yo'qmi? ", fontSize = 14.sp)
                    Text(text = "Registratsiya", color = Registration_Button, fontSize = 14.sp, modifier = Modifier.clickable { navController.navigate(
                        ScreenType.Registration.route) })
                }
            }
        }
    }
}