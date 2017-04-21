package mx.edu.utng.primaria.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.login.LoginActivity;
import mx.edu.utng.primaria.login.Session;
import mx.edu.utng.primaria.menu.MainActivity;

/**
 * Created by Santana on 2/25/2017.
 */

public class AboutActivity  extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer mediaPlayer;
    private int seek;
    private ImageView ivLogo;
    private TextView tvPablo;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.setTitle("About");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvPablo=(TextView)findViewById(R.id.tv_pablo);
        tvPablo.setOnClickListener(this);
        ivLogo=(ImageView)findViewById(R.id.iv_logo_about);
        //ivLogo.setOnClickListener(this);

        session = new Session(this);

        if(!session.loggedin()){
            logout();
        }

    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(AboutActivity.this,MainActivity.class));
    }

    protected void onResume(){
        super.onResume();
        reproducir();

    }
    protected void reproducir(){
        if(mediaPlayer != null)
            mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(this,R.raw.fondojas);
        mediaPlayer.seekTo(seek);
        mediaPlayer.start();

    }
    protected void onPause(){
        super.onPause();
        if(mediaPlayer != null)
            seek=mediaPlayer.getCurrentPosition();
        mediaPlayer.release();
        mediaPlayer= null;
        finish();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_pablo:
                Toast toast =Toast.makeText(this,"soy etiqueta",Toast.LENGTH_SHORT);
                toast.show();
                Animation giro;
                giro= AnimationUtils.loadAnimation(this,R.anim.girar);
                giro.reset();
                ivLogo.startAnimation(giro);
                break;
        }
    }
}
