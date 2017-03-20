package mx.edu.utng.primaria.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mx.edu.utng.primaria.R;

public class ColorListeningActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivRed;
    private ImageView ivYellow;
    private ImageView ivOrange;
    private ImageView ivWhite;
    private ImageView ivGreen;
    private ImageView ivBlue;
    private ImageView ivPink;
    private ImageView ivGrey;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_listening);
        this.setTitle("Color Listening");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivRed = (ImageView)findViewById(R.id.iv_red);
        ivYellow = (ImageView)findViewById(R.id.iv_yellow);
        ivOrange = (ImageView)findViewById(R.id.iv_orange);
        ivWhite = (ImageView)findViewById(R.id.iv_white);
        ivGreen = (ImageView)findViewById(R.id.iv_green);
        ivBlue  =(ImageView)findViewById(R.id.iv_blue);
        ivPink  = (ImageView)findViewById(R.id.iv_pink);
        ivGrey  = (ImageView)findViewById(R.id.iv_grey);
        ivRed.setOnClickListener(this);
        ivYellow.setOnClickListener(this);
        ivOrange.setOnClickListener(this);
        ivWhite.setOnClickListener(this);
        ivGreen.setOnClickListener(this);
        ivBlue.setOnClickListener(this);
        ivPink.setOnClickListener(this);
        ivGrey.setOnClickListener(this);


        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_red:
                soundPool.play(soundPool.load(this,R.raw.red,1), 1,1,0,0,1);
                break;
            case R.id.iv_yellow:
                soundPool.play(soundPool.load(this,R.raw.yellow,1), 1,1,0,0,1);
                break;
            case R.id.iv_orange:
                soundPool.play(soundPool.load(this,R.raw.orange,1), 1,1,0,0,1);
                break;
            case R.id.iv_white:
                soundPool.play(soundPool.load(this,R.raw.white,1), 1,1,0,0,1);
                break;
            case R.id.iv_green:
                soundPool.play(soundPool.load(this,R.raw.green,1), 1,1,0,0,1);
                break;
            case R.id.iv_blue:
                soundPool.play(soundPool.load(this,R.raw.blue,1), 1,1,0,0,1);
                break;
            case R.id.iv_pink:
                soundPool.play(soundPool.load(this,R.raw.pink,1), 1,1,0,0,1);
                break;
            case R.id.iv_grey:
                soundPool.play(soundPool.load(this,R.raw.gray,1), 1,1,0,0,1);
                break;
        }

    }
}
