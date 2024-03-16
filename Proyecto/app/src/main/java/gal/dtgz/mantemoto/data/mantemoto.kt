package gal.dtgz.mantemoto.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gal.dtgz.mantemoto.models.Moto

@Database(entities = [Moto::class], version = 1, exportSchema = false)
abstract class mantemoto : RoomDatabase() {

    abstract fun motoDAO(): MotoDAO

    companion object {
        @Volatile
        private var Instance: mantemoto? = null

        fun getDatabase(context: Context): mantemoto {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, mantemoto::class.java, "moto_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
