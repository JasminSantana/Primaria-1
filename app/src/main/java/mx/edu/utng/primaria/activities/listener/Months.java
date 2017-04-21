package mx.edu.utng.primaria.activities.listener;

import mx.edu.utng.primaria.R;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Months extends AppCompatActivity implements View.OnClickListener{
    private TextView tvOption1;
    private TextView tvOption2;
    private TextView tvOption3;
    private ImageView ivMonth;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        this.setTitle("Months");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tvOption1=(TextView)findViewById(R.id.tv_option_uno);
        tvOption2=(TextView)findViewById(R.id.tv_option_dos);
        tvOption3=(TextView)findViewById(R.id.tv_option_tres);

        ivMonth=(ImageView) findViewById(R.id.iv_month);
        tvOption1.setOnClickListener(this);
        tvOption2.setOnClickListener(this);
        tvOption3.setOnClickListener(this);
        //imagenes
        ivMonth.setOnClickListener(this);

        mediaPlayer=new MediaPlayer();

    }//

    private void playMedia(){
        Thread playThred=new Thread(){
            @Override
            public void run() {
                mediaPlayer=MediaPlayer.create(Months.this,R.raw.july);
                mediaPlayer.start();
            }
        };
        playThred.start();
    }

    private void stopMedia(){
        mediaPlayer.stop();
    }


    @Override
    public void onClick(View v) {
        if (tvOption1.isPressed()){
            tvOption1.setBackgroundColor(Color.GREEN);
            Toast.makeText(this," :) Is correct!!",Toast.LENGTH_SHORT).show();

            playMedia();
            Intent intent=new Intent(Months.this,April.class);
            startActivity(intent);
            stopMedia();

/*
            //cambia los datos mes de abril
            ivMonth.setImageResource(R.drawable.april);

            tvOption1.setText("November");
            tvOption1.setBackgroundColor(Color.BLUE);
            tvOption2.setText("April");
            tvOption2.setBackgroundColor(Color.BLUE);
            tvOption3.setText("January");
            tvOption3.setBackgroundColor(Color.BLUE);

            if (tvOption1.isPressed()){
                tvOption1.setBackgroundColor(Color.RED);
                Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();

            }else if (tvOption2.isPressed()){
                tvOption2.setBackgroundColor(Color.GREEN);
                Toast.makeText(this," :) Is correct!!",Toast.LENGTH_SHORT).show();


            }else if (tvOption3.isPressed()){
                tvOption3.setBackgroundColor(Color.RED);
                Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
            }//mes de abril

*/

        }else   if (tvOption2.isPressed()){
            tvOption2.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
        }else if (tvOption3.isPressed()){
            tvOption3.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
        }





    }
}
