package mx.edu.utng.primaria.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import mx.edu.utng.primaria.R;

public class ClothesListenerActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivGroup1;
    private ImageView ivGroup2;
    private ImageView ivGroup3;
    private ImageView ivGroup4;
    private ImageView ivGroup5;
    private ImageView ivGroup6;
    private CardView cvGroup1;
    private CardView cvGroup2;
    private CardView cvGroup3;
    private CardView cvGroup4;
    private CardView cvGroup5;
    private CardView cvGroup6;
    private TextView tvGroup1;
    private TextView tvGroup2;
    private TextView tvGroup3;
    private TextView tvGroup4;
    private TextView tvGroup5;
    private TextView tvGroup6;
    private SoundPool soundPool;

    private static final int[] group1 = {R.drawable.belt, R.drawable.bikini, R.drawable.boots, R.drawable.cap};
    private static final int[] sound1 = {R.raw.bet, R.raw.bikini, R.raw.boots, R.raw.cap};
    private static final String[] text1 = {"BET", "BIKINI", "BOOTS", "CAP"};

    private static final int[] group2 = {R.drawable.hat, R.drawable.high_heeled, R.drawable.jacket};
    private static final int[] sound2 = {R.raw.hat, R.raw.high_heeled, R.raw.jacket};
    private static final String[] text2 = {"HAT", "HIGH HEELED", "JACKET"};

    private static final int[] group3 = {R.drawable.scarf, R.drawable.shirt, R.drawable.shoes, R.drawable.shorts};
    private static final int[] sound3 = {R.raw.scarf, R.raw.shirt, R.raw.shoes, R.raw.shorts};
    private static final String[] text3 = {"SCARF", "SHIRT", "SHOES", "SHORTS"};

    private static final int[] group4 = {R.drawable.sweater, R.drawable.t_shirt, R.drawable.tracksuit, R.drawable.trousers_pants};
    private static final int[] sound4 = {R.raw.sweater, R.raw.t_shirt, R.raw.tracksuit, R.raw.pants};
    private static final String[] text4 = {"SWEATER", "T-SHIRT", "TRACKSUIT", "PANTS"};

    private static final int[] group5 = {R.drawable.coat, R.drawable.dress, R.drawable.sandals};
    private static final int[] sound5 = {R.raw.coat, R.raw.dress, R.raw.sandals};
    private static final String[] text5 = {"COAT", "DRESS", "SANDALS"};

    private static final int[] group6 = {R.drawable.skirt, R.drawable.socks, R.drawable.underwear};
    private static final int[] sound6 = {R.raw.skirt, R.raw.socks, R.raw.underwear};
    private static final String[] text6 = {"SKIRT","SOCKS", "UNDERWEAR"};

    private static final Random rGenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_listener);
        this.setTitle("Clothes Listening");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivGroup1 = (ImageView) findViewById(R.id.iv_group_1);
        ivGroup2 = (ImageView)findViewById(R.id.iv_group_2);
        ivGroup3 = (ImageView)findViewById(R.id.iv_group_3);
        ivGroup4 = (ImageView)findViewById(R.id.iv_group_4);
        ivGroup5 = (ImageView)findViewById(R.id.iv_group_5);
        ivGroup6 = (ImageView)findViewById(R.id.iv_group_6);
        cvGroup1 = (CardView)findViewById(R.id.cv_group_1);
        cvGroup2 = (CardView)findViewById(R.id.cv_group_2);
        cvGroup3 = (CardView)findViewById(R.id.cv_group_3);
        cvGroup4 = (CardView)findViewById(R.id.cv_group_4);
        cvGroup5 = (CardView)findViewById(R.id.cv_group_5);
        cvGroup6 = (CardView)findViewById(R.id.cv_group_6);
        tvGroup1 = (TextView)findViewById(R.id.tv_group1);
        tvGroup2 = (TextView)findViewById(R.id.tv_group2);
        tvGroup3 = (TextView)findViewById(R.id.tv_group3);
        tvGroup4 = (TextView)findViewById(R.id.tv_group4);
        tvGroup5 = (TextView)findViewById(R.id.tv_group5);
        tvGroup6 = (TextView)findViewById(R.id.tv_group6);

        cvGroup1.setOnClickListener(this);
        cvGroup2.setOnClickListener(this);
        cvGroup3.setOnClickListener(this);
        cvGroup4.setOnClickListener(this);
        cvGroup5.setOnClickListener(this);
        cvGroup6.setOnClickListener(this);


        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_group_1:
                int  i1 = rGenerator.nextInt(group1.length);
                int image1 = group1[i1];
                int s1 = sound1[i1];
                String t1 = text1[i1];
                ivGroup1.setImageResource(image1);
                tvGroup1.setText(t1);
                soundPool.play(soundPool.load(this,s1,1), 1,1,0,0,1);
                break;

            case R.id.cv_group_2:
                int i2 = rGenerator.nextInt(group2.length);
                int image2 = group2[i2];
                int s2 = sound2[i2];
                String t2 = text2[i2];
                ivGroup2.setImageResource(image2);
                tvGroup2.setText(t2);
                soundPool.play(soundPool.load(this,s2,1), 1,1,0,0,1);
                break;

            case R.id.cv_group_3:
                int i3 = rGenerator.nextInt(group3.length);
                int image3 = group3[i3];
                int s3 = sound3[i3];
                String t3 = text3[i3];
                ivGroup3.setImageResource(image3);
                tvGroup3.setText(t3);
                soundPool.play(soundPool.load(this,s3,1), 1,1,0,0,1);
                break;
            case R.id.cv_group_4:
                int i4 = rGenerator.nextInt(group4.length);
                int image4 = group4[i4];
                int s4 = sound4[i4];
                String t4 = text4[i4];
                ivGroup4.setImageResource(image4);
                tvGroup4.setText(t4);
                soundPool.play(soundPool.load(this,s4,1), 1,1,0,0,1);
                break;
            case R.id.cv_group_5:
                int i5 = rGenerator.nextInt(group5.length);
                int image5 = group5[i5];
                int s5 = sound5[i5];
                String t5 = text5[i5];
                ivGroup5.setImageResource(image5);
                tvGroup5.setText(t5);
                soundPool.play(soundPool.load(this,s5,1), 1,1,0,0,1);
                break;
            case R.id.cv_group_6:
                int i6 = rGenerator.nextInt(group6.length);
                int image6 = group6[i6];
                int s6 = sound6[i6];
                String t6 = text6[i6];
                ivGroup6.setImageResource(image6);
                tvGroup6.setText(t6);
                soundPool.play(soundPool.load(this,s6,1), 1,1,0,0,1);
                break;
        }
    }
}
