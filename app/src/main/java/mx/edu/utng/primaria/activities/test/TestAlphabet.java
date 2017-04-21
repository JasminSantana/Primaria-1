package mx.edu.utng.primaria.activities.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
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
import mx.edu.utng.primaria.menu.MainActivity;
import mx.edu.utng.primaria.sqlite.DbHelper;

public class TestAlphabet extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbGii;
    private RadioButton rbEm;
    private RadioButton rbBi;
    private  RadioButton rbZi;
    private RadioButton rbLetterP;
    private ImageButton btPi;
    private RadioButton rbFive;
    private RadioButton rbFour;
    private RadioButton rbSix;
    private  RadioButton rbSeven;
    private RadioButton rbOne;
    private Button btEnviar;
    private DbHelper db;
    private String idUser;
    private final static String SETTING_USER = "setting_user";
    private String user;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_alphabet);
        this.setTitle("Test Alphabet and numbers");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        rbGii=(RadioButton)findViewById(R.id.rb_gii);
        rbEm=(RadioButton)findViewById(R.id.rb_em);
        rbBi=(RadioButton)findViewById(R.id.rb_bi);
        rbZi=(RadioButton)findViewById(R.id.rb_zi);
        rbFive=(RadioButton)findViewById(R.id.rb_number_five);
        rbFour=(RadioButton)findViewById(R.id.rb_number_four);
        rbSix=(RadioButton)findViewById(R.id.rb_number_six);
        rbSeven=(RadioButton)findViewById(R.id.rb_number_seven);
        rbOne=(RadioButton)findViewById(R.id.rb_number_one);
        rbLetterP=(RadioButton)findViewById(R.id.rb_letter_p);
        btPi=(ImageButton)findViewById(R.id.bt_pi);

        btEnviar=(Button)findViewById(R.id.bt_enviar);

        rbGii.setOnClickListener(this);
        rbEm.setOnClickListener(this);
        rbBi.setOnClickListener(this);
        rbZi.setOnClickListener(this);
        rbLetterP.setOnClickListener(this);

        rbFive.setOnClickListener(this);
        rbFour.setOnClickListener(this);
        rbSix.setOnClickListener(this);
        rbSeven.setOnClickListener(this);
        rbOne.setOnClickListener(this);
        btPi.setOnClickListener(this);

        btEnviar.setOnClickListener(this);

        db = new DbHelper(this);


    }

    @Override
    public void onClick(View v) {
        double
         scoreTest=0.0;
        if(rbGii.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbEm.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbBi.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbZi.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbLetterP.isChecked()){
            scoreTest=scoreTest+1;
        }if (btPi.isPressed()){
            MediaPlayer mp = MediaPlayer.create(this, R.raw.letterp);
            mp.start();
        }
        if(rbFive.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbFour.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbSix.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbSeven.isChecked()){
            scoreTest=scoreTest+1;
        }if (rbOne.isChecked()){
            scoreTest=scoreTest+1;
        }
        //query para la base de datos
        Double scoreFinal = scoreTest;
        if (btEnviar.isPressed()){
            sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
            user = sharedPreferences.getString(SETTING_USER,"");
             idUser = db.getIdUser(user);
            Log.i("el id del usuario es: ", idUser);
            String data = db.getScore(idUser, 1);
            if(data!=null){
                db.updateScore(idUser,1,String.valueOf(scoreTest));
            }else{
                db.addScore(String.valueOf(scoreTest),idUser,1);
            }
            //Toast.makeText(this, "el email es: "+ user + "el usuario es: "+idUser, Toast.LENGTH_SHORT).show();
            if (scoreTest>=8) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestAlphabet.this);
                builder.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ F E L I C I D A D E S ! </b></font>"))
                        .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                        .setMessage("HAS CONCLUIDO LA ACTIVIDAD ALPHABET AND COLORS," +
                                " AHORA PUEDES SEGUIR CON LA SIGUIENTE ACTIVIDAD:" +
                                Html.fromHtml("<b>ANIMALS AND COLORS.</b>"))
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
                builder.show();
            }else{
                final AlertDialog.Builder builderFather = new AlertDialog.Builder(TestAlphabet.this);
                builderFather.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ I N C O R R E C T O ! </b></font>"))
                        .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                        .setMessage("LO SENTIMOS, PARA PODER PASAR ESTE TEST TIENES QUE " +
                                "OBTENER UNA CALIFICACION MAYOR Ó IGUAL A 8, TU CALIFICACIÓN " +
                                "ACTUAL ES: " + scoreFinal)
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
