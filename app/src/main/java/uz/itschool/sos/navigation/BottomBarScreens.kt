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
        title = "Home",
        icon = R.drawable.home_bn_icon,
        iconFocused = R.drawable.home_bn_icon_filled
    )
    data object Compass: BottomBarScreens(
        route = "compass",
        title = "Compass",
        icon = R.drawable.compass_bn_icon,
        iconFocused = R.drawable.compass_bn_icon_filled
    )
    data object TextSpeech: BottomBarScreens(
        route = "speech",
        title = "Speech",
        icon = R.drawable.speech_text_icon_notf,
        iconFocused = R.drawable.speech_text_icon
    )
    data object Settings: BottomBarScreens(
        route = "settings",
        title = "Settings",
        icon = R.drawable.settings_bn_icon,
        iconFocused = R.drawable.settings_bn_icon_filled
    )
}