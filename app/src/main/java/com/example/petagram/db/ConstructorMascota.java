package com.example.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascota {

    private Context context;

    public ConstructorMascota(Context context){
        this.context = context;
    }

    public void darLikeMascota(Mascota mascota){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID_MASCOTA, mascota.getId_mascota());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_IMAGE, mascota.getImage());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_NAME, mascota.getName());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, mascota.getLikes());
        db.insertarMascota(contentValues);
    }

    public ArrayList<Mascota> obtenerDatos() {

        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
    }

}
