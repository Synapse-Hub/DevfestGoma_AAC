package com.example.david.devfestgoma_aac.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "personne")
public class Personne {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String sex;


    public Personne(String nom, String sex) {
        this.nom = nom;
        this.sex = sex;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
