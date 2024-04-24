package uz.itschool.sos.screens.loc_arrow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.itschool.sos.R

@Composable
fun ArrowLoc() {
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Column() {
            Text(
                text = "Tovush qayerdan kelayotganini bilish uchun strelka ko`rsatayotgan tomonga qarang",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black.copy(alpha = 1f)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Image(
                painter = painterResource(id = R.drawable.arrow_img),
                contentDescription = "",
                modifier = Modifier
                    .size(400.dp)
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Sizga nisbatan tovush kelayotgan taraf",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black.copy(alpha = 1f)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "240,3",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black.copy(alpha = 1f)
            )
        }
    }
}