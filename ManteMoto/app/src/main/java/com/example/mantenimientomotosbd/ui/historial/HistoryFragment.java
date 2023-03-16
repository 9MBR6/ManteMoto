package com.example.mantenimientomotosbd.ui.historial;

import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.motoStatica;
import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.noExistenObjetos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mantenimientomotosbd.BDSQL;
import com.example.mantenimientomotosbd.databinding.FragmentDashboardBinding;
import com.example.mantenimientomotosbd.ui.Objetos.Mantenimiento;
import com.example.mantenimientomotosbd.ui.RecyclerAdapter;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    TextView bujia, aceite, bateria, filtroAceite, filtroAire, liquidoFrenos, pastillasDelanteras, pastillasTraseras, neumaticoDelantero, neumaticoTrasero;
    View vistaHistorial;
    RecyclerView rv;
    public static ArrayList<Mantenimiento> mantenimientosMoto = new ArrayList<>();

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vistaHistorial = root;
        iniOnCreateView(binding);

        mantenimientosMoto.removeAll(mantenimientosMoto);


        if (noExistenObjetos == false) {
            recuperarDatosPasarObjetos();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(vistaHistorial.getContext());
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(new RecyclerAdapter());


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void iniOnCreateView(FragmentDashboardBinding binding) {
        filtroAceite = binding.viewFiltroAceite;
        filtroAire = binding.viewFIltroAire;
        liquidoFrenos = binding.viewLiquidoFrenos;
        pastillasDelanteras = binding.viewPastillasDelanteras;
        pastillasTraseras = binding.viewPastillasTraseras;
        neumaticoDelantero = binding.viewNeumaticoDelantero;
        neumaticoTrasero = binding.viewNeumaticoTrasero;
        bujia = binding.viewBujia;
        aceite = binding.viewAceite;
        bateria = binding.viewBateria;
        rv = binding.recyclerView;
        if (noExistenObjetos == false) {
            mostrarDatosMoto();
        }

    }

    public void mostrarDatosMoto() {

        BDSQL admin = new BDSQL(vistaHistorial.getContext(), "MantenimientoMotos", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select Bujia, Aceite, Bateria, Filtro_Aceite, Filtro_Aire, Liquido_Frenos" +
                ", Pastillas_Delanteras,Pastillas_Traseras, Neumatico_Delantero, Neumatico_Trasero FROM Recambios " +
                "where Matricula like '" + motoStatica.getMatricula() + "'", null);
        //esto se hace para poner el cursor en primera posición
        if (cursor.moveToNext()) {
            bujia.setText(cursor.getString(0));
            aceite.setText(cursor.getString(1));
            bateria.setText(cursor.getString(2));
            filtroAceite.setText(cursor.getString(3));
            filtroAire.setText(cursor.getString(4));
            liquidoFrenos.setText(cursor.getString(5));
            pastillasDelanteras.setText(cursor.getString(6));
            pastillasTraseras.setText(cursor.getString(7));
            neumaticoDelantero.setText(cursor.getString(8));
            neumaticoTrasero.setText(cursor.getString(9));
        }
        db.close();
    }

    public void recuperarDatosPasarObjetos() {
        BDSQL admin = new BDSQL(vistaHistorial.getContext(), "MantenimientoMotos", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select ID_Mantenimiento, Fecha, KMs, Aceite, Filtro_Aceite, Filtro_Aire, Bujia," +
                "Pastillas_Delanteras, Pastillas_Traseras, Liquido_Frenos, Kit_Arrastre, Otros_Trabajos FROM Mantenimientos " +
                "WHERE Matricula like '" + motoStatica.getMatricula() + "' ORDER BY ID_Mantenimiento DESC", null);

        while (cursor.moveToNext()) {
            int id_Mantenimiento = Integer.parseInt(cursor.getString(0));
            String fecha = cursor.getString(1);
            int KMs = Integer.parseInt(cursor.getString(2));
            String aceite = cursor.getString(3);
            String filtroAceite = cursor.getString(4);
            String filtroAire = cursor.getString(5);
            String bujia = cursor.getString(6);
            String pastillasDelanteras = cursor.getString(7);
            String pastillasTraseras = cursor.getString(8);
            String liquidoFrenos = cursor.getString(9);
            String kitArrastre = cursor.getString(10);
            String otrosTrabajos = cursor.getString(11);

            Mantenimiento auxMantenimientos = new Mantenimiento(id_Mantenimiento, fecha, KMs, aceite, filtroAceite, filtroAire
                    , bujia, pastillasDelanteras, pastillasTraseras, liquidoFrenos, kitArrastre, otrosTrabajos);
            mantenimientosMoto.add(auxMantenimientos);
        }
        db.close();
    }
}