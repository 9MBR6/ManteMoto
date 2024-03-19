package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gal.dtgz.mantemoto.ui.feature.cards.CardInfoMoto

@Composable
fun HomeFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(20) { index ->
                    CardInfoMoto()
                }

            }
        }
    }
}

@Composable
fun BotonFlotante() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }

}

@Preview
@Composable
fun HomeFeaturePreview() {
    HomeFeature()
}