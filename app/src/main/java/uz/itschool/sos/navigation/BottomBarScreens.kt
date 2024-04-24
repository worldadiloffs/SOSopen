package uz.itschool.sos.navigation

import uz.itschool.sos.R


sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: Int,
    val iconFocused: Int
){
    data object Home: BottomBarScreens(
        route = "home",
        title = "Uy",
        icon = R.drawable.home_bn_icon,
        iconFocused = R.drawable.home_bn_icon_filled
    )
    data object Compass: BottomBarScreens(
        route = "compass",
        title = "Kompas",
        icon = R.drawable.compass_bn_icon,
        iconFocused = R.drawable.compass_bn_icon_filled
    )
    data object TextSpeech: BottomBarScreens(
        route = "speech",
        title = "Ovoz",
        icon = R.drawable.speech_text_icon_notf,
        iconFocused = R.drawable.speech_text_icon
    )
    data object Saved: BottomBarScreens(
        route = "saved",
        title = "Disk",
        icon = R.drawable.save_ic_notg,
        iconFocused = R.drawable.save_ic
    )
    data object Settings: BottomBarScreens(
        route = "settings",
        title = "Sozlamalar",
        icon = R.drawable.settings_bn_icon,
        iconFocused = R.drawable.settings_bn_icon_filled
    )
}