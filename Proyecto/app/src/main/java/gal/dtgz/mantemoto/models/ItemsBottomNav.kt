package gal.dtgz.pruebascompose.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import gal.dtgz.pruebascompose.navegation.NavScreen

sealed class ItemsBottomNav(
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {

    object ItemHome :
        ItemsBottomNav(Icons.Default.Home, "Home", NavScreen.HomeScreen.name)

    object ItemSpare :
        ItemsBottomNav(Icons.Default.AddToPhotos, "Spare", NavScreen.SpareScreen.name)

    object ItemHistory :
        ItemsBottomNav(Icons.Default.Article, "History", NavScreen.HistoryScreen.name)

}

