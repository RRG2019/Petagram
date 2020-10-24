package com.example.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.db.ConstructorMascota;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar_favoritos = findViewById(R.id.toolbar_favoritos);
        setSupportActionBar(toolbar_favoritos);
        ActionBar dc = getSupportActionBar();
        assert dc != null;
        dc.setDisplayHomeAsUpEnabled(true);

        rvFavoritos = findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);  // crea el layout
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavoritos.setLayoutManager(llm);     // el RecyclerView toma el layout
        inicializarFavoritos();
        inicializarAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){

        adaptador = new MascotaAdaptador(mascotas, this);
        rvFavoritos.setAdapter(adaptador);

    }
    public void inicializarFavoritos(){

        ConstructorMascota constructorMascota = new ConstructorMascota(this);
        mascotas = constructorMascota.obtenerDatos();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                Intent i = new Intent(this, FavoritosActivity.class);
                startActivity(i);
                break;
            case R.id.mContacto:
                Intent intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intento = new Intent(this, AcercaDeActivity.class);
                startActivity(intento);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}