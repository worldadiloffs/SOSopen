package uz.itschool.sos.navigation

sealed class ScreenType(val route: String) {
    data object Splash: ScreenType("splash")
    data object Main: ScreenType("main")
    data object Registration: ScreenType("registration")
    data object Login: ScreenType("login")
    data object Home: ScreenType("home")
    data object Compass: ScreenType("compass")
    data object Settings: ScreenType("settings")

    data object IntroPage : ScreenType("IntroPage")
    data object HomePage : ScreenType("HomePage")
    data object SpeechToTextPage : ScreenType("SpeechToTextPage")
    data object TextToSpeechPage : ScreenType("TextToSpeechPage")
    data object FileListPage : ScreenType("FileListPage")
}