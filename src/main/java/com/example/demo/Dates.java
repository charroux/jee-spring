package com.example.demo;

import javax.persistence.*;

@Entity
public class Dates {

    private String debut;
    private String fin;
    private Car car;
    private int id;

    public Dates(String debut, String fin, Car car) {
        this.debut = debut;
        this.fin = fin;
        this.car = car;
    }

    public Dates(String debut, String fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public Dates() {
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @OneToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
