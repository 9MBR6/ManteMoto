package gal.dtgz.mantemoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import gal.dtgz.mantemoto.components.BarraSuperior
import gal.dtgz.mantemoto.ui.feature.BotonFlotante
import gal.dtgz.mantemoto.ui.theme.ManteMotoTheme
import gal.dtgz.pruebascompose.components.BarraNavegacion
import gal.dtgz.pruebascompose.navegation.NavNavegation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManteMotoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {BarraSuperior(navController = navController)},
        bottomBar = { BarraNavegacion(navController = navController) },
        floatingActionButton = { BotonFlotante(navController = navController) })
    { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            NavNavegation(navController)
        }
    }


}

@Preview
@Composable
fun PantallaPrincipalPreview() {
    PantallaPrincipal()
}