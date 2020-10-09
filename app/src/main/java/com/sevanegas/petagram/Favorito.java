package com.sevanegas.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Favorito extends AppCompatActivity {

    ArrayList<Datos_Mascotas> mas;
    private RecyclerView LisMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        Toolbar ActionBar = findViewById(R.id.actionbar);
        setSupportActionBar(ActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        LisMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llam = new LinearLayoutManager(this);
        llam.setOrientation(LinearLayoutManager.VERTICAL);

        LisMascotas.setLayoutManager(llam);
        iniListaMascotas();
        iniAdaptador();

    }

    public void iniAdaptador (){
        MascotaAdaptador adaptador = new MascotaAdaptador(mas);
        LisMascotas.setAdapter(adaptador);
    }

    public void iniListaMascotas () {

        mas = new ArrayList<Datos_Mascotas>();
        mas.add(new Datos_Mascotas("Tarcan",R.drawable.perro_10));
        mas.add(new Datos_Mascotas("Mia",R.drawable.perro_7));
        mas.add(new Datos_Mascotas("Dante",R.drawable.perro_4));
        mas.add(new Datos_Mascotas("Lucas",R.drawable.perro_5));
        mas.add(new Datos_Mascotas("Kira",R.drawable.perro_2));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fav, menu);
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

        return super.onOptionsItemSelected(item);
    }


}