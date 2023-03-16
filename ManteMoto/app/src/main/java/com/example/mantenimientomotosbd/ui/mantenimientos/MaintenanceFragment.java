package com.example.mantenimientomotosbd.ui.mantenimientos;

import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.motoStatica;
import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.noExistenObjetos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mantenimientomotosbd.BDSQL;
import com.example.mantenimientomotosbd.databinding.FragmentNotificationsBinding;

public class MaintenanceFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    View vistaMantenimientos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vistaMantenimientos = root;
        //cambiar titulo por Mantenimientos.
        Button btnAddMantenimiento = binding.btnAddMant;
        TextView textEjemplo = binding.textoPrueba;
        EditText valorFecha = binding.etDate;
        EditText valorKm = binding.etKm;
        Switch valorAceite = binding.swAceite;
        Switch valorFiltroAceite = binding.swFiltroAceite;
        Switch valorFiltroAire = binding.swFiltroAire;
        Switch valorBujia = binding.swBujia;
        Switch valorPastillasDelanteras = binding.swPastillasDelanteras;
        Switch valorPastillasTraseras = binding.swPastillasTraseras;
        Switch valorLiquidoFrenos = binding.swLiquidoFrenos;
        Switch valorKitArrastre = binding.swKitArrastre;
        EditText valorComentarios = binding.etOtrosTrabajos;


        btnAddMantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(noExistenObjetos == false) {
                    if (!valorFecha.getText().toString().equals("") && !valorKm.getText().toString().equals("")) {

                        BDSQL admindb = new BDSQL(vistaMantenimientos.getContext(), "MantenimientoMotos", null, 1);
                        SQLiteDatabase db = admindb.getWritableDatabase();
                        ContentValues registroMantenimientos = new ContentValues();

                        registroMantenimientos.put("Matricula", motoStatica.getMatricula());
                        registroMantenimientos.put("Fecha", valorFecha.getText().toString());
                        registroMantenimientos.put("Kms", Integer.parseInt(valorKm.getText().toString()));
                        registroMantenimientos.put("Aceite", convertidorSwitch(valorAceite));
                        registroMantenimientos.put("Filtro_Aceite", convertidorSwitch(valorFiltroAceite));
                        registroMantenimientos.put("Filtro_Aire", convertidorSwitch(valorFiltroAire));
                        registroMantenimientos.put("Bujia", convertidorSwitch(valorBujia));
                        registroMantenimientos.put("Pastillas_Delanteras", convertidorSwitch(valorPastillasDelanteras));
                        registroMantenimientos.put("Pastillas_Traseras", convertidorSwitch(valorPastillasTraseras));
                        registroMantenimientos.put("Liquido_Frenos", convertidorSwitch(valorLiquidoFrenos));
                        registroMantenimientos.put("Kit_Arrastre", convertidorSwitch(valorKitArrastre));
                        registroMantenimientos.put("Otros_Trabajos", valorComentarios.getText().toString());

                        db.insert("Mantenimientos", null, registroMantenimientos);
                        db.close();

                        Toast.makeText(vistaMantenimientos.getContext(), "El registro se completo con exito", Toast.LENGTH_SHORT).show();

                        //resetear todos los datos
                        valorFecha.setText("");
                        valorKm.setText("");
                        valorAceite.setChecked(false);
                        valorFiltroAceite.setChecked(false);
                        valorFiltroAire.setChecked(false);
                        valorBujia.setChecked(false);
                        valorPastillasDelanteras.setChecked(false);
                        valorPastillasTraseras.setChecked(false);
                        valorLiquidoFrenos.setChecked(false);
                        valorKitArrastre.setChecked(false);
                        valorComentarios.setText("");

                        Toast.makeText(vistaMantenimientos.getContext(), "Mantenimiento Registrado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(vistaMantenimientos.getContext(), "Revisa bien los campos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(vistaMantenimientos.getContext(), "Selecciona una moto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }


    public String convertidorSwitch(Switch sw){
        if(sw.isChecked()){
            return "si";
        }
            return "no";
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}