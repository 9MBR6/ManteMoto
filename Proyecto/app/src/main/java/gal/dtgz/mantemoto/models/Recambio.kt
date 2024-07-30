package gal.dtgz.mantemoto.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recambios")
data class Recambio (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var nombre: String,
    var referencia: String
    ){
}
