package gal.dtgz.mantemoto.ui.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import gal.dtgz.mantemoto.data.Mantemoto
import gal.dtgz.mantemoto.viewModels.AddMotoViewModel
import gal.dtgz.pruebascompose.navegation.NavScreen


/**
 * Datos que recogeremos de una moto nueva
 *
 * **/

@Composable
fun AddMotoFeature() {
    var bd = Mantemoto.getDatabase(LocalContext.current)
    val viewModel = AddMotoViewModel(bd.motoDAO())

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Add Moto"
        )
        RegisterMatricula(viewModel)
        RegisterMarca(viewModel)
        RegisterModelo(viewModel)
        RegisterKM(viewModel)
        RegisterBoton(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterMatricula(addMotoViewModel: AddMotoViewModel) {
    val matricula:String by addMotoViewModel.matricula.observeAsState(initial = "")
    TextField(
        value = matricula,
        onValueChange = { addMotoViewModel.actualizarMatricula(it)},
        label = { Text(text = "Matricula") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterMarca(addMotoViewModel: AddMotoViewModel) {
    val marca:String by addMotoViewModel.marca.observeAsState(initial = "")
    TextField(
        value = marca,
        onValueChange = {addMotoViewModel.actualizarMarca(it)},
        label = { Text(text = "Marca") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterModelo(addMotoViewModel: AddMotoViewModel) {
    val modelo:String by addMotoViewModel.modelo.observeAsState(initial = "")
    TextField(value = modelo, onValueChange = { addMotoViewModel.actualizarModelo(it) }, label = { Text(text = "Modelo") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterKM(addMotoViewModel: AddMotoViewModel) {
    val km:String by addMotoViewModel.km.observeAsState(initial = "")
    TextField(
        value = km,
        onValueChange = { addMotoViewModel.actualizarKm(it) },
        label = { Text(text = "Kilometros") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun RegisterBoton(addMotoViewModel: AddMotoViewModel) {
    Button(onClick = {
        addMotoViewModel.crearMoto()
    }) {
        Text(text = "Registrar moto")
    }
}


@Preview
@Composable
fun AddMotoFeaturePreview() {
    AddMotoFeature()
}

