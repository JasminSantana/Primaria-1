package mx.edu.utng.primaria.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.primaria.R;


public class Sport extends AppCompatActivity implements View.OnClickListener{
    ImageView ivSport;
    ImageButton ivListenSport;
    TextView tvNameSport;
    Button anterior;
    Button siguiente;
    private SoundPool soundPool;

    int[] imagenId = {R.drawable.baseball,R.drawable.basketball,R.drawable.soccer,R.drawable.golf,R.drawable.swimming,R.drawable.tennise,R.drawable.voleiball};
    String[] names = {"Baseball", "Basketball", "Soccer", "Golf","Swimming","Tennis","Voleiball"};
    //int[] musica = {R.raw.circle,R.raw.eigth,R.raw.letterb,R.raw.letteru};
    int i = 0;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivListenSport=(ImageButton)findViewById(R.id.iv_sports_listen);
        anterior = (Button) findViewById(R.id.bt_anterior);
        siguiente = (Button) findViewById(R.id.bt_siguiente);
        tvNameSport = (TextView) findViewById(R.id.tv_name_sport);
        ivSport = (ImageView) findViewById(R.id.iv_sports);

        anterior.setOnClickListener(this);
        siguiente.setOnClickListener(this);

        ivListenSport.setOnClickListener(this);

        total = imagenId.length;

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.bt_siguiente) {
            i++;
            //total =4 o7 hasta horita
            if(i == total){
                i = 0;
            }

        }

        if(id == R.id.bt_anterior) {
            i--;
            if(i == -1){
                i = total -1;
            }
        }
        //cambia de imagen segun la posicion
        ivSport.setImageResource(imagenId[i]);
        //cambia el nombre segun la posicion de la imagen
        tvNameSport.setText(names[i]);

        if(ivListenSport.isPressed()){
            if(i==1){
                soundPool.play(soundPool.load(this,R.raw.basebol,1), 1,1,0,0,1);
                Toast toast =Toast.makeText(getApplicationContext(),"Basketball 1 "+i,Toast.LENGTH_SHORT);
                toast.show();


            }
            if(i==2){
                soundPool.play(soundPool.load(this,R.raw.basketball,1), 1,1,0,0,1);


                Toast toast =Toast.makeText(getApplicationContext(),"Soccer 2 "+i,Toast.LENGTH_SHORT);
                toast.show();

            }
            if(i==3){
                soundPool.play(soundPool.load(this,R.raw.soccer,1), 1,1,0,0,1);


                Toast toast =Toast.makeText(getApplicationContext(),"Golf 3 "+i,Toast.LENGTH_SHORT);
                toast.show();

            }
            if(i==4){
                soundPool.play(soundPool.load(this,R.raw.golf,1), 1,1,0,0,1);


                Toast toast =Toast.makeText(getApplicationContext(),"Swiming 4 "+i,Toast.LENGTH_SHORT);
                toast.show();

            }
            if(i==5){
                soundPool.play(soundPool.load(this,R.raw.swimming,1), 1,1,0,0,1);



                Toast toast =Toast.makeText(getApplicationContext(),"Tennis 5 "+i,Toast.LENGTH_SHORT);
                toast.show();

            }
            if(i==6){
                soundPool.play(soundPool.load(this,R.raw.tenis,1), 1,1,0,0,1);

                Toast toast =Toast.makeText(getApplicationContext(),"Voleiball 6 "+i,Toast.LENGTH_SHORT);
                toast.show();

            }
            if(i==0){
                soundPool.play(soundPool.load(this,R.raw.voleibol,1), 1,1,0,0,1);


                Toast toast =Toast.makeText(getApplicationContext(),"Basebol 7 "+i,Toast.LENGTH_SHORT);
                toast.show();

            }
        }

    }
}
