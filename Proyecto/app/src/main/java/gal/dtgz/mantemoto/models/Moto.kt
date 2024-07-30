package gal.dtgz.mantemoto.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "motos")
data class Moto(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var matricula: String,
    var marca: Int,
    var modelo: String,
    var km: String,
    var cilindrada: String,
    var numeroBastidor: String,
    var anoFabricacion: String,
    var distintivoAmbiental: Int,
    var ultimaITV: String,
    var fechaInicioSeguro: String,
    var entidadAseguradora: String
    //var recambios: List<Recambio>
) {

}
