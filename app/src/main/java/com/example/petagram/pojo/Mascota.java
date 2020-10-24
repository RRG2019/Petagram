package com.example.petagram.pojo;

public class Mascota {

    private int id;
    private int id_mascota;
    private int image;
    private String likes;
    private String name;

    public Mascota(int id_mascota, int image, String name, String likes){
        this.id_mascota = id_mascota;
        this.image = image;
        this.name = name;
        this.likes = likes;
    }

    public Mascota(int image, String likes){
        this.image = image;
        this.likes = likes;
    }

    public Mascota(){

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getLikes() { return likes; }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
