package com.example.david.devfestgoma_aac.database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.arch.persistence.room.Dao;

import java.util.List;

@Dao
public interface PersonneDao {

    @Query("select * from personne")
   LiveData<List<Personne>> allPersonnes();

    @Insert
    void insertPersonne(Personne personne);

    @Delete
    void deletePersonne(Personne personne);

    @Update
    void  updatePersonne(Personne personne);

}
