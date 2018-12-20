package com.example.david.devfestgoma_aac;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.example.david.devfestgoma_aac.database.AppDatabase;
import com.example.david.devfestgoma_aac.database.Personne;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private  AppDatabase mDb;
    public LiveData<PagedList<Personne>> personneList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mDb = AppDatabase.getInstance(this.getApplication());

        personneList = new LivePagedListBuilder<>(mDb.personneDao().personList(),20).build();
    }


    public void deletePersonne(int position) {
        mDb.personneDao().deletePersonne(personneList.getValue().get(position));

    }
    public void insert(String name, String sex){
        Personne personne = new Personne(name,sex);
        mDb.personneDao().insertPersonne(personne);
    }
}
