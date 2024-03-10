package gal.dtgz.mantemoto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gal.dtgz.mantemoto.view.garaje.MainScreen
import gal.dtgz.mantemoto.view.splashScreen.SplashScreen
import gal.dtgz.mantemoto.view.tutorial.TutorialScreen1
import gal.dtgz.mantemoto.view.tutorial.TutorialScreen2
import gal.dtgz.mantemoto.view.tutorial.TutorialScreen3

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }
        composable(AppScreens.TutorialScreen1.route) {
            TutorialScreen1(navController)
        }
        composable(AppScreens.TutorialScreen2.route) {
            TutorialScreen2(navController)
        }
        composable(AppScreens.TutorialScreen3.route) {
            TutorialScreen3(navController)
        }
    }
}