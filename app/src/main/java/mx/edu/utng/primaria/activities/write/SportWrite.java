package mx.edu.utng.primaria.activities.write;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.primaria.R;

public class SportWrite extends AppCompatActivity implements View.OnClickListener{

    private TextView tvSoccer;
    private TextView tvTennis;
    private TextView tvBaseball;
    private TextView tvGolf;
    private TextView tvBasketball;
    private TextView tvSwimming;
    private TextView tvVoleiball;
    private EditText etSoccer;
    private EditText etTennis;
    private EditText etBaseball;
    private EditText etGolf;
    private EditText etBasketball;
    private EditText etSwimming;
    private EditText etVoleiball;
    private Button btSoccer;
    private Button btTennis;
    private Button btBaseball;
    private Button btGolf;
    private Button btBasketball;
    private Button btSwimming;
    private Button btVoleiball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_write);
        this.setTitle("Sport Writing");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tvSoccer=(TextView)findViewById(R.id.tv_question_soccer);
        tvTennis=(TextView)findViewById(R.id.tv_question_tennis);
        tvBaseball=(TextView)findViewById(R.id.tv_question_baseball);
        tvGolf=(TextView)findViewById(R.id.tv_question_golf);
        tvBasketball=(TextView)findViewById(R.id.tv_question_basketball);
        tvSwimming=(TextView)findViewById(R.id.tv_question_swimming);
        tvVoleiball=(TextView)findViewById(R.id.tv_question_voleibal);

        etSoccer=(EditText)findViewById(R.id.et_soccer);
        etTennis=(EditText)findViewById(R.id.et_tennis);
        etBaseball=(EditText)findViewById(R.id.et_baseball);
        etGolf=(EditText)findViewById(R.id.et_golf);
        etBasketball=(EditText)findViewById(R.id.et_basketball);
        etSwimming=(EditText)findViewById(R.id.et_swimming);
        etVoleiball=(EditText)findViewById(R.id.et_voleiball);

        btSoccer=(Button)findViewById(R.id.bt_soccer);
        btTennis=(Button)findViewById(R.id.bt_tennis);
        btBaseball=(Button)findViewById(R.id.bt_baseball);
        btGolf=(Button)findViewById(R.id.bt_golf);
        btBasketball=(Button)findViewById(R.id.bt_basketball);
        btSwimming=(Button)findViewById(R.id.bt_swimming);
        btVoleiball=(Button)findViewById(R.id.bt_voleiball);

        btSoccer.setOnClickListener(this);
        btTennis.setOnClickListener(this);
        btBaseball.setOnClickListener(this);
        btGolf.setOnClickListener(this);
        btBasketball.setOnClickListener(this);
        btSwimming.setOnClickListener(this);
        btVoleiball.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String soccer=etSoccer.getText().toString();
        String tennis=etTennis.getText().toString();
        String baseball=etBaseball.getText().toString();
        String golf=etGolf.getText().toString();
        String basketball=etBasketball.getText().toString();
        String swimming=etSwimming.getText().toString();
        String voleiball=etVoleiball.getText().toString();

        switch (v.getId()) {
            case R.id.bt_soccer:
                if (soccer.equalsIgnoreCase("soccer")) {
                    tvSoccer.setText("S O C C E R");
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_tennis:
                if(tennis.equalsIgnoreCase("tennis")){
                    tvTennis.setText("T E N N I S");
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case  R.id.bt_baseball:
                if(baseball.equalsIgnoreCase("baseball")){
                    tvBaseball.setText("B A S E B A L L");
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_golf:
                if(golf.equalsIgnoreCase("golf")){
                    tvGolf.setText("G O L F");
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_basketball:
                if(basketball.equalsIgnoreCase("basketball")){
                    tvBasketball.setText("B A S K T B A L L");
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_swimming:
                if(swimming.equalsIgnoreCase("swimming")){
                    tvSwimming.setText("S W I M M I N G");
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_voleiball:
                if(voleiball.equalsIgnoreCase("voleyball")){
                    tvVoleiball.setText("V O L E Y B A L L");
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
        }


    }
}
