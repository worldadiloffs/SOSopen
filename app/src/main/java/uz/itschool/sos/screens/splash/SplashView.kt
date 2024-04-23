package uz.itschool.sos.screens.splash

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.itschool.sos.navigation.ScreenType
import uz.itschool.sos.util.SharedPreferences
import uz.itschool.sos.R
import uz.itschool.sos.ui.theme.Green_Primary
import uz.itschool.sos.ui.theme.SOS_Red

@Composable
fun SplashView(navController: NavController){
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        delay(2500)
        val route = getRoute(context)
        navController.navigate(route){
            popUpTo(navController.graph.id)
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Green_Primary), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.welcome_image), contentDescription = "", modifier = Modifier.size(width = 110.dp, height = 120.dp))
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Text(text = "SOS", fontSize = 18.sp, color = SOS_Red, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = "ga Xush Kelibsiz", color = Color.Black, fontSize = 18.sp)
        }
    }
}
private fun getRoute(context: Context): String {
    val shared = SharedPreferences.getInstance(context)
    return if (shared.getUser() == null){
        ScreenType.Registration.route
    }else{
        ScreenType.Home.route
    }
}
