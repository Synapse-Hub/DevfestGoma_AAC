package com.example.david.devfestgoma_aac;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.devfestgoma_aac.database.Personne;

import java.util.List;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.PersonneViewHolder> {


    private Context mContext;
    private List<Personne> personnes;

    public PersonneAdapter(Context mContext, List<Personne> personnes) {
        this.mContext = mContext;
        this.personnes = personnes;
    }

    @NonNull
    @Override
    public PersonneViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.personne_row,viewGroup,false);

            return new PersonneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonneViewHolder personneViewHolder, int i) {
        Personne personne = personnes.get(i);
        String name = personne.getNom();
        String sex = personne.getSex();

        personneViewHolder.name.setText(name);

        GradientDrawable gender_drawable = (GradientDrawable) personneViewHolder.gender.getBackground();

        int genderColor = getGenderColor(sex);
        gender_drawable.setColor(genderColor);



    }
    private int getGenderColor(String gender) {
        int genderColor = 0;

        switch (gender) {
            case "Masculin":
                genderColor = ContextCompat.getColor(mContext, R.color.masculin_color);
                break;
            case "Feminin":
                genderColor = ContextCompat.getColor(mContext, R.color.feminin_color);
                break;
            default:
                break;
        }
        return genderColor;
    }


    @Override
    public int getItemCount() {

        return personnes.size();
    }
    public List<Personne> getPersonnes(){
        return personnes;
    }



    public class PersonneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView gender;
        public PersonneViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.personneName);
            gender = itemView.findViewById(R.id.genderTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }


    }
}
