package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AcercaDeActivity extends AppCompatActivity {

    ImageView imgDesarrollador;
    TextView tvDesarrollador;
    private Toolbar toolbar_acerca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        imgDesarrollador = findViewById(R.id.imgDesarrollador);
        tvDesarrollador = findViewById(R.id.tvDesarrollador);

        Toolbar toolbar_acerca = findViewById(R.id.toolbar_acerca);
        setSupportActionBar(toolbar_acerca);
        ActionBar bc = getSupportActionBar();
        assert bc != null;
        bc.setDisplayHomeAsUpEnabled(true);

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
            case R.id.mAcercaDe:
                Intent intento = new Intent(this, AcercaDeActivity.class);
                startActivity(intento);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}