package com.example.david.devfestgoma_aac;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.david.devfestgoma_aac.database.AppDatabase;
import com.example.david.devfestgoma_aac.database.Personne;

import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton mAdd;

    private AppDatabase mDb;
    private PersonneAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDb = AppDatabase.getInstance(this);

        mAdd = findViewById(R.id.add_person);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        recyclerView.addItemDecoration(decoration);


        //populating the recycleVidew
        mAdapter = new PersonneAdapter(this,  mDb.personneDaoDao().allPersonnes());
        recyclerView.setAdapter(mAdapter);



        /*
         swipes to delete
         */
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            // Called when a user swipes left or right on a ViewHolder
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                // Here is where you'll implement swipe to delete
                int position = viewHolder.getAdapterPosition();
                mDb.personneDaoDao().deletePersonne(mAdapter.getPersonnes().get(position));
            }
        }).attachToRecyclerView(recyclerView);




        mAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this,AddPersonActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
