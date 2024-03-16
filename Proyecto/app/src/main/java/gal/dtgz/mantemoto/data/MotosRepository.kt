package gal.dtgz.mantemoto.data

import gal.dtgz.mantemoto.models.Moto
import kotlinx.coroutines.flow.Flow

interface MotosRepository {

    /**
     * Recuperar todos los elementos de la fuente de datos proporcionada.
     */
    fun getAllMotosStream(): Flow<List<Moto>>

    /**
     * Recuperar un elemento de la fuente de datos proporcionada que coincida con el [id].
     */
    fun getMotoStream(id: Int): Flow<Moto?>

    /**
     * Insertar elemento en la fuente de datos
     */
    suspend fun insertMoto(moto: Moto)

    /**
     * Eliminar elemento de la fuente de datos
     */
    suspend fun deleteMoto(moto: Moto)

    /**
     * Actualizar elemento en la fuente de datos.
     */
    suspend fun updateMoto(moto: Moto)


}