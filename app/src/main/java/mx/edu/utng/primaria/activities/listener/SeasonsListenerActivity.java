package mx.edu.utng.primaria.activities.listener;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.primaria.R;

public class SeasonsListenerActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivSeason;
    ImageView ivTheSeason;
    Button anterior;
    Button siguiente;
    private SoundPool soundPool;
    private int loader1;
    private int loader2;
    private int loader3;
    private int loader4;

    int[] seasons = {R.drawable.spring, R.drawable.summer, R.drawable.fall, R.drawable.winter};
    int[] season = {R.drawable.spring_text, R.drawable.summer_text, R.drawable.fall_text, R.drawable.winter_text};

    int i = 0;
    int total;
    int total1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasons_listener);
        this.setTitle("The Seasons");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivSeason = (ImageView)findViewById(R.id.iv_season);
        ivTheSeason = (ImageView)findViewById(R.id.iv_the_seasons);
        anterior = (Button) findViewById(R.id.bt_anterior);
        siguiente = (Button) findViewById(R.id.bt_siguiente);

        anterior.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        ivSeason.setOnClickListener(this);

        total = seasons.length;
        total1 = season.length;

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(aa)
                    .build();
        }else{
            soundPool = new SoundPool(16, AudioManager.STREAM_MUSIC,1);
            this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
            loader2 = soundPool.load(this,R.raw.summer,1);
        }*/

        soundPool = new SoundPool(16, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loader1 = soundPool.load(this,R.raw.spring,1);
        loader2 = soundPool.load(this,R.raw.summer,1);
        loader3 = soundPool.load(this,R.raw.fall,1);
        loader4 = soundPool.load(this,R.raw.winter,1);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.bt_siguiente) {
            i++;
            if(i == total && i == total1){
                i = 0;
            }

        }

        if(id == R.id.bt_anterior) {
            i--;
            if(i == -1){
                i = total -1;
                i = total1 -1;
            }
        }

        ivSeason.setImageResource(season[i]);
        ivTheSeason.setImageResource(seasons[i]);
        if(ivSeason.isPressed()){
            if(i==0){
                soundPool.play(loader1, 1,1,0,0,1);

            }
            if(i==1){
                soundPool.play(loader2, 1,1,0,0,1);
            }
            if(i==2){
                soundPool.play(loader3, 1,1,0,0,1);
            }
            if(i==3){
                soundPool.play(loader4, 1,1,0,0,1);
            }
        }

    }
}
