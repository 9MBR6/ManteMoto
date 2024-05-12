package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import gal.dtgz.mantemoto.addMoto.AddMotoFeature
import gal.dtgz.mantemoto.addMoto.AddMotoViewModel
import gal.dtgz.mantemoto.data.Mantemoto
import gal.dtgz.mantemoto.data.MotoDAO

@Preview
@Composable
fun SpareFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Spare Parts"
        )
       var bd = Mantemoto.getDatabase(LocalContext.current)
        val viewModel = AddMotoViewModel(bd.motoDAO())
        AddMotoFeature(viewModel)
    }

}