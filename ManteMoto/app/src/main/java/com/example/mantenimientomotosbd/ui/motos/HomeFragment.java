package com.example.mantenimientomotosbd.ui.motos;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mantenimientomotosbd.BDSQL;
import com.example.mantenimientomotosbd.ui.Objetos.Moto;
import com.example.mantenimientomotosbd.R;
import com.example.mantenimientomotosbd.RegisterActivity;
import com.example.mantenimientomotosbd.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public static Moto motoStatica;
    public static boolean noExistenObjetos = true;
    private FragmentHomeBinding binding;
    public View vista;

    List<Moto> arrayMotos = new ArrayList<>();
    private int icono = R.drawable.llave;
    private TextView matricula, marca, modelo, cilindrada, fabricacion, cv, parMotor;
    private Spinner spinner;
    Button btnAdd;
    motosAdapter madapter = new motosAdapter();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        vista = root;

        if(arrayMotos.size()==0){
            noExistenObjetos = true;
        }else{
            noExistenObjetos = false;
        }

        //asi es como se declaran los items en un fragment
        iniOnCreateViewHome(binding);
        btnAdd = binding.btnAdd;

        animacionBoton();

        //tengo que eliminar los objetos del spinner.
        arrayMotos.removeAll(arrayMotos);

        //Pasar de la bd a objetos.
        datosObjeto();
        spinner.setAdapter(madapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                motoStatica = arrayMotos.get(i);
                if(arrayMotos.size()!=0){
                    noExistenObjetos = false;
                    ocultarText();
                }

                if (arrayMotos.size() > 0) {
                    matricula.setText("Matrícula: "+motoStatica.getMatricula());
                    marca.setText("Marca: "+motoStatica.getMarca());
                    modelo.setText("Modelo: "+motoStatica.getModelo());
                    cilindrada.setText("Cilindrada: "+ motoStatica.getCilindrada());
                    fabricacion.setText("Año de fabricación: "+motoStatica.getAnhoFabricacion());
                    cv.setText("CV: "+motoStatica.getCv());
                    parMotor.setText("PAR: "+motoStatica.getParMotor());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //accion del boton tiene que llevarme a una ACTIVITY
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void animacionBoton(){
            ObjectAnimator logoAnimacion = ObjectAnimator.ofFloat(btnAdd, "rotation", 0, 360);
            logoAnimacion.setDuration(2000);
            AnimatorSet animationSetAlpha = new AnimatorSet();
            animationSetAlpha.play(logoAnimacion);
            animationSetAlpha.start();
        }


    public void datosObjeto() {
        BDSQL admin = new BDSQL(vista.getContext(), "MantenimientoMotos", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select Matricula, Marca, Modelo, Cilindrada, Anho_Fabricacion, CV, ParMotor " +
                "FROM Motos", null);

        while (cursor.moveToNext()) {
            String matricula = cursor.getString(0);
            String marca = cursor.getString(1);
            String modelo = cursor.getString(2);
            String cilindrada = cursor.getString(3);
            String ahoFabricacion = cursor.getString(4);
            String cV = cursor.getString(5);
            String parMotor = cursor.getString(6);
            //pode petar ULTIMA MODIFICACIÓN
            Moto motoPrueba = new Moto(matricula, marca, modelo, Integer.parseInt(cilindrada), Integer.parseInt(ahoFabricacion),
                    Float.parseFloat(cV), Float.parseFloat(parMotor));
            arrayMotos.add(motoPrueba);
        }
        db.close();
        for (int i = 0; i < arrayMotos.size(); i++) {
            System.out.println(arrayMotos.get(i));
        }
    }

    //iniciador de home
    public void iniOnCreateViewHome(FragmentHomeBinding binding) {
        matricula = binding.homeMatricula;
        marca = binding.homeMarca;
        modelo = binding.homeModelo;
        cilindrada = binding.homeCilindrada;
        fabricacion = binding.homeFabricacion;
        cv = binding.homeCv;
        parMotor = binding.homeParMotor;
        spinner = binding.itemSpinner;
        ocultarText();
    }

    public void ocultarText(){
        if(noExistenObjetos==true){
            matricula.setVisibility(View.INVISIBLE);
            marca.setVisibility(View.INVISIBLE);
            modelo.setVisibility(View.INVISIBLE);
            cilindrada.setVisibility(View.INVISIBLE);
            cv.setVisibility(View.INVISIBLE);
            parMotor.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.INVISIBLE);
        }else{
            matricula.setVisibility(View.VISIBLE);
            marca.setVisibility(View.VISIBLE);
            modelo.setVisibility(View.VISIBLE);
            cilindrada.setVisibility(View.VISIBLE);
            cv.setVisibility(View.VISIBLE);
            parMotor.setVisibility(View.VISIBLE);
            spinner.setVisibility(View.VISIBLE);
        }
    }


    private class motosAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayMotos.size();
        }

        @Override
        public Moto getItem(int i) {
            return arrayMotos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(vista.getContext());
            view = inflater.inflate(R.layout.layout_spinner_moto, null);
            ImageView iv1 = view.findViewById(R.id.iconObject);
            TextView tv1 = view.findViewById(R.id.txtView);
            iv1.setImageResource(icono);
            tv1.setText("   "+arrayMotos.get(i).getMatricula());
            tv1.setTextSize(20);
            return view;

        }
    }
}