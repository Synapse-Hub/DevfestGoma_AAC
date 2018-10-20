package com.example.david.devfestgoma_aac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.david.devfestgoma_aac.database.AppDatabase;
import com.example.david.devfestgoma_aac.database.Personne;

public class AddPersonActivity extends AppCompatActivity {

    private EditText mName;
    private RadioGroup mGenderRadioGroup;
    private Button mSaveBtn;

    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        mDb =AppDatabase.getInstance(this);

        mName = findViewById(R.id.name);
        mGenderRadioGroup = findViewById(R.id.gener_radioGroup);
        mSaveBtn = findViewById(R.id.save_btn);

        mSaveBtn.setOnClickListener(v->{
            onSaveButtonClicked();
        });


    }

    public void onSaveButtonClicked() {
        String name = mName.getText().toString();
        String gender = getGenderFromView();

        Personne personne = new Personne(name,gender);
        mDb.personneDaoDao().insertPersonne(personne);
        finish();
    }




    public String getGenderFromView(){
        String gender ="Feminin";
        int checkedId = ((RadioGroup) findViewById(R.id.gener_radioGroup)).getCheckedRadioButtonId();
        switch (checkedId){
            case R.id.masculin_rb:
                gender = getString(R.string.masculin);
                break;
            case R.id.feminin_rb:
                gender = getString(R.string.feminin);
                break;
                }

                return gender;
    }

    public void setgenderInView(String gender){
        switch (gender){
            case "Masculin":
                ((RadioGroup) findViewById(R.id.gener_radioGroup)).check(R.id.masculin_rb);
                break;
            case "Feminin":
                ((RadioGroup) findViewById(R.id.gener_radioGroup)).check(R.id.feminin_rb);
                break;
        }
    }
}
