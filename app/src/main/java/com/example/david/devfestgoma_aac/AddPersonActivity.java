package com.example.david.devfestgoma_aac;

import android.arch.lifecycle.ViewModelProviders;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);


        mName = findViewById(R.id.name);
        mGenderRadioGroup = findViewById(R.id.gener_radioGroup);
        mSaveBtn = findViewById(R.id.save_btn);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);


        mSaveBtn.setOnClickListener(v->{
           viewModel.insert(mName.getText().toString(),getGenderFromView());
           finish();
        });


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
