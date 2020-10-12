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

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> favoritos;
    private RecyclerView listaFavoritos;
    private Toolbar toolbar_favoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar_favoritos = findViewById(R.id.toolbar_favoritos);
        setSupportActionBar(toolbar_favoritos);
        ActionBar dc = getSupportActionBar();
        assert dc != null;
        dc.setDisplayHomeAsUpEnabled(true);

        listaFavoritos = findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);  // crea el layout
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(llm);     // asigna el layout al view RecyclerView*/
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){

        adaptador = new MascotaAdaptador(favoritos, this);
        listaFavoritos.setAdapter(adaptador);

    }
    public void inicializarListaMascotas(){

        favoritos = new ArrayList<>();

        favoritos.add(new Mascota(R.drawable.dog_6,
                "Marga",
                "15"));
        favoritos.add(new Mascota(R.drawable.dog_7,
                "Clemente",
                "5"));
        favoritos.add(new Mascota(R.drawable.dog_5,
                "Guti",
                "6"));
        favoritos.add(new Mascota(R.drawable.dog_9,
                "Pancha",
                "4"));
        favoritos.add(new Mascota(R.drawable.dog_10,
                "Frank",
                "8"));
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