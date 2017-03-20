package mx.edu.utng.primaria.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.listener.ColorListeningActivity;
import mx.edu.utng.primaria.activities.test.TestAnimalsColorsActivity;
import mx.edu.utng.primaria.activities.write.ColorOrangeActivity;
import mx.edu.utng.primaria.adapters.ActivitiesAdapter;
import mx.edu.utng.primaria.model.Activities;

/**
 * Created by Husky Siberiano on 04/02/2017.
 */
public class AnimalsColors extends ActionBarActivity {
    final String[] items = {"ORANGE", "RED", "BLUE", "BLACK", "WHITE", "YELLOW", "PINK", "GREEN"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        this.setTitle("Animals and Colors");
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
                        //startActivity(new Intent(getApplicationContext(),AnimalsListener.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),ColorListeningActivity.class));
                        break;
                    case 2:
                        //startActivity(new Intent(getApplicationContext(),AnimalsWriting.class));
                        break;
                    case 3:
                        AlertDialog.Builder builder = new AlertDialog.Builder(AnimalsColors.this);
                        builder.setMessage("En esta actividad tienes que escribir el nombre de los siguientes colores: " +
                                "\n1.- ORANGE\n2.- RED\n3.- YELLOW\n4.- BLACK\n5.- WHITE\n6.- BLUE\n7.- GREEN\n8.- PINK\n9.- BROWN\n10.- PURPLE")
                                .setTitle(Html.fromHtml("<font color='#FF0000'><b>Escribir el nombre de los colores</b></font>")).setIcon(getResources().getDrawable(R.drawable.logo))
                                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        startActivity(new Intent(getApplicationContext(),ColorOrangeActivity.class));
                                    }
                                });
                        builder.show();
                        break;
                    case 4:
                        //videos
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(),TestAnimalsColorsActivity.class));
                        break;
                }
            }
        });
        rvList.setAdapter(adapter);
    }

}
