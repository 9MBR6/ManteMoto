package com.example.mantenimientomotosbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDSQL extends SQLiteOpenHelper {
    public BDSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS Motos " +
                "(Matricula TEXT PRIMARY KEY, Marca TEXT, Modelo TEXT, Cilindrada INTEGER, Anho_Fabricacion TEXT, CV REAL, ParMotor REAL )");

        db.execSQL("CREATE TABLE IF NOT EXISTS Recambios " +
                "(ID_Recambio INTEGER PRIMARY KEY AUTOINCREMENT, Matricula TEXT, Bujia TEXT, Aceite TEXT, Filtro_Aceite TEXT, Filtro_Aire TEXT,Liquido_Frenos TEXT," +
                "Pastillas_Delanteras TEXT,Pastillas_Traseras TEXT,Neumatico_Delantero TEXT, Neumatico_Trasero TEXT,  Bateria TEXT," +
                " FOREIGN KEY (Matricula) REFERENCES Motos(Matricula) " +
                "ON DELETE CASCADE ON UPDATE CASCADE)");

        db.execSQL("CREATE TABLE IF NOT EXISTS Mantenimientos " +
                "(ID_Mantenimiento INTEGER PRIMARY KEY AUTOINCREMENT, Matricula TEXT,Fecha TEXT, KMs INTEGER, Aceite TEXT, Filtro_Aceite TEXT, Filtro_Aire TEXT," +
                " Bujia TEXT, Pastillas_Delanteras TEXT, Pastillas_Traseras TEXT, Liquido_Frenos TEXT, Kit_Arrastre TEXT, Otros_Trabajos TEXT," +
                "FOREIGN KEY (Matricula) REFERENCES Motos(Matricula)" +
                "ON DELETE CASCADE ON UPDATE CASCADE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
