package gal.dtgz.mantemoto.view.garaje

import android.annotation.SuppressLint

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import gal.dtgz.mantemoto.R
import gal.dtgz.mantemoto.navigation.AppScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(bottomBar = { MyBottomNavigation()}) {
    }
}

@Composable
fun MyBottomNavigation() {

    NavigationBar( windowInsets = NavigationBarDefaults.windowInsets ){
        NavigationBarItem(selected = false , onClick = { /*TODO*/ }, icon = { Icon(
            painter = painterResource(id = R.drawable.garaje),
            contentDescription = "a"
        )})
        NavigationBarItem(selected = false , onClick = { /*TODO*/ }, icon = { Icon(
            painter = painterResource(id = R.drawable.filtro_aceite),
            contentDescription = "a"
        )})
        NavigationBarItem(selected = false , onClick = { /*TODO*/ }, icon = { Icon(
            painter = painterResource(id = R.drawable.mantenimiento),
            contentDescription = "a"
        )})
    }

}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}