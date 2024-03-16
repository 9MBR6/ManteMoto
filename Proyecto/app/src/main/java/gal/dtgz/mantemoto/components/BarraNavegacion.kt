package gal.dtgz.pruebascompose.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import gal.dtgz.pruebascompose.models.ItemsBottomNav
import gal.dtgz.pruebascompose.navegation.currentRoute

@Composable
fun BarraNavegacion(navController: NavHostController) {

    val menuItems = listOf(
        ItemsBottomNav.ItemHome,
        ItemsBottomNav.ItemSpare,
        ItemsBottomNav.ItemHistory
    )
    BottomAppBar {
        NavigationBar {
            menuItems.forEach { item ->
                val selected = currentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = selected,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(text = item.title)
                    })
            }
        }
    }

}