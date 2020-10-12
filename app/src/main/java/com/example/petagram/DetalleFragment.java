package com.example.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DetalleFragment extends Fragment {

    ArrayList<Mascota> mascota_fotos;
    private RecyclerView fotos_mascota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalle, container, false);
        fotos_mascota = v.findViewById(R.id.rvFotosMascota);

        GridLayoutManager glm = new GridLayoutManager(getContext(),3);  // crea el layout
        glm.setOrientation(LinearLayoutManager.VERTICAL);

        fotos_mascota.setLayoutManager(glm);     // asigna el layout al view RecyclerView*/
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public PerfilAdaptador adaptador;

    public void inicializarAdaptador(){

        adaptador = new PerfilAdaptador(mascota_fotos, getActivity());
        fotos_mascota.setAdapter(adaptador);

    }

    public void inicializarListaMascotas(){

        mascota_fotos = new ArrayList<>();

        mascota_fotos.add(new Mascota(R.drawable.basset_1, "15"));
        mascota_fotos.add(new Mascota(R.drawable.basset_2, "5"));
        mascota_fotos.add(new Mascota(R.drawable.basset_3, "8"));
        mascota_fotos.add(new Mascota(R.drawable.basset_4, "9"));
        mascota_fotos.add(new Mascota(R.drawable.basset_5, "6"));
        mascota_fotos.add(new Mascota(R.drawable.basset_6, "11"));
        mascota_fotos.add(new Mascota(R.drawable.basset_7, "2"));
        mascota_fotos.add(new Mascota(R.drawable.basset_8, "3"));
        mascota_fotos.add(new Mascota(R.drawable.basset_9, "6"));
    }
}