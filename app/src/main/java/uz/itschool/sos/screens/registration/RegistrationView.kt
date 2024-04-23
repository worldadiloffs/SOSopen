package uz.itschool.sos.screens.registration

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun RegistrationView(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Registratsiya", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                value = name,
                onValueChange = {name = it},
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Ism", color = Registration_label)},
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Registration_line,
                    focusedIndicatorColor = Registration_label,
                    focusedLabelColor = Registration_label,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = surname,
                onValueChange = {surname = it},
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Familiya", color = Registration_label)},
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Registration_line,
                    focusedIndicatorColor = Registration_label,
                    focusedLabelColor = Registration_label,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = number,
                onValueChange = {number = it},
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Raqam", color = Registration_label)},
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Registration_line,
                    focusedIndicatorColor = Registration_label,
                    focusedLabelColor = Registration_label,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                prefix = { Text(text = "+998 ", color = Registration_label)},
                maxLines = 9
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = email,
                onValueChange = {email = it},
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Email", color = Registration_label)},
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
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = repeatPassword,
                onValueChange = {repeatPassword = it},
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Parolni takrorlang", color = Registration_label)},
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
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { navController.navigate(ScreenType.Main.route) }, colors = ButtonDefaults.buttonColors(
                Registration_Button
            )) {
                Text(text = "Akkaunt yaratish", color = Registration_label, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp), fontSize = 16.sp)

            }
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Text(text = "Akkauntingiz bormi? ", fontSize = 14.sp)
                Text(text = "Kirish", color = Registration_Button, fontSize = 14.sp, modifier = Modifier.clickable {  navController.navigate(
                    ScreenType.Login.route) })
            }
        }
        Column {

        }
    }
}




