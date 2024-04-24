package uz.itschool.sos.screens.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.itschool.sos.R
import uz.itschool.sos.model.User
import uz.itschool.sos.navigation.ScreenType
import uz.itschool.sos.util.SharedPreferences

@Composable
fun SettingsView(navController: NavController) {
    Profile(navController = navController)
}

@Composable
fun Profile(navController: NavController) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var sliderPosition2 by remember { mutableFloatStateOf(0f) }
    var sliderPosition3 by remember { mutableFloatStateOf(0f) }
    var checked by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(true) }
    var checked3 by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 15.dp, end = 15.dp)
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Box(modifier = Modifier.size(130.dp)) {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Card(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.BottomEnd)
                        .padding(end = 10.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(50),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                    ) {
                        Icon(imageVector = Icons.Outlined.Edit, contentDescription = "")
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Ism",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            ProfileOutlinedEditText(string = "Ismingiz o'zgartirish", type = "name")
            Spacer(modifier = Modifier.height(10.dp))
            ProfileOutlinedEditText(string = "Emailingiz o'zgartirish", type = "email")
            Spacer(modifier = Modifier.height(10.dp))
            ProfileOutlinedEditText(string = "Joylashuv o'zgartirish", type = "")
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Chiroq darajasi", modifier = Modifier
                    .padding(horizontal = 16.dp).align(Alignment.Start),
                textAlign = TextAlign.Start,
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.wb_sunny_ic), contentDescription = "",
                    modifier = Modifier.padding(end = 25.dp, top = 12.dp)
                )

                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it }
                )
            }
            Text(
                text = "Vibratsiya darajsi", modifier = Modifier
                    .padding(horizontal = 16.dp).align(Alignment.Start),
                textAlign = TextAlign.Start,
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications, contentDescription = "",
                    modifier = Modifier.padding(end = 25.dp, top = 12.dp)
                )

                Slider(
                    value = sliderPosition3,
                    onValueChange = { sliderPosition3 = it }
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                Text(
                    text = "Maxsus istisnolardan boshqa \nbarcha signallar ovozini o`chiring"
                )
                Spacer(modifier = Modifier.width(20.dp))
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navController.navigate(ScreenType.Login.route)
            }) {
                Text(
                    text = "Chiqish",
                    color = Color.White
                )
            }
//            Card(modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 10.dp, end = 10.dp), shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(5.dp), colors = CardDefaults.cardColors(
//                Color.White)) {
//                Row(modifier = Modifier.fillMaxWidth()) {
//                    Icon(painter = painterResource(id = R.drawable.logout_ic), contentDescription = )
//                }
//            }


//            Button(onClick = {
//                Manager.giveToken(context,"")
//                navController.navigate(ScreenType.Login.route)
//            }) {
//                androidx.compose.material3.Text(text = "log out", color = Color.Red)
//            }
        }
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileOutlinedEditText(string: String, type: String) {
    var text by remember { mutableStateOf(string) }
    var state by remember { mutableStateOf(true) }

    val mainIcon = when (type) {
        "name" -> Icons.Outlined.Person
        "email" -> Icons.Outlined.Email
        else -> Icons.Outlined.LocationOn
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            readOnly = state,
            leadingIcon = {
                Icon(
                    imageVector = mainIcon,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Unspecified
            ),
            singleLine = true
        )
    }
}

@Composable
@Preview
fun ProfilePreview() {
    Profile(navController = rememberNavController())
}