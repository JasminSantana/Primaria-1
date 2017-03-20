package mx.edu.utng.primaria.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.adapters.ActivitiesAdapter;
import mx.edu.utng.primaria.model.Activities;

public class AdditionalMaterial extends AppCompatActivity  {
//private ImageButton imgAlfabet,imgNum,imgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        this.setTitle("Videos");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        /*imgAlfabet=(ImageButton)findViewById(R.id.image_video);
        imgAlfabet.setOnClickListener(this);
        imgNum=(ImageButton)findViewById(R.id.image_num);
        imgNum.setOnClickListener(this);
        imgColor=(ImageButton)findViewById(R.id.image_col);
        imgColor.setOnClickListener(this);*/
        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new GridLayoutManager(AdditionalMaterial.this, 2);
        rvList.setLayoutManager(manager);

        List<Activities> activitiesList = new ArrayList<Activities>();
        activitiesList.add(new Activities(R.drawable.icon_android, "Video", "1",R.color.fb));
        activitiesList.add(new Activities(R.drawable.icon_android, "Video", "2",R.color.fb));
        activitiesList.add(new Activities(R.drawable.icon_android, "Video", "3",R.color.fb));
        activitiesList.add(new Activities(R.drawable.icon_android, "Video", "4",R.color.fb));
        activitiesList.add(new Activities(R.drawable.icon_android, "Video", "5",R.color.fb));

        ActivitiesAdapter adapter = new ActivitiesAdapter(activitiesList);
        adapter.setOnclicListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rvList.getChildPosition(v)==0){
                        startActivity(new Intent(getApplicationContext(),Videos.class).putExtra("Video",1));

                }
                if(rvList.getChildPosition(v)==1){
                    startActivity(new Intent(getApplicationContext(),Videos.class).putExtra("Video",2));

                }
                if(rvList.getChildPosition(v)==2){
                    startActivity(new Intent(getApplicationContext(),Videos.class).putExtra("Video",3));

                }
                if(rvList.getChildPosition(v)==3){
                    startActivity(new Intent(getApplicationContext(),Videos.class).putExtra("Video",4));

                }
                if(rvList.getChildPosition(v)==4){
                    startActivity(new Intent(getApplicationContext(),Videos.class).putExtra("Video",5));

                }
            }
        });
        rvList.setAdapter(adapter);
    }


       /* if(v.equals(imgAlfabet)){
            Intent llamar=new Intent(this,Videos.class);
            llamar.putExtra("Video",1);
            startActivity(llamar);
        }
        if(v.equals(imgNum)){
            Intent llamar=new Intent(this,Videos.class);
            llamar.putExtra("Video",2);
            startActivity(llamar);
        }
        if(v.equals(imgColor)){
            Intent llamar=new Intent(this,Videos.class);
            llamar.putExtra("Video",3);
            startActivity(llamar);
        }
*/
}
