package com.example.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        toolbar_main = findViewById(R.id.toolbar_main);
        setUpViewPager();
        if(toolbar_main != null) {
            setSupportActionBar(toolbar_main);
        }
        agregarFAB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public void agregarFAB () {
        FloatingActionButton fab1 = findViewById(R.id.fabMascota);
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


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MascotasFragment());
        fragments.add(new DetalleFragment());

        return fragments;
    }

    public void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.cucha_dog);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_face);

    }
}


