package com.example.petagram;

public class Mascota {
    private String likes;
    private String name;

    public String getLikes() {
        return likes;
    }

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

    private int image;

    public Mascota(int image, String name, String likes){
        this.image = image;
        this.name = name;
        this.likes = likes;
    }



}
