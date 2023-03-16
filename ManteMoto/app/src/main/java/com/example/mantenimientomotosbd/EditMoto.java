package com.example.mantenimientomotosbd;

import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.motoStatica;
import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.noExistenObjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditMoto extends AppCompatActivity {
    EditText matricula, marca, modelo, cilindrada, anhoFabricacion, cv, parMotor, bujias, aceite,
            bateria, filtroAceite, filtroAire, liquidoFrenos, frenosDelanteros, frenosTraseros, neumaticoDelantero, neumaticoTrasero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_moto);

            this.setTitle("Editar moto: " + motoStatica.getMatricula());
            iniOnCreate();
            cargarDatos();

    }

    //metodo para cargar todos los elementos en el onCreate
    public void iniOnCreate() {
        //motos
        matricula = findViewById(R.id.editMatricula);
        marca = findViewById(R.id.editMarca);
        modelo = findViewById(R.id.editModelo);
        cilindrada = findViewById(R.id.editCilindrada);
        anhoFabricacion = findViewById(R.id.editFabricacion);
        cv = findViewById(R.id.editCv);
        parMotor = findViewById(R.id.editPar);

        //recambios
        bujias = findViewById(R.id.editBujias);
        aceite = findViewById(R.id.editAceite);
        bateria = findViewById(R.id.editBateria);
        filtroAceite = findViewById(R.id.editFiltroAceite);
        filtroAire = findViewById(R.id.editFiltroAire);
        liquidoFrenos = findViewById(R.id.editLiquidoFrenos);
        frenosDelanteros = findViewById(R.id.editPastillasDelanteras);
        frenosTraseros = findViewById(R.id.editPastillasTraseras);
        neumaticoDelantero = findViewById(R.id.editNeumaticoDelantero);
        neumaticoTrasero = findViewById(R.id.editNeumaticoTrasero);
    }

    //metodo para cargar todos los datos de la bd en los campos
    public void cargarDatos() {
        BDSQL admin = new BDSQL(this, "MantenimientoMotos", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        //moto
        //Matricula  , Marca , Modelo , Cilindrada , Anho_Fabricacion , CV , ParMotor
        Cursor c = db.rawQuery("Select Matricula, Marca, Modelo, Cilindrada, Anho_Fabricacion, CV, ParMotor FROM Motos " +
                "where Matricula like '" + motoStatica.getMatricula() + "'", null);
        if (c.moveToNext()) {
            matricula.setText(c.getString(0));
            marca.setText(c.getString(1));
            modelo.setText(c.getString(2));
            cilindrada.setText(c.getString(3));
            anhoFabricacion.setText(c.getString(4));
            cv.setText(c.getString(5));
            parMotor.setText(c.getString(6));
        }
        db.close();

        SQLiteDatabase db2 = admin.getReadableDatabase();
        //mantenimientos
        Cursor cursor = db2.rawQuery("Select Bujia, Aceite, Bateria, Filtro_Aceite, Filtro_Aire, Liquido_Frenos" +
                ", Pastillas_Delanteras,Pastillas_Traseras, Neumatico_Delantero, Neumatico_Trasero FROM Recambios " +
                "where Matricula like '" + motoStatica.getMatricula() + "'", null);
        if (cursor.moveToNext()) {
            bujias.setText(cursor.getString(0));
            aceite.setText(cursor.getString(1));
            bateria.setText(cursor.getString(2));
            filtroAceite.setText(cursor.getString(3));
            filtroAire.setText(cursor.getString(4));
            liquidoFrenos.setText(cursor.getString(5));
            frenosDelanteros.setText(cursor.getString(6));
            frenosTraseros.setText(cursor.getString(7));
            neumaticoDelantero.setText(cursor.getString(8));
            neumaticoTrasero.setText(cursor.getString(9));
        }
        db2.close();

    }

    //FALTA VALIDAR

    /**
     *
     */
    public void btnMod(View v) {

        //si existe algun campo en blanco que no se ejecute el botón y obligue a revisar y a modificar el los datos.
        //con esto evitamos un problema muy grave en la bd.

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


            BDSQL admin = new BDSQL(this, "MantenimientoMotos", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            String pragma = "PRAGMA foreign_keys = ON;";
            db.execSQL(pragma);

            ContentValues valores = new ContentValues();
            ContentValues valores2 = new ContentValues();

            try {
                valores.put("Matricula", matricula.getText().toString());
                valores.put("Marca", marca.getText().toString());
                valores.put("Modelo", modelo.getText().toString());
                valores.put("Cilindrada", cilindrada.getText().toString());
                valores.put("Anho_Fabricacion", anhoFabricacion.getText().toString());
                valores.put("CV", cv.getText().toString());
                valores.put("ParMotor", parMotor.getText().toString());

                valores2.put("Bujia", bujias.getText().toString());
                valores2.put("Aceite", aceite.getText().toString());
                valores2.put("Bateria", bateria.getText().toString());
                valores2.put("Filtro_Aceite", filtroAceite.getText().toString());
                valores2.put("Filtro_Aire", filtroAire.getText().toString());
                valores2.put("Liquido_Frenos", liquidoFrenos.getText().toString());
                valores2.put("Pastillas_Delanteras", frenosDelanteros.getText().toString());
                valores2.put("Pastillas_Traseras", frenosTraseros.getText().toString());
                valores2.put("Neumatico_Delantero", neumaticoDelantero.getText().toString());
                valores2.put("Neumatico_Trasero", neumaticoTrasero.getText().toString());

                db.update("Motos", valores, "Matricula like ?", new String[]{motoStatica.getMatricula()});
                db.update("Recambios", valores2, "Matricula like ?", new String[]{motoStatica.getMatricula()});

                Toast.makeText(this, "Datos modificados", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } catch (SQLiteConstraintException w) {
                Toast.makeText(this, "Matrícula ya en uso", Toast.LENGTH_SHORT).show();
            }

            db.close();

        } else {
            Toast.makeText(this, "Revisa los campos", Toast.LENGTH_SHORT).show();
        }


    }
}