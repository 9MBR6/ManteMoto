import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import gal.dtgz.pruebascompose.navegation.NavScreen

sealed class ItemsTopNav(
    val title: String,
    val ruta: String
) {

    object ItemSettings :
        ItemsTopNav("Settings", NavScreen.SettingsFeature.name)


}


