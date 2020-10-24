package com.example.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTA + "(" +
                ConstantesBD.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY, " +
                ConstantesBD.TABLE_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBD.TABLE_MASCOTA_IMAGE + " INTEGER, " +
                ConstantesBD.TABLE_MASCOTA_NAME + " TEXT, " +
                ConstantesBD.TABLE_MASCOTA_LIKES + " TEXT " +
                ")";

        db.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTA + " ORDER BY id DESC limit 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId_mascota(registros.getInt(1));
            mascotaActual.setImage(registros.getInt(2));
            mascotaActual.setName(registros.getString(3));
            mascotaActual.setLikes(registros.getString(4));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){ // inserta registro en la tabla mascota
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTA, null, contentValues);
        db.close();
    }
}