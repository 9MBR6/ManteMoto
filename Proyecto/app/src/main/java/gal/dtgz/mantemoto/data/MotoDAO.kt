package gal.dtgz.mantemoto.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import gal.dtgz.mantemoto.models.Moto
import kotlinx.coroutines.flow.Flow

@Dao
interface MotoDAO {

    @Query("SELECT * from motos ORDER BY km ASC")
    fun getAllMotos(): Flow<List<Moto>>
    @Query("SELECT * from motos WHERE id = :id")
    fun getMoto(id: Int): Flow<Moto>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(moto: Moto)
    @Update
    suspend fun update(moto: Moto)
    @Delete
    suspend fun delete(moto: Moto)


}