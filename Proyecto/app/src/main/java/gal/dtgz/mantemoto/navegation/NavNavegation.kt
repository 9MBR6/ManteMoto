package gal.dtgz.pruebascompose.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import gal.dtgz.mantemoto.ui.feature.HistoryFeature
import gal.dtgz.mantemoto.ui.feature.HomeFeature
import gal.dtgz.mantemoto.ui.feature.SettingsFeature
import gal.dtgz.mantemoto.ui.feature.SpareFeature

@Composable
fun NavNavegation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavScreen.HomeScreen.name) {
        composable(NavScreen.HomeScreen.name){
            HomeFeature()
        }
        composable(NavScreen.SpareScreen.name){
            SpareFeature()
        }
        composable(NavScreen.HistoryScreen.name){
            HistoryFeature()
        }
        composable(NavScreen.SettingsFeature.name){
            SettingsFeature()
        }
    }
}
