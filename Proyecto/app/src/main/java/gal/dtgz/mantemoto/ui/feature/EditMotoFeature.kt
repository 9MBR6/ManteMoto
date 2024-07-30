package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditMotoFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "MODIFICAR MOTO"
        )
    }
}

@Preview
@Composable
fun EditMotoFeaturePreview() {
    EditMotoFeature()
}