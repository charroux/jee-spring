package com.example.demo;

public class Car {

    String marque;
    int prix;
    String plaque;

    public Car(String marque, int prix, String plaque) {
        this.marque = marque;
        this.prix = prix;
        this.plaque = plaque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }
}
