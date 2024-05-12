package gal.dtgz.mantemoto.addMoto

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gal.dtgz.mantemoto.data.MotoDAO
import gal.dtgz.mantemoto.models.Moto
import kotlinx.coroutines.launch

class AddMotoViewModel(private val motoDAO: MotoDAO) : ViewModel()  {

    private var _matricula = MutableLiveData<String>()
    var matricula: LiveData<String> = _matricula

    private var _marca = MutableLiveData<String>()
    var marca: LiveData<String> = _marca

    private var _modelo = MutableLiveData<String>()
    var modelo: LiveData<String> = _modelo

    private var _km = MutableLiveData<String>()
    var km: LiveData<String> = _km


    fun actualizarMatricula(matricula:String){
        _matricula.value = matricula
    }

    fun actualizarMarca(marca:String){
        _marca.value = marca
    }

    fun actualizarModelo(modelo:String){
        _modelo.value = modelo
    }

    fun actualizarKm(km:String){
        _km.value = km
    }

    fun crearMoto() {
        // Obteniendo los valores actuales de LiveData
        val matricula: String? = _matricula.value
        val marcaString: String? = _marca.value
        val modelo: String? = _modelo.value
        val kmString: String? = _km.value

        // Manejando el caso en el que los valores pueden ser nulos
        val matriculaNonNull = matricula ?: ""
        val modeloNonNull = modelo ?: ""
        val marcaNonNull: Int = marcaString?.toIntOrNull() ?: 0
        val kmNonNull: Int = kmString?.toIntOrNull() ?: 0

        // Creando la moto con los valores obtenidos
        val nuevaMoto = Moto(0, matriculaNonNull, marcaNonNull, modeloNonNull, kmNonNull)
        insertarMoto(nuevaMoto)
    }



    // Función para insertar una nueva moto en la base de datos
    fun insertarMoto(moto: Moto) {
        viewModelScope.launch {
            motoDAO.insert(moto)
        }
    }

    // Función para obtener todas las motos de la base de datos
    suspend fun obtenerTodasLasMotos(): List<Moto> {
        return motoDAO.getAll()
    }

    // Otras funciones para actualizar, eliminar, etc. TODO
}