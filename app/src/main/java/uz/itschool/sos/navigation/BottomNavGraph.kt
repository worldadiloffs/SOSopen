package uz.itschool.sos.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.itschool.sos.screens.settings.SettingsView
import uz.itschool.sos.screens.compass.CompassView
import uz.itschool.sos.screens.home.HomeView
import uz.itschool.sos.screens.textspeech.TextToSpeech

@Composable
fun BottomNavGraph(navController: NavController, bottomNavController: NavHostController){

    NavHost(navController = bottomNavController, startDestination = BottomBarScreens.Home.route, modifier = Modifier.fillMaxSize()){
        composable(BottomBarScreens.Home.route){
            HomeView(navController= navController)
        }
        composable(BottomBarScreens.Compass.route){
            CompassView(navController)
        }
        composable(BottomBarScreens.TextSpeech.route){
            TextToSpeech(navController)
        }
        composable(BottomBarScreens.Settings.route){
            SettingsView(navController)
        }
    }
}