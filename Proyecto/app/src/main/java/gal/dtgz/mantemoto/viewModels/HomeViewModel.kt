package gal.dtgz.mantemoto.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gal.dtgz.mantemoto.data.MotoDAO
import gal.dtgz.mantemoto.models.Moto
import kotlinx.coroutines.launch

class HomeViewModel(private val motoDAO: MotoDAO) : ViewModel()  {

    //Variables que se utilizan en la vista Home


    //Metodos
     fun obtenerTodasLasMotos(): List<Moto> {
        var numeroMotos: List<Moto> = emptyList()
        viewModelScope.launch {
            numeroMotos = motoDAO.getAll()
        }
        return numeroMotos
    }

    fun numeroDeMotos(): Int {
        var numeroMotos = 0
        viewModelScope.launch {
          numeroMotos = motoDAO.getCount()
        }
        return numeroMotos
    }

}