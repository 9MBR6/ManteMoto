package gal.dtgz.mantemoto.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gal.dtgz.mantemoto.data.MotoDAO
import gal.dtgz.mantemoto.models.Moto
import kotlinx.coroutines.launch

class HomeViewModel(private val motoDAO: MotoDAO) : ViewModel()  {

    private val _motos = MutableLiveData<List<Moto>>()
    val motos: LiveData<List<Moto>> = _motos

    //Metodos
    /*
     fun obtenerTodasLasMotos(): List<Moto> {
        var numeroMotos: List<Moto> = emptyList()
        viewModelScope.launch {
            numeroMotos = motoDAO.getAll()
            println("LOG HomeViewModel: MOTOS ----> "+numeroMotos)
        }
        return numeroMotos
    }*/

    fun obtenerTodasLasMotos() {
        viewModelScope.launch {
            _motos.value = motoDAO.getAll()
        }
    }

    fun numeroDeMotos(): Int {
        var numeroMotos = 0
        viewModelScope.launch {
          numeroMotos = motoDAO.getCount()
        }
        return numeroMotos
    }

}