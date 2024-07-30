package gal.dtgz.mantemoto.navegation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import gal.dtgz.pruebascompose.navegation.NavScreen

@Composable
fun BotonFlotante(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    FloatingActionButton(
        onClick = {
            when (currentRoute) {
                "HomeScreen" -> navController.navigate(NavScreen.AddMotoScreen.name)
                "HistoryScreen" -> navController.navigate(NavScreen.AddMaintenanceFeature.name)
                "SpareScreen" -> navController.navigate(NavScreen.AddSpareFeature.name)
                else -> navController.navigate(NavScreen.HomeScreen.name)
            }
        },
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }

}