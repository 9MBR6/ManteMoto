package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gal.dtgz.mantemoto.ui.feature.cards.CardInfoHistory

@Composable
fun HistoryFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "History",
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 32.sp),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(3) { index ->
                    CardInfoHistory()
                }

            }
        }
    }

}

@Preview
@Composable
fun HistoryFeaturePreview() {
    HomeFeature()
}