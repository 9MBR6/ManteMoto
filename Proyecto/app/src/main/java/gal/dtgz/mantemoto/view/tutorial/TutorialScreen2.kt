package gal.dtgz.mantemoto.view.tutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import gal.dtgz.mantemoto.R
import gal.dtgz.mantemoto.navigation.AppScreens

@Composable
fun TutorialScreen2(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "TUTORIAL 2")
        Button(onClick = { navController.navigate(AppScreens.TutorialScreen3.route)}) {
            Text(text = stringResource(id = R.string.Btn_Continuar))
        }
    }
}

@Preview
@Composable
fun TutorialScreen2Preview() {
    val navController = rememberNavController()
    TutorialScreen2(navController)
}