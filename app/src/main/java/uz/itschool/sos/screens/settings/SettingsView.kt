package uz.itschool.sos.screens.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.itschool.sos.R

@Composable
fun SettingsView(navController: NavController){

}

@Composable
fun Profile(navController: NavController) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var sliderPosition2 by remember { mutableFloatStateOf(0f) }
    var sliderPosition3 by remember { mutableFloatStateOf(0f) }
    var checked by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(true) }
    var checked3 by remember { mutableStateOf(true) }
    val shared = SharedPreferences.getInstance(LocalContext.current)
    var user = shared.getUser()!!
    val context = LocalContext.current
//    val user = shared.getUser()!!

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
            Text(
                text = "Profile",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
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
                text = user!!.name,
                fontWeight = FontWeight.Bold,
                color = GreenPrimary,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            ProfileOutlinedEditText(string = user.username, type = "name")
            Spacer(modifier = Modifier.height(10.dp))
            ProfileOutlinedEditText(string = user.email, type = "email")
            Spacer(modifier = Modifier.height(10.dp))
            ProfileOutlinedEditText(string = user.location, type = "location")
            Spacer(modifier = Modifier.height(10.dp))
            ProfileOutlinedEditText(string = user.education, type = "education")
            Spacer(modifier = Modifier.height(10.dp))
            ProfileOutlinedEditText(string = user.bio, type = "bio")
            Spacer(modifier = Modifier.height(10.dp))
            ProfileOutlinedEditText(string = user.age, type = "age")
            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                Icon(
                    imageVector = Icons.Outlined.WbSunny, contentDescription = "",
                    modifier = Modifier.padding(end = 25.dp, top = 12.dp)
                )

                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it }
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                Icon(
                    imageVector = Icons.Outlined.VolumeUp, contentDescription = "",
                    modifier = Modifier.padding(end = 25.dp, top = 12.dp)
                )

                Slider(
                    value = sliderPosition2,
                    onValueChange = { sliderPosition2 = it }
                )
            }
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
                    text = "Show notifications"
                )



                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                Text(
                    text = "Allow others to know your interests"
                )



                Switch(
                    checked = checked2,
                    onCheckedChange = {
                        checked2 = it
                    }
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)

            ) {
                Text(
                    text = "Allow to record your progress"
                )



                Switch(
                    checked = checked3,
                    onCheckedChange = {
                        checked3 = it
                    }
                )
            }

            Button(onClick = {
                shared.setUser(User("admin","","","","","",""))
                navController.navigate(ScreenType.LoginScreen.route)
            }) {
                Text(text = "Log out",
                    color = Color.White)
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

@Composable
fun ProfileOutlinedEditText(string: String, type: String) {
    var text by remember { mutableStateOf(string) }
    var state by remember { mutableStateOf(true) }

    val mainIcon = when (type) {
        "name" -> Icons.Outlined.Person
        "email" -> Icons.Outlined.Email
        "education" -> Icons.Outlined.School
        "bio" -> Icons.Outlined.Contacts
        "age" -> Icons.Outlined.Cake
        else -> Icons.Outlined.LocationOn
    }
    val shared = SharedPreferences.getInstance(LocalContext.current)
    var user = shared.getUser()!!
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
            trailingIcon = {
                if (state) {
                    IconButton(onClick = { state = false }, modifier = Modifier.size(25.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit_ic),
                            contentDescription = "",
                            tint = ProfilePrimary
                        )
                    }
                } else {
                    IconButton(onClick = {
                        state = true
                        when (type) {
                            "email" -> user.email = text
                            "name" -> user.username = text
                            "location" -> user.location = text
                            "bio" -> user.bio = text
                            "age" -> user.age = text
                            "education" -> user.education = text
                        }
                        shared.setUser(user)
                        var u = shared.getUsers()
                        u!!.add(user)
                        shared.setUsers(u)
                    }, modifier = Modifier.size(25.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.confirm_ic),
                            contentDescription = "",
                            tint = ProfilePrimary
                        )
                    }
                }
            },
            leadingIcon = {
                Icon(
                    imageVector = mainIcon,
                    contentDescription = "",
                    tint = ProfilePrimary
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(color = ProfilePrimary, fontSize = 15.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = GreenPrimary,
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