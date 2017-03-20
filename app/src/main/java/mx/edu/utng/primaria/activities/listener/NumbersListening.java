package mx.edu.utng.primaria.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import mx.edu.utng.primaria.R;

public class NumbersListening extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivOne;
    private ImageView ivTwo;
    private ImageView ivThree;
    private ImageView ivFour;
    private ImageView ivFive;
    private ImageView ivSix;
    private ImageView ivSeven;
    private ImageView ivEight;
    private ImageView ivNine;
    private ImageView ivTen;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_listening);
        this.setTitle("Numbers Listening");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivOne = (ImageView)findViewById(R.id.iv_one);
        ivTwo = (ImageView)findViewById(R.id.iv_two);
        ivThree = (ImageView)findViewById(R.id.iv_three);
        ivFour = (ImageView)findViewById(R.id.iv_four);
        ivFive = (ImageView)findViewById(R.id.iv_five);
        ivSix =(ImageView)findViewById(R.id.iv_six);
        ivSeven = (ImageView)findViewById(R.id.iv_seven);
        ivEight = (ImageView)findViewById(R.id.iv_eight);
        ivNine = (ImageView)findViewById(R.id.iv_nine);
        ivTen = (ImageView)findViewById(R.id.iv_ten);
        ivOne.setOnClickListener(this);
        ivTwo.setOnClickListener(this);
        ivThree.setOnClickListener(this);
        ivFour.setOnClickListener(this);
        ivFive.setOnClickListener(this);
        ivSix.setOnClickListener(this);
        ivSeven.setOnClickListener(this);
        ivEight.setOnClickListener(this);
        ivNine.setOnClickListener(this);
        ivTen.setOnClickListener(this);


        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_one:
                soundPool.play(soundPool.load(this,R.raw.one,1), 1,1,0,0,1);
                break;
            case R.id.iv_two:
                soundPool.play(soundPool.load(this,R.raw.two,1), 1,1,0,0,1);
                break;
            case R.id.iv_three:
                soundPool.play(soundPool.load(this,R.raw.trhee,1), 1,1,0,0,1);
                break;
            case R.id.iv_four:
                soundPool.play(soundPool.load(this,R.raw.four,1), 1,1,0,0,1);
                break;
            case R.id.iv_five:
                soundPool.play(soundPool.load(this,R.raw.five,1), 1,1,0,0,1);
                break;
            case R.id.iv_six:
                soundPool.play(soundPool.load(this,R.raw.six,1), 1,1,0,0,1);
                break;
            case R.id.iv_seven:
                soundPool.play(soundPool.load(this,R.raw.seven,1), 1,1,0,0,1);
                break;
            case R.id.iv_eight:
                soundPool.play(soundPool.load(this,R.raw.eigth,1), 1,1,0,0,1);
                break;
            case R.id.iv_nine:
                soundPool.play(soundPool.load(this,R.raw.nine,1), 1,1,0,0,1);
                break;
            case R.id.iv_ten:
                soundPool.play(soundPool.load(this,R.raw.tenn,1), 1,1,0,0,1);
                break;
        }

    }
}
