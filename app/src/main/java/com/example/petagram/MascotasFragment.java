package com.example.petagram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        listaMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());  // crea el layout
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);     // asigna el layout al view RecyclerView*/
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){

        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.dog_1,
                "Tequila",
                "3"));
        mascotas.add(new Mascota(R.drawable.dog_2,
                "Melina",
                "5"));
        mascotas.add(new Mascota(R.drawable.dog_3,
                "Homero",
                "8"));
        mascotas.add(new Mascota(R.drawable.dog_4,
                "Brisa",
                "4"));
        mascotas.add(new Mascota(R.drawable.dog_5,
                "Guti",
                "6"));
    }
}