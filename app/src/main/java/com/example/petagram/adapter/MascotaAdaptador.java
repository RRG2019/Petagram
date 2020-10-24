package com.example.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.R;
import com.example.petagram.db.ConstructorMascota;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {  // constructor
        this.activity = activity;
        this.mascotas = mascotas;
    }

    @NonNull
    @Override     // infla el layout y se lo pasa al ViewHolder para que obtenga los views
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(view);
    }

    @Override    // enlaza cada elemento de la lista con cada view
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.ivImage.setImageResource(mascota.getImage());
        mascotaViewHolder.tvName.setText(mascota.getName());
        mascotaViewHolder.tvLikes.setText(mascota.getLikes());

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a " + mascota.getName(), Toast.LENGTH_SHORT).show();
                ConstructorMascota constructorMascota = new ConstructorMascota(activity);
                constructorMascota.darLikeMascota(mascota);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {  //clase anidada


        private ImageView ivImage;
        private TextView tvName;
        private TextView tvLikes;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            btnLike = itemView.findViewById(R.id.btnLike);
            tvLikes = itemView.findViewById(R.id.tvLikes);
        }
    }
}
