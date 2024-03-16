package gal.dtgz.mantemoto.ui.pruebas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gal.dtgz.mantemoto.R

@Preview
@Composable
fun CardInfoMoto() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 300.dp, height = 265.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.imagen_moto),
                contentDescription = "moto fulera de fran"
            )
            Column (modifier = Modifier.padding(start = 4.dp)){
                Text(
                    text = "MV Augusta Brutale 800",fontWeight = FontWeight.Bold,style = TextStyle(fontSize = 16.sp)
                )
                Text(
                    text = "KZK 1007"
                )
                Text(
                    text = "22.324 km"
                )
            }

        }
    }

}