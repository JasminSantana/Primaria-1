package mx.edu.utng.primaria.activities.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.renderscript.Int2;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.CertificateActivity;
import mx.edu.utng.primaria.sqlite.DbHelper;

public class Test extends AppCompatActivity implements View.OnClickListener {
private RadioButton rbRed, rb15,rbGreen,rbFather,rbA,rbMother,rbDog,rbCircle,rbFive,rbSeven,rbThree;
    private CheckBox rbFootball,rbTennis,rbBasketball;
    private ImageButton btEm,btDog,btCircle;
    private Button btSend;
    private DbHelper db;
    private String idUser;
    private final static String SETTING_USER = "setting_user";
    private String user;
    SharedPreferences sharedPreferences;
    double scoreTest=0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        this.setTitle("Final Test");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        rbRed=(RadioButton)findViewById(R.id.rb_red);
        rb15=(RadioButton)findViewById(R.id.rb_15);
        rbGreen=(RadioButton)findViewById(R.id.rb_green);
        rbFather=(RadioButton)findViewById(R.id.rb_father);
        rbFootball=(CheckBox) findViewById(R.id.rb_football);
        rbTennis=(CheckBox) findViewById(R.id.rb_tennis);
        rbBasketball=(CheckBox) findViewById(R.id.rb_basketball);
        rbA=(RadioButton)findViewById(R.id.rb_letter_a);
        rbMother=(RadioButton)findViewById(R.id.rb_mother_mo);
        rbDog=(RadioButton)findViewById(R.id.rb_dog);
        rbCircle=(RadioButton)findViewById(R.id.rb_Circle);
        rbSeven=(RadioButton)findViewById(R.id.rb_seven);
        btEm = (ImageButton)findViewById(R.id.bt_em);
        btDog=(ImageButton) findViewById(R.id.bt_dog);
        btCircle=(ImageButton) findViewById(R.id.bt_circle);
        btSend=(Button)findViewById(R.id.bt_enviar);

        rbRed.setOnClickListener(this);
        rb15.setOnClickListener(this);
        rbGreen.setOnClickListener(this);
        rbFather.setOnClickListener(this);
        rbFootball.setOnClickListener(this);
        rbTennis.setOnClickListener(this);
        rbBasketball.setOnClickListener(this);
        rbA.setOnClickListener(this);
        rbMother.setOnClickListener(this);
        rbDog.setOnClickListener(this);
        rbCircle.setOnClickListener(this);

        rbSeven.setOnClickListener(this);
        btEm.setOnClickListener(this);
        btDog.setOnClickListener(this);
        btCircle.setOnClickListener(this);
        btSend.setOnClickListener(this);

        db = new DbHelper(this);
    }

    @Override
    public void onClick(View v) {

//PREGUNTAS DEL QUIZ
        //1
        if(rbRed.isChecked()){
            scoreTest=scoreTest+1;
        }//2
        if(rb15.isChecked()){
            scoreTest=scoreTest+1;
        //3
        }if(rbFather.isChecked()){
            scoreTest=scoreTest+1;
        }//4
        if(rbGreen.isChecked()){
            scoreTest=scoreTest+1;
        }
        //5
        if(rbFootball.isChecked()){
            scoreTest=scoreTest+0.5;
        }//5.1
        if(rbTennis.isChecked()){
            scoreTest=scoreTest+0.5;
        }//5.2
        if (rbBasketball.isChecked()){
            scoreTest=scoreTest+0.5;
        }//7
        if(rbA.isChecked()){
            scoreTest=scoreTest+1;
        }//8
        if(rbMother.isChecked()){
            scoreTest=scoreTest+1;
        } //9
       if(rbDog.isChecked()){
           scoreTest=scoreTest+0.5;
       }//10
        if(rbCircle.isChecked()){
            scoreTest=scoreTest+1;
        }//11
        if(rbSeven.isPressed()){
            scoreTest=scoreTest+1;
        }
        if(btDog.isPressed()){
            MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
            mp.start();
            Toast  toast =Toast.makeText(this,"Dog",Toast.LENGTH_SHORT);
            toast.show();
        }if(btCircle.isPressed()){
            MediaPlayer mp = MediaPlayer.create(this, R.raw.circle);
            mp.start();
        }
        if(btEm.isPressed()){
           MediaPlayer mp = MediaPlayer.create(this, R.raw.lettera);
            mp.start();
        }
        if(btSend.isPressed()){
            sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
            user = sharedPreferences.getString(SETTING_USER,"");
            idUser = db.getIdUser(user);
            Log.i("el id del usuario es ", idUser);
            String data = db.getScore(idUser, 8);
            if(data!=null){
                db.updateScore(idUser,8,String.valueOf(scoreTest));
            }else{
                db.addScore(String.valueOf(scoreTest),idUser,8);
            }
            if(scoreTest>=8){
                        final AlertDialog.Builder builder = new AlertDialog.Builder(Test.this);
                        builder.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ F E L I C I D A D E S ! </b></font>"))
                                .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                                .setMessage("HAS CONCLUIDO TODAS LAS ACTIVIDADES Y PASADO EL TEST FINAL," +
                                        " AHORA PUEDES OBTENER UN PEQUEÑO DIPLOMA O CERTIFICADO.")
                                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        startActivity(new Intent(getApplicationContext(),CertificateActivity.class));
                                    }
                                });
                        builder.show();
            }else{
                        final AlertDialog.Builder builderFather = new AlertDialog.Builder(Test.this);
                        builderFather.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ I N C O R R E C T O ! </b></font>"))
                                .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                                .setMessage("LO SENTIMOS, PARA PODER PASAR ESTE TEST TIENES QUE " +
                                        "OBTENER UNA CALIFICACION MAYOR Ó IGUAL A 8, TU CALIFICACIÓN " +
                                        "ACTUAL ES: ")
                                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        builderFather.show();
            }
            }

        }

    }

