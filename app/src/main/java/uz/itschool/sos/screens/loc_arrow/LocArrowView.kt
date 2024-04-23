package uz.itschool.sos.screens.loc_arrow

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import uz.itschool.sos.R

@Composable
fun ArrowLoc(){
    Image(painter = painterResource(id = R.drawable.arrow_loc), contentDescription = "")
}