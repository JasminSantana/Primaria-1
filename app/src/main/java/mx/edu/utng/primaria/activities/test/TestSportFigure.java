package mx.edu.utng.primaria.activities.test;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import mx.edu.utng.primaria.R;

public class TestSportFigure extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbSoccer;
    private RadioButton rbTennis;
    private RadioButton rbGolf;
    private RadioButton rbBasketball;
    private RadioButton rbSportVoleyball;
    private ImageButton btVoleyball;
    private RadioButton rbHexagon;
    private RadioButton rbTriangle;
    private RadioButton rbSquare;
    private RadioButton rbStar;
    private RadioButton rbRectangle;
    private ImageButton btRectangle;

    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sport_figure);

        rbSoccer=(RadioButton)findViewById(R.id.rb_soccer);
        rbTennis=(RadioButton)findViewById(R.id.rb_tennis);
        rbGolf=(RadioButton)findViewById(R.id.rb_golf);
        rbBasketball=(RadioButton)findViewById(R.id.rb_basketball_sport);
        rbSportVoleyball=(RadioButton)findViewById(R.id.rb_sport_voly);
        btVoleyball=(ImageButton)findViewById(R.id.bt_voleyball_listen);

        rbHexagon=(RadioButton)findViewById(R.id.rb_hexagon);
        rbTriangle=(RadioButton)findViewById(R.id.rb_triangle);
        rbSquare=(RadioButton)findViewById(R.id.rb_square);
        rbStar=(RadioButton)findViewById(R.id.rb_start);
        rbRectangle=(RadioButton)findViewById(R.id.rb_rectangle);
        btRectangle=(ImageButton)findViewById(R.id.bt_rectangle_listen);

        btEnviar=(Button)findViewById(R.id.bt_finish_fs);
    }

    @Override
    public void onClick(View v) {
        double scoreTest=0.0;
        if (rbSoccer.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbTennis.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbGolf.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbBasketball.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbSportVoleyball.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (btVoleyball.isPressed()){
            MediaPlayer mp = MediaPlayer.create(this, R.raw.voleibol);
            mp.start();
            mp.stop();
        }
        if (rbHexagon.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbTriangle.isChecked()){
            scoreTest=scoreTest+1;
        } if (rbSquare.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbStar.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbRectangle.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (btRectangle.isPressed()){
            MediaPlayer mp = MediaPlayer.create(this, R.raw.circle);
            mp.start();
            mp.stop();
        }

        if (btEnviar.isPressed()){

            AlertDialog.Builder builder = new AlertDialog.Builder(TestSportFigure.this);
            builder.setMessage("Your Scores."+scoreTest)
                    .setTitle("Finish Test Sports and Figures").setIcon(R.drawable.logo)
                    .setNegativeButton("To accept", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            builder.show();
        }
    }
}
