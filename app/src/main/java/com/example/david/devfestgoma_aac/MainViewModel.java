package com.example.david.devfestgoma_aac;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.david.devfestgoma_aac.database.AppDatabase;
import com.example.david.devfestgoma_aac.database.Personne;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private  AppDatabase mDb;
    private LiveData<List<Personne>> mPersonneList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mDb = AppDatabase.getInstance(this.getApplication());
        mPersonneList = mDb.personneDao().allPersonnes();
    }

    public LiveData<List<Personne>> getPersonneList() {
        return mPersonneList;
    }

    public void deletePersonne(int position) {
        mDb.personneDao().deletePersonne(mPersonneList.getValue().get(position));

    }
    public void insert(String name, String sex){
        Personne personne = new Personne(name,sex);
        mDb.personneDao().insertPersonne(personne);
    }
}
