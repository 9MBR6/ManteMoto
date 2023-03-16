package com.example.mantenimientomotosbd;

import static com.example.mantenimientomotosbd.ui.motos.HomeFragment.noExistenObjetos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mantenimientomotosbd.ui.Objetos.Moto;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mantenimientomotosbd.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.op1:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                break;

            case R.id.op2:
                if (noExistenObjetos) {
                    Intent intent21 = new Intent(this,   RegisterActivity.class);
                    startActivity(intent21);
                } else {
                    Intent intent2 = new Intent(this, EditMoto.class);
                    startActivity(intent2);
                }

                break;

            case R.id.op3:
                if (noExistenObjetos) {
                    Intent intent22 = new Intent(this,   RegisterActivity.class);
                    startActivity(intent22);
                }else {
                    Intent intent3 = new Intent(this, DelMoto.class);
                    startActivity(intent3);
                }
                break;

            case R.id.op4:/*NO IMPLEMENTADA*/
                Toast.makeText(this, "No implementado", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}