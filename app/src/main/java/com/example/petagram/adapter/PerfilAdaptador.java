package com.example.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {
    ArrayList<Mascota> mascota_fotos;
    Activity activity;

    public PerfilAdaptador(ArrayList<Mascota> mascota_fotos, Activity activity) {  // constructor
        this.activity = activity;
        this.mascota_fotos = mascota_fotos;
    }

    @NonNull
    @Override     // infla el layout y se lo pasa al ViewHolder para que obtenga los views
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent,false);
        return new PerfilViewHolder(view);
    }


    @Override    // enlaza cada elemento de la lista con cada view
    public void onBindViewHolder(PerfilViewHolder perfilViewHolder, int position) {
        final Mascota mascota = mascota_fotos.get(position);
        perfilViewHolder.ivImage.setImageResource(mascota.getImage());
        perfilViewHolder.tvLikes.setText(mascota.getLikes());
    }

    @Override
    public int getItemCount() {
        return mascota_fotos.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {  //clase anidada

        private ImageView ivImage;
        private TextView tvLikes;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvLikes = itemView.findViewById(R.id.tvLikes);
        }
    }

}
