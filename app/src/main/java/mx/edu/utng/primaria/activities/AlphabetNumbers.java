package mx.edu.utng.primaria.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.listener.Alphabet;
import mx.edu.utng.primaria.activities.listener.NumbersListening;
import mx.edu.utng.primaria.activities.test.Test;
import mx.edu.utng.primaria.adapters.ActivitiesAdapter;
import mx.edu.utng.primaria.model.Activities;

public class AlphabetNumbers extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new GridLayoutManager(AlphabetNumbers.this, 2);
        rvList.setLayoutManager(manager);

        List<Activities> activitiesList = new ArrayList<Activities>();
        activitiesList.add(new Activities(R.drawable.ic_alphabet_listening, "Alphabet", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_numbers_listening, "Numbers", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_alphabet_writing, "Alphabet", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_numbers_writing, "Numbers", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_resourses, "Resources", "Videos",R.color.enable));
        activitiesList.add(new Activities(R.drawable.test, "Test", "Final Test Activity",R.color.enable));


        ActivitiesAdapter adapter = new ActivitiesAdapter(activitiesList);
        adapter.setOnclicListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rvList.getChildPosition(v)){
                    case 0://por el momento a  alfabet
                        startActivity(new Intent(getApplicationContext(),Alphabet.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),NumbersListening.class));
                        break;
                    case 2:
                        //clase a llamar AlphabetWrititng
                       // startActivity(new Intent(getApplicationContext(),AlphabetWriting.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),NumbersListening.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),AdditionalMaterial.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(),Test.class));

                }
            }
        });
        rvList.setAdapter(adapter);
    }

    }



