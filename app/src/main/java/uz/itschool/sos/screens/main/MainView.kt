package uz.itschool.sos.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.itschool.sos.navigation.BottomNavGraph

@Composable
fun MainView(navController: NavHostController) {
    val bottomNavController = rememberNavController()
    Column {
        Box(modifier = Modifier.weight(1f)) {
            BottomNavGraph(navController=navController, bottomNavController=bottomNavController) }
        BottomBar(bottomNavController = bottomNavController)
    }
}