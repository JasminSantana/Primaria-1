package mx.edu.utng.primaria.activities.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.AnimalsColors;
import mx.edu.utng.primaria.adapters.WritingAdapter;
import mx.edu.utng.primaria.model.ActivityWriting;

/**
 * Created by Husky Siberiano on 26/02/2017.
 */

public class ColorPurlpeActivity extends AppCompatActivity {
    private EditText etColorWriting;
    private TextView tvColor;
    private WritingAdapter adapter;
    private List<ActivityWriting> writings = new ArrayList<ActivityWriting>();
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        this.setTitle("What color is?");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        initComponents();
    }

    public void initComponents(){

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(ColorPurlpeActivity.this);
        rvList.setLayoutManager(manager);

        writings.add(new ActivityWriting(R.drawable.purple_writing, "escribe el color indicado:", " P _ R _ L E  ", "",R.color.enable));

        adapter = new WritingAdapter(writings);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_completed:
                        etColorWriting = (EditText)findViewById(R.id.et_writing_complete);
                        tvColor  = (TextView)findViewById(R.id.et_writing_color);
                        etColorWriting.getText().toString();
                        String colorcito = etColorWriting.getText().toString();

                        if(colorcito.equalsIgnoreCase("purple")){
                            tvColor.setText("P U R P L E  ");
                            soundPool.play(soundPool.load(ColorPurlpeActivity.this,R.raw.winner,1), 1,1,0,0,1);
                            int secondsDelayed = 3000;
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(ColorPurlpeActivity.this);
                                    builder.setMessage("\nHAS CONCLUIDO LA SECCIÓN DE: "+Html.fromHtml("<font color='#FF0040'<b>writing colors</b></font>"))
                                            .setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ F E L I C I D A D E S ! </b></font>"))
                                            .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                                            .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    startActivity(new Intent(ColorPurlpeActivity.this,AnimalsColors.class));
                                                }
                                            });
                                    builder.show();
                                    finish();
                                }
                            }, secondsDelayed);

                        }else {
                            Toast toast = Toast.makeText(getApplicationContext(),"has escrito un color incorrecto: " + etColorWriting.getText().toString(), Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                            toast.show();
                            break;
                        }
                }
            }
        });
        rvList.setAdapter(adapter);
    }

}