package mx.edu.utng.primaria.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.listener.Alphabet;
import mx.edu.utng.primaria.activities.listener.ColorListeningActivity;
import mx.edu.utng.primaria.adapters.ActivitiesAdapter;
import mx.edu.utng.primaria.model.Activities;

/**
 * Created by Husky Siberiano on 04/02/2017.
 */
public class AnimalsColors extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new GridLayoutManager(AnimalsColors.this, 2);
        rvList.setLayoutManager(manager);

        List<Activities> activitiesList = new ArrayList<Activities>();
        activitiesList.add(new Activities(R.drawable.ic_animals_listening, "Animals", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_colors_listening, "Colors", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_animals_writing, "Animals", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_colors_writing, "Colors", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_resourses, "Resources", "Videos",R.color.enable));
        activitiesList.add(new Activities(R.drawable.test, "Test", "Final Test Activity",R.color.enable));

        ActivitiesAdapter adapter = new ActivitiesAdapter(activitiesList);
        adapter.setOnclicListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rvList.getChildPosition(v)){
                    case 0:
                        startActivity(new Intent(getApplicationContext(),Alphabet.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),ColorListeningActivity.class));
                        break;
                   /* case 2:
                        startActivity(new Intent(getApplicationContext(),AlphabetWrititng.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),NumbersWriting.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),TestActivity1.class));
                        break;*/
                }
            }
        });
        rvList.setAdapter(adapter);
    }

}
