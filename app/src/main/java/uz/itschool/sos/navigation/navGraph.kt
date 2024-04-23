package uz.itschool.sos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.itschool.sos.screens.login.LoginView
import uz.itschool.sos.screens.main.MainView
import uz.itschool.sos.screens.registration.RegistrationView
import uz.itschool.sos.screens.splash.SplashView

@Composable
fun SetNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = ScreenType.Splash.route) {
        composable(ScreenType.Splash.route){
            SplashView(navController)
        }
        composable(ScreenType.Registration.route){
            RegistrationView(navController)
        }
        composable(ScreenType.Login.route){
            LoginView(navController)
        }
        composable(ScreenType.Main.route){
            MainView(navController = navController)
        }
    }
}