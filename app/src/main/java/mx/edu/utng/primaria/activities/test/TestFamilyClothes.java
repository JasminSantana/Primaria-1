package mx.edu.utng.primaria.activities.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.menu.MainActivity;
import mx.edu.utng.primaria.sqlite.DbHelper;

public class TestFamilyClothes extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbBelt;
    private RadioButton rbHat;
    private RadioButton rbShorts;
    private RadioButton rbSocks;
    private RadioButton rbSweater;
    private EditText etMother;
    private EditText etFaher;
    private EditText etAunt;
    private EditText etGrandFather;
    private EditText etSister;
    private ImageView ivSendAC;
    private DbHelper db;
    private String idUser;
    private final static String SETTING_USER = "setting_user";
    private String user;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_family_clothes);
        this.setTitle("Test Family and Clothes");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        rbBelt = (RadioButton)findViewById(R.id.rb_belt);
        rbHat = (RadioButton)findViewById(R.id.rb_hat);
        rbShorts = (RadioButton)findViewById(R.id.rb_shorts);
        rbSocks = (RadioButton)findViewById(R.id.rb_socks);
        rbSweater = (RadioButton)findViewById(R.id.rb_sweater);
        etMother =(EditText)findViewById(R.id.et_mother_t);
        etFaher =(EditText)findViewById(R.id.et_family_father);
        etAunt =(EditText)findViewById(R.id.et_family_aunt);
        etGrandFather =(EditText)findViewById(R.id.et_family_grandfather);
        etSister =(EditText)findViewById(R.id.et_family_sister);
        ivSendAC =(ImageView) findViewById(R.id.iv_send_ac);

        etMother.getText().toString();
        etFaher.getText().toString();
        etAunt.getText().toString();
        etGrandFather.getText().toString();
        etSister.getText().toString();

        rbBelt.setOnClickListener(this);
        rbHat.setOnClickListener(this);
        rbShorts.setOnClickListener(this);
        rbSocks.setOnClickListener(this);
        rbSweater.setOnClickListener(this);
        etMother.setOnClickListener(this);
        etFaher.setOnClickListener(this);
        etAunt.setOnClickListener(this);
        etGrandFather.setOnClickListener(this);
        etSister.setOnClickListener(this);
        ivSendAC.setOnClickListener(this);

        db = new DbHelper(this);
    }

    @Override
    public void onClick(View v) {
        int scoreTest = 0;
        String mother = etMother.getText().toString();
        String father = etFaher.getText().toString();
        String aunt = etAunt.getText().toString();
        String grandFather = etGrandFather.getText().toString();
        String sister =  etSister.getText().toString();

        if(rbBelt.isChecked()){
            scoreTest = scoreTest + 1;
        }
        if(rbHat.isChecked()){
            scoreTest = scoreTest + 1;
        }
        if(rbSocks.isChecked()){
            scoreTest=scoreTest+1;
        }
        if(rbSweater.isChecked()){
            scoreTest=scoreTest+1;
        }
        if(rbShorts.isChecked()){
            scoreTest = scoreTest + 1;
        }
        if(mother.equalsIgnoreCase("MOTHER")){
            scoreTest = scoreTest + 1;
        }
        if(father.equalsIgnoreCase("FATHER")){
            scoreTest = scoreTest + 1;
        }
        if(aunt.equalsIgnoreCase("AUNT")){
            scoreTest=scoreTest+1;
        }
        if(grandFather.equalsIgnoreCase("GRANDFATHER")){
            scoreTest=scoreTest+1;
        }
        if(sister.equalsIgnoreCase("SISTER")){
            scoreTest=scoreTest+1;
        }

        int scoreFinal = scoreTest;
        if(ivSendAC.isPressed()){
            sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
            user = sharedPreferences.getString(SETTING_USER,"");
            idUser = db.getIdUser(user);
            Log.i("el id del usuario es ", idUser);
            String data = db.getScore(idUser, 3);
            if(data!=null){
                db.updateScore(idUser,3,String.valueOf(scoreTest));
            }else{
                db.addScore(String.valueOf(scoreTest),idUser,3);
            }
            if (scoreTest>=8) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestFamilyClothes.this);
                builder.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ F E L I C I D A D E S ! </b></font>"))
                        .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                        .setMessage("HAS CONCLUIDO LA ACTIVIDAD FAMILY AND CLOTHES," +
                                " AHORA PUEDES SEGUIR CON LA SIGUIENTE ACTIVIDAD:" +
                                Html.fromHtml("<b>GEOMETRIC FIGURES AND SPORTS.</b>"))
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
                builder.show();
            }else{
                final AlertDialog.Builder builderFather = new AlertDialog.Builder(TestFamilyClothes.this);
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
