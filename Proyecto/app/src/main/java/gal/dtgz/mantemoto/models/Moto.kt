package gal.dtgz.mantemoto.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "motos")
data class Moto(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var matricula: String,
    var marca: Int,
    var modelo: String,
    var km: Int
) {

}
