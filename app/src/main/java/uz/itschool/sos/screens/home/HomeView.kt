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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.sos.R
import uz.itschool.sos.model.Alerts
import java.time.format.TextStyle

@Composable
fun HomeView(navController: NavController) {
    val list: MutableList<Alerts> = mutableListOf()
    list.add(Alerts("Hayvon ovozi","Sizga yaqin joyda hayvon ovozi kelmoqda", R.drawable.animal_img, Color(0xFF80BCBD)))
    list.add(Alerts("Mashina ovozi","Sizga yaqin joyda mashina signal chalmoqda", R.drawable.car_img, Color(0xFFAAD9BB)))
    list.add(Alerts("Baland ovoz","Sizga yaqin joyda yuqori chastotali ovoz kelmoqda", R.drawable.public_relation, Color(0xFFD5F0C1)))
    list.add(Alerts("Sizni chaqirishmoqda","Sizga yaqin joyda sizni chaqrishmoqda", R.drawable.calling_img, Color(0xFFF9F7C9)))

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
            .fillMaxSize().padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp)
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
            .background(alerts.color), Alignment.Center,
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = alerts.name,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black.copy(alpha = 1f)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(painter = painterResource(id = alerts.img), contentDescription = "", colorFilter = ColorFilter.tint(Color.Black), modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = alerts.description,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 16.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black.copy(alpha = 1f)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}