package com.example.david.devfestgoma_aac;

import com.example.david.devfestgoma_aac.database.Personne;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainViewModelTest {

    @Test
    public void newPersonne() {
        String name = "PERSONE_NAME";
        String sex = "Masculin";
        Personne personne = new Personne(name,sex);

        assertEquals(name,personne.getNom());
        assertEquals(sex,personne.getSex());

    }
}