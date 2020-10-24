package com.example.petagram.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        rvMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());  // crea el layout
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);     // asigna el layout al view RecyclerView*/
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){

        adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);

    }
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(1, R.drawable.dog_1,
                "Tequila",
                "3"));
        mascotas.add(new Mascota(2, R.drawable.dog_2,
                "Melina",
                "5"));
        mascotas.add(new Mascota(3, R.drawable.dog_3,
                "Homero",
                "8"));
        mascotas.add(new Mascota(4,R.drawable.dog_4,
                "Brisa",
                "4"));
        mascotas.add(new Mascota(5, R.drawable.dog_5,
                "Guti",
                "6"));
        mascotas.add(new Mascota(6, R.drawable.dog_6,
                "Marga",
                "15"));
        mascotas.add(new Mascota(7, R.drawable.dog_7,
                "Clemente",
                "5"));
        mascotas.add(new Mascota(8, R.drawable.dog_8,
                "Ema",
                "11"));
        mascotas.add(new Mascota(9, R.drawable.dog_9,
                "Rufo",
                "6"));
        mascotas.add(new Mascota(10, R.drawable.dog_10,
                "Frank",
                "7"));
    }
}