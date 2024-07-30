package gal.dtgz.mantemoto.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gal.dtgz.mantemoto.data.MotoDAO
import gal.dtgz.mantemoto.models.Moto
import kotlinx.coroutines.launch

class AddMotoViewModel(private val motoDAO: MotoDAO) : ViewModel() {

    private var _matricula = MutableLiveData<String>()
    var matricula: LiveData<String> = _matricula

    private var _marca = MutableLiveData<String>()
    var marca: LiveData<String> = _marca

    private var _modelo = MutableLiveData<String>()
    var modelo: LiveData<String> = _modelo

    private var _km = MutableLiveData<String>()
    var km: LiveData<String> = _km

    private var _cilindrada = MutableLiveData<String>()
    var cilindrada: LiveData<String> = _cilindrada

    private var _numeroBastidor = MutableLiveData<String>()
    var numeroBastidor: LiveData<String> = _numeroBastidor

    private var _anoFabricacion = MutableLiveData<String>()
    var anoFabricacion: LiveData<String> = _anoFabricacion

    private var _distintivoAmbiental = MutableLiveData<String>()
    var distintivoAmbiental: LiveData<String> = _distintivoAmbiental

    private var _ultimaITV = MutableLiveData<String>()
    var ultimaITV: LiveData<String> = _ultimaITV

    private var _fechaInicioSeguro = MutableLiveData<String>()
    var fechaInicioSeguro: LiveData<String> = _fechaInicioSeguro

    private var _entidadAseguradora = MutableLiveData<String>()
    var entidadAseguradora: LiveData<String> = _entidadAseguradora


    fun actualizarMatricula(matricula: String) {
        _matricula.value = matricula
    }

    fun actualizarMarca(marca: String) {
        _marca.value = marca
    }

    fun actualizarModelo(modelo: String) {
        _modelo.value = modelo
    }

    fun actualizarKm(km: String) {
        _km.value = km
    }

    fun actualizarcilindrada(cilindrada: String) {
        _cilindrada.value = cilindrada
    }

    fun actualizarnumeroBastidor(numeroBastidor: String) {
        _numeroBastidor.value = numeroBastidor
    }

    fun actualizaranoFabricacion(anoFabricacion: String) {
        _anoFabricacion.value = anoFabricacion
    }

    fun actualizardistintivoAmbiental(distintivoAmbiental: String) {
        _distintivoAmbiental.value = distintivoAmbiental
    }

    fun actualizarultimaITV(ultimaITV: String) {
        _ultimaITV.value = ultimaITV
    }

    fun actualizarfechaInicioSeguro(fechaInicioSeguro: String) {
        _fechaInicioSeguro.value = fechaInicioSeguro
    }

    fun actualizarentidadAseguradora(entidadAseguradora: String) {
        _entidadAseguradora.value = entidadAseguradora
    }

    fun crearMoto() {
        // Obteniendo los valores actuales de LiveData
        val matricula: String? = _matricula.value
        val marcaString: String? = _marca.value
        val modelo: String? = _modelo.value
        val kmString: String? = _km.value

        val cilindrada: String? = _cilindrada.value
        val numeroBastidor: String? = _numeroBastidor.value
        val anoFabricacion: String? = _anoFabricacion.value
        val distintivoAmbiental: String? = _distintivoAmbiental.value
        val ultimaITV: String? = _ultimaITV.value
        val fechaInicioSeguro: String? = _fechaInicioSeguro.value
        val entidadAseguradora: String? = _entidadAseguradora.value


        // Manejando el caso en el que los valores pueden ser nulos
        val matriculaNonNull = matricula ?: ""
        val modeloNonNull = modelo ?: ""
        val marcaNonNull: Int = marcaString?.toIntOrNull() ?: 0
        val kmNonNull = kmString ?: ""

        val cilindradaNonNull = cilindrada ?: ""
        val numeroBastidorNonNull = numeroBastidor ?: ""
        val anoFabricacionNonNull = anoFabricacion ?: ""
        val distintivoAmbientalNonNull : Int = distintivoAmbiental?.toIntOrNull() ?: 0
        val ultimaITVNonNull = ultimaITV ?: ""
        val fechaInicioSeguroNonNull = fechaInicioSeguro ?: ""
        val entidadAseguradoraNonNull = entidadAseguradora ?: ""


        // Creando la moto con los valores obtenidos
        val nuevaMoto = Moto(
            0,
            matriculaNonNull,
            marcaNonNull,
            modeloNonNull,
            kmNonNull,
            cilindradaNonNull,
            numeroBastidorNonNull,
            anoFabricacionNonNull,
            distintivoAmbientalNonNull,
            ultimaITVNonNull,
            fechaInicioSeguroNonNull,
            entidadAseguradoraNonNull
        )
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