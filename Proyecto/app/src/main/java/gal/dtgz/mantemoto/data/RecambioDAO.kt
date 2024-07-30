package gal.dtgz.mantemoto.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import gal.dtgz.mantemoto.models.Moto
import gal.dtgz.mantemoto.models.Recambio

@Dao
interface RecambioDAO {

    @Query("SELECT * from recambios ORDER BY id DESC")
    suspend fun getAll(): List<Recambio>
    @Query("SELECT * from recambios WHERE id = :id")
    suspend fun getById(id: Int): Recambio
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recambio: Recambio)
    @Update
    suspend fun update(recambio: Recambio)
    @Delete
    suspend fun delete(recambio: Recambio)
    @Query("SELECT COUNT(*) FROM recambios")
    suspend fun getCount(): Int
}