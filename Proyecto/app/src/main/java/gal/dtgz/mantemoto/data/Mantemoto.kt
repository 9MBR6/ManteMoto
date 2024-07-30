package gal.dtgz.mantemoto.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gal.dtgz.mantemoto.models.Moto

@Database(entities = [Moto::class], version = 2, exportSchema = false)
abstract class Mantemoto : RoomDatabase() {

    abstract fun motoDAO(): MotoDAO

    companion object {
        @Volatile
        private var Instance: Mantemoto? = null

        fun getDatabase(context: Context): Mantemoto {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, Mantemoto::class.java, "moto_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}