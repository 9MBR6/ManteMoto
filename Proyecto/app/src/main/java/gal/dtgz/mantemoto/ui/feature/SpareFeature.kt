package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SpareFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Spare Parts",
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 32.sp),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
    }

}