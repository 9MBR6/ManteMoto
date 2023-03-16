package com.example.mantenimientomotosbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText matricula, marca, modelo, cilindrada, anhoFabricacion, cv, parMotor, bujias, aceite,
            bateria, filtroAceite, filtroAire, liquidoFrenos, frenosDelanteros, frenosTraseros, neumaticoDelantero, neumaticoTrasero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Registro");
        iniOnCreate();

    }

    public void iniOnCreate() {
        //motos
        matricula = findViewById(R.id.campoMatricula);
        marca = findViewById(R.id.campoMarca);
        modelo = findViewById(R.id.campoModelo);
        cilindrada = findViewById(R.id.campoCilindrada);
        anhoFabricacion = findViewById(R.id.campoFabricacion);
        cv = findViewById(R.id.campoCv);
        parMotor = findViewById(R.id.campoPar);
        //recambios
        bujias = findViewById(R.id.campoBujias);
        aceite = findViewById(R.id.campoAceite);
        bateria = findViewById(R.id.campoBateria);
        filtroAceite = findViewById(R.id.campoFiltroAceite);
        filtroAire = findViewById(R.id.campoFiltroAire);
        liquidoFrenos = findViewById(R.id.campoLiquidoFrenos);
        frenosDelanteros = findViewById(R.id.campoPastillasDelanteras);
        frenosTraseros = findViewById(R.id.campoPastillasTraseras);
        neumaticoDelantero = findViewById(R.id.campoNeumaticoDelantero);
        neumaticoTrasero = findViewById(R.id.campoNeumaticoTrasero);
    }

    public void btnRegistro(View v) {
        if (
                !matricula.getText().toString().equals("") &&
                        !marca.getText().toString().equals("") &&
                        !modelo.getText().toString().equals("") &&
                        !anhoFabricacion.getText().toString().equals("") &&
                        !cv.getText().toString().equals("") &&
                        !cilindrada.getText().toString().equals("") &&
                        !parMotor.getText().toString().equals("") &&
                        !bujias.getText().toString().equals("") &&
                        !aceite.getText().toString().equals("") &&
                        !filtroAceite.getText().toString().equals("") &&
                        !filtroAire.getText().toString().equals("") &&
                        !liquidoFrenos.getText().toString().equals("") &&
                        !frenosDelanteros.getText().toString().equals("") &&
                        !frenosTraseros.getText().toString().equals("") &&
                        !neumaticoTrasero.getText().toString().equals("") &&
                        !neumaticoDelantero.getText().toString().equals("") &&
                        !bateria.getText().toString().equals("")
        ) {

            System.out.println("accaba de entrar no if");
            BDSQL admindb = new BDSQL(this, "MantenimientoMotos", null, 1);
            SQLiteDatabase db = admindb.getWritableDatabase();
            ContentValues registroMoto = new ContentValues();
            ContentValues registroRecambios = new ContentValues();

            //tabla Motos, base de datos MantenimientosMotos
            registroMoto.put("Matricula", matricula.getText().toString());
            registroMoto.put("Marca", marca.getText().toString());
            registroMoto.put("Modelo", modelo.getText().toString());
            registroMoto.put("Cilindrada", Integer.parseInt(cilindrada.getText().toString()));
            registroMoto.put("Anho_Fabricacion", Integer.parseInt(anhoFabricacion.getText().toString()));
            registroMoto.put("CV", Float.parseFloat(cv.getText().toString()));
            registroMoto.put("ParMotor", Float.parseFloat(parMotor.getText().toString()));

            //tabla recambios, base de datos MantenimientosMotos
            registroRecambios.put("Matricula", matricula.getText().toString());
            registroRecambios.put("Bujia", bujias.getText().toString());
            registroRecambios.put("Aceite", aceite.getText().toString());
            registroRecambios.put("Filtro_Aceite", filtroAceite.getText().toString());
            registroRecambios.put("Filtro_Aire", filtroAire.getText().toString());
            registroRecambios.put("Liquido_Frenos", liquidoFrenos.getText().toString());
            registroRecambios.put("Pastillas_Delanteras", frenosDelanteros.getText().toString());
            registroRecambios.put("Pastillas_Traseras", frenosTraseros.getText().toString());
            registroRecambios.put("Neumatico_Delantero", neumaticoDelantero.getText().toString());
            registroRecambios.put("Neumatico_Trasero", neumaticoTrasero.getText().toString());
            registroRecambios.put("Bateria", bateria.getText().toString());

            //faltan por poner datos

            db.insert("Motos", null, registroMoto);
            db.insert("Recambios", null, registroRecambios);

            db.close();
            Toast.makeText(this, "El registro se completo con exito", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            System.out.println("acaba de entrar no else");
            Toast.makeText(this, "Revisa bien los campos", Toast.LENGTH_SHORT).show();
        }


    }

}