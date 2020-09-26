package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srlMiIndicadorRefresh;
    ListView lvMiLista;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        srlMiIndicadorRefresh = findViewById(R.id.srlMiIndicadorRefresh);
        lvMiLista = findViewById(R.id.lvMiLista);
        String[] planetas = getResources().getStringArray(R.array.planetas);

        lvMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        srlMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

    public void refrescandoContenido() {
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        srlMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB(){
        FloatingActionButton fab1 = findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.text_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}
