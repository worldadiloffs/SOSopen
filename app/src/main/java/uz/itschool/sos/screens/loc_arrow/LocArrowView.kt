package uz.itschool.sos.screens.loc_arrow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.itschool.sos.R

@Composable
fun ArrowLoc(){
    Image(painter = painterResource(id = R.drawable.arrow_loc), contentDescription = "", modifier = Modifier.fillMaxWidth().padding(20.dp))
}