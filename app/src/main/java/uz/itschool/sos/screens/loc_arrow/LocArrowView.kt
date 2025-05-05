package uz.itschool.sos.screens.loc_arrow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.itschool.sos.R
import uz.itschool.sos.screens.loc_arrow.CompassViewModel

@Composable
fun LocArrowView() {
    val context = LocalContext.current
    val viewModel: CompassViewModel = viewModel(
        factory = CompassViewModel.provideFactory(context)
    )
    val azimuth by viewModel.azimuth.collectAsState()
    val soundDirection by viewModel.soundDirection.collectAsState()

    val arrowRotation by remember(azimuth, soundDirection) {
        derivedStateOf { (azimuth - soundDirection) % 360 }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Tovush qayerdan kelayotganini bilish uchun strelka ko`rsatayotgan tomonga qarang",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(25.dp))

            Image(
                painter = painterResource(id = R.drawable.arrow_img),
                contentDescription = "Sound direction arrow",
                modifier = Modifier
                    .size(300.dp)
                    .rotate(-arrowRotation)
                    .padding(20.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Sizga nisbatan tovush kelayotgan taraf",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "%.1f°".format(soundDirection),
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}