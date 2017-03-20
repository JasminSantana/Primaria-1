package mx.edu.utng.primaria.activities.test;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import mx.edu.utng.primaria.R;

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
        rbSeven=(RadioButton)findViewById(R.id.rb_seven);
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
        if (btEnviar.isPressed()){
            Toast toast =Toast.makeText(this,"Enviar "+scoreTest,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
