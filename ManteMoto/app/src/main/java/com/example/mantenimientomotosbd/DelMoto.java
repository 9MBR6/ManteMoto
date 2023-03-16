package com.example.mantenimientomotosbd;

import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.motoStatica;
import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.noExistenObjetos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DelMoto extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_moto);

            this.setTitle("Eliminar moto: " + motoStatica.getMatricula());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.advertencia_delete);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //queda realizar alguna validaciones
    public void eliminarMoto(View v){
        BDSQL admin = new BDSQL(this, "MantenimientoMotos", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        String pragma = "PRAGMA foreign_keys = ON;";
        db.execSQL(pragma);

        String delMoto = "DELETE FROM Motos WHERE Matricula like '"+motoStatica.getMatricula() +"'";
        db.execSQL(delMoto);

        db.close();

        Toast.makeText(this, "Moto eliminada", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}