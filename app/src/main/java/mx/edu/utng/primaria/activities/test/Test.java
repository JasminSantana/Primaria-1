package mx.edu.utng.primaria.activities.test;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.CertificateActivity;

public class Test extends AppCompatActivity implements View.OnClickListener {
private RadioButton rbRed, rb15,rbGreen,rbFather,rbA,rbMother,rbDog,rbCircle,rbFive,rbSeven,rbThree;
    private CheckBox rbFootball,rbTennis,rbBasketball;
    private ImageButton btEm,btDog,btCircle;
    private Button btSend;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

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

      /* btEm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=getApplicationContext();
                Toast toast;
                CharSequence charSequence;
                String text;
                int duration=Toast.LENGTH_SHORT;
                charSequence="Button c2 clicked!";

                toast =Toast.makeText(context,charSequence,duration);
                toast.show();
            }
        });
*/
    }

    @Override
    public void onClick(View v) {
        double scoreTest=0;
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
            Toast  toast =Toast.makeText(this,"Enviar "+scoreTest,Toast.LENGTH_SHORT);
            toast.show();
            if(scoreTest>=8){
                startActivity(new Intent(this,CertificateActivity.class));
            }

        }

    }


}
