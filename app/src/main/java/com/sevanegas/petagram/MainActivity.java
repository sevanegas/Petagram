    package com.sevanegas.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

    ArrayList<Datos_Mascotas> mascotas;
    private RecyclerView ListaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar ActionBar = findViewById(R.id.actionbar);
        setSupportActionBar(ActionBar);


        ListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaAdaptador();

    }

    public void inicializaAdaptador (){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        ListaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {

        mascotas = new ArrayList<Datos_Mascotas>();
        mascotas.add(new Datos_Mascotas("Max",R.drawable.perro_1));
        mascotas.add(new Datos_Mascotas("Kira",R.drawable.perro_2));
        mascotas.add(new Datos_Mascotas("Dominic",R.drawable.perro_3));
        mascotas.add(new Datos_Mascotas("Dante",R.drawable.perro_4));
        mascotas.add(new Datos_Mascotas("Lucas",R.drawable.perro_5));
        mascotas.add(new Datos_Mascotas("Oliver",R.drawable.perro_6));
        mascotas.add(new Datos_Mascotas("Mia",R.drawable.perro_7));
        mascotas.add(new Datos_Mascotas("Luna",R.drawable.perro_8));
        mascotas.add(new Datos_Mascotas("Maya",R.drawable.perro_9));
        mascotas.add(new Datos_Mascotas("Tarcan",R.drawable.perro_10));

    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_over, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()){
                case R.id.Configuracion:
                    Intent intent=new Intent(this, Ajustes.class);
                    startActivity(intent);
                    break;
            }
            switch (item.getItemId()){
                case R.id.btFav:
                    Intent i = new Intent(this, Favorito.class);
                    startActivity(i);
                    break;
            }
            return super.onOptionsItemSelected(item);
        }
    }