package gal.dtgz.mantemoto.ui.feature


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AddSpareFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "ADD SPARE"
        )
    }
}

@Preview
@Composable
fun AddSpareFeaturePreview() {
    AddMaintenanceFeature()
}
