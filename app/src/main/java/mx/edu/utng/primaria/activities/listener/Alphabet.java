package mx.edu.utng.primaria.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import mx.edu.utng.primaria.R;


/**
 * Created by Santana on 1/21/2017.
 */
public class Alphabet extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibA;
    private ImageButton ibB;
    private ImageButton ibC;
    private ImageButton ibD;
    private ImageButton ibE;
    private ImageButton ibF;
    private ImageButton ibG;
    private ImageButton ibH;
    private ImageButton ibI;
    private ImageButton ibJ;
    private ImageButton ibK;
    private ImageButton ibL;
    private ImageButton ibM;
    private ImageButton ibN;
    private ImageButton ibO;
    private ImageButton ibP;
    private ImageButton ibQ;
    private ImageButton ibR;
    private ImageButton ibS;
    private ImageButton ibT;
    private ImageButton ibU;
    private ImageButton ibV;
    private ImageButton ibW;
    private ImageButton ibX;
    private ImageButton ibY;
    private ImageButton ibZ;
    private SoundPool soundPool;
    private int loader;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.alphabet);
        //regreso al menu
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //sound
        soundPool=new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        //relacion de elementos de la vista
      ibA =(ImageButton)findViewById(R.id.ib_a);
        ibB =(ImageButton)findViewById(R.id.ib_b);
        ibC =(ImageButton)findViewById(R.id.ib_c);
        ibD =(ImageButton)findViewById(R.id.ib_d);
        ibE =(ImageButton)findViewById(R.id.ib_e);
        ibF =(ImageButton)findViewById(R.id.ib_f);
        ibG =(ImageButton)findViewById(R.id.ib_g);
        ibH =(ImageButton)findViewById(R.id.ib_h);
        ibI =(ImageButton)findViewById(R.id.ib_i);
        ibJ =(ImageButton)findViewById(R.id.ib_j);
        ibK =(ImageButton)findViewById(R.id.ib_k);
        ibL =(ImageButton)findViewById(R.id.ib_l);
        ibM =(ImageButton)findViewById(R.id.ib_m);
        ibN =(ImageButton)findViewById(R.id.ib_n);
        ibO =(ImageButton)findViewById(R.id.ib_o);
        ibP =(ImageButton)findViewById(R.id.ib_p);
        ibQ =(ImageButton)findViewById(R.id.ib_q);
        ibR =(ImageButton)findViewById(R.id.ib_r);
        ibS =(ImageButton)findViewById(R.id.ib_s);
        ibT =(ImageButton)findViewById(R.id.ib_t);
        ibU =(ImageButton)findViewById(R.id.ib_u);
        ibV =(ImageButton)findViewById(R.id.ib_v);
        ibW =(ImageButton)findViewById(R.id.ib_w);
        ibX =(ImageButton)findViewById(R.id.ib_x);
        ibY =(ImageButton)findViewById(R.id.ib_y);
        ibZ=(ImageButton)findViewById(R.id.ib_z);
    //eschudaror para cada letra
        ibA.setOnClickListener(this);
        ibB.setOnClickListener(this);
        ibC.setOnClickListener(this);
        ibD.setOnClickListener(this);
        ibE.setOnClickListener(this);
        ibF.setOnClickListener(this);
        ibG.setOnClickListener(this);
        ibH.setOnClickListener(this);
        ibI.setOnClickListener(this);
        ibJ.setOnClickListener(this);
        ibK.setOnClickListener(this);
        ibL.setOnClickListener(this);
        ibM.setOnClickListener(this);
        ibN.setOnClickListener(this);
        ibO.setOnClickListener(this);
        ibP.setOnClickListener(this);
        ibQ.setOnClickListener(this);
        ibR.setOnClickListener(this);
        ibS.setOnClickListener(this);
        ibT.setOnClickListener(this);
        ibU.setOnClickListener(this);
        ibW.setOnClickListener(this);
        ibX.setOnClickListener(this);
        ibY.setOnClickListener(this);
        ibZ.setOnClickListener(this);
        ibV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//reproduccion de sonido para cada boton presionado
        switch (v.getId()){
            case (R.id.ib_a):
                soundPool.play(soundPool.load(this,R.raw.lettera,1),1,1,0,0,1);
                break;
            case (R.id.ib_b):
                soundPool.play(soundPool.load(this,R.raw.letterb,1),1,1,0,0,1);
                break;
            case (R.id.ib_c):
                soundPool.play(soundPool.load(this,R.raw.letterc,1),1,1,0,0,1);
                break;
            case (R.id.ib_d):
                soundPool.play(soundPool.load(this,R.raw.letterd,1),1,1,0,0,1);
                break;
            case (R.id.ib_e):
                soundPool.play(soundPool.load(this,R.raw.lettere,1),1,1,0,0,1);
                break;
            case (R.id.ib_f):
                soundPool.play(soundPool.load(this,R.raw.letterf,1),1,1,0,0,1);
                break;
            case (R.id.ib_g):
                soundPool.play(soundPool.load(this,R.raw.letterg,1),1,1,0,0,1);
                break;
            case (R.id.ib_h):
                soundPool.play(soundPool.load(this,R.raw.letterh,1),1,1,0,0,1);
                break;
            case (R.id.ib_i):
                soundPool.play(soundPool.load(this,R.raw.letteri,1),1,1,0,0,1);
                break;
            case (R.id.ib_j):
                soundPool.play(soundPool.load(this,R.raw.letterj,1),1,1,0,0,1);
                break;
            case (R.id.ib_k):
                soundPool.play(soundPool.load(this,R.raw.letterk,1),1,1,0,0,1);
                break;
            case (R.id.ib_l):
                soundPool.play(soundPool.load(this,R.raw.letterl,1),1,1,0,0,1);
                break;
            case (R.id.ib_m):
                soundPool.play(soundPool.load(this,R.raw.letterm,1),1,1,0,0,1);
                break;
            case (R.id.ib_n):
                soundPool.play(soundPool.load(this,R.raw.lettern,1),1,1,0,0,1);
                break;
            case (R.id.ib_o):
                soundPool.play(soundPool.load(this,R.raw.lettero,1),1,1,0,0,1);
                break;
            case (R.id.ib_p):
                soundPool.play(soundPool.load(this,R.raw.letterp,1),1,1,0,0,1);
                break;
            case (R.id.ib_q):
                soundPool.play(soundPool.load(this,R.raw.letterq,1),1,1,0,0,1);
                break;
            case (R.id.ib_r):
                soundPool.play(soundPool.load(this,R.raw.letterr,1),1,1,0,0,1);
                break;
            case (R.id.ib_s):
                soundPool.play(soundPool.load(this,R.raw.letters,1),1,1,0,0,1);
                break;
            case (R.id.ib_t):
                soundPool.play(soundPool.load(this,R.raw.lettert,1),1,1,0,0,1);
                break;
            case (R.id.ib_u):
                soundPool.play(soundPool.load(this,R.raw.letteru,1),1,1,0,0,1);
                break;
            case (R.id.ib_v):
                soundPool.play(soundPool.load(this,R.raw.letterv,1),1,1,0,0,1);
                break;
            case (R.id.ib_w):
                soundPool.play(soundPool.load(this,R.raw.letterw,1),1,1,0,0,1);
                break;
            case (R.id.ib_x):
                soundPool.play(soundPool.load(this,R.raw.letterx,1),1,1,0,0,1);
                break;
            case (R.id.ib_y):
                soundPool.play(soundPool.load(this,R.raw.lettery,1),1,1,0,0,1);
                break;
            case (R.id.ib_z):
                soundPool.play(soundPool.load(this,R.raw.letterz,1),1,1,0,0,1);
                break;

        }
    }
}
