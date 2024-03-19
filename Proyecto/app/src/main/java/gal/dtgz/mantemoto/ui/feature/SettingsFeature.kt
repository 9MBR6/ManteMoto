package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gal.dtgz.mantemoto.R

@Composable
fun SettingsFeature() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly

        ) {
            Divider(
                color = MaterialTheme.colorScheme.primary,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )

            CopiaSeguridadCard()

            InformacionCard()
            Divider(
                color = MaterialTheme.colorScheme.primary,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
        }


    }
}

@Composable
fun InformacionCard() {
    Text(
        text = "Información",
        fontWeight = FontWeight.Bold,
        style = TextStyle(fontSize = 32.sp)
    )

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.size(width = 300.dp, height = 175.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.export),
                    contentDescription = "iconExport",
                    modifier = Modifier.padding(end = 6.dp)
                )
                Text(
                    text = "Preguntas frecuentes",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.export),
                    contentDescription = "iconExport",
                    modifier = Modifier.padding(end = 6.dp)
                )
                Text(
                    text = "Politica de privacidad",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.export),
                    contentDescription = "iconExport",
                    modifier = Modifier.padding(end = 6.dp)
                )
                Text(
                    text = "Terminos de uso",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.impor),
                    contentDescription = "iconImport",
                    modifier = Modifier.padding(end = 6.dp)
                )
                Text(
                    text = "Mas información",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}

@Composable
fun CopiaSeguridadCard() {
    Text(
        text = "Copia de seguridad",
        fontWeight = FontWeight.Bold,
        style = TextStyle(fontSize = 32.sp)
    )

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.size(width = 300.dp, height = 75.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.export),
                    contentDescription = "iconExport",
                    modifier = Modifier.padding(end = 6.dp)
                )
                Text(
                    text = "Exportar copia de seguridad",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.impor),
                    contentDescription = "iconImport",
                    modifier = Modifier.padding(end = 6.dp)
                )
                Text(
                    text = "Importar copia de seguridad",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}


@Preview
@Composable
fun SettingsFeaturePreview() {
    SettingsFeature()
}