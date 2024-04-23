package uz.itschool.sos.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.sos.R
import uz.itschool.sos.model.Alerts

@Composable
fun HomeView(navController: NavController) {
    val list: MutableList<Alerts> = mutableListOf()
    list.add(Alerts("Hayvon ovozi", R.drawable.animal_img, Color.Green))
    list.add(Alerts("Mashina ovozi", R.drawable.car_img, Color.Blue))
    list.add(Alerts("Baland ovoz", R.drawable.public_relation, Color.Red))
    list.add(Alerts("Sizni chaqirishmoqda", R.drawable.calling_img, Color.Cyan))

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(list.size) { it ->
            Alerts(list[it])
        }
    }


}

@Composable
fun Alerts(alerts: Alerts) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(800.dp)
            .background(alerts.color), Alignment.Center
    ) {
        Column {
            Image(painter = painterResource(id = alerts.img), contentDescription = "", colorFilter = ColorFilter.tint(Color.White))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = alerts.name,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 25.sp,
                color = Color.White.copy(alpha = 1f)
            )
        }
    }
}