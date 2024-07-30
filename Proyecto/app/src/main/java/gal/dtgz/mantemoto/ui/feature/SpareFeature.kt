package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import gal.dtgz.mantemoto.viewModels.AddMotoViewModel
import gal.dtgz.mantemoto.data.Mantemoto
import gal.dtgz.pruebascompose.navegation.NavScreen

@Preview
@Composable
fun SpareFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Spare Parts"
        )
    }

}
