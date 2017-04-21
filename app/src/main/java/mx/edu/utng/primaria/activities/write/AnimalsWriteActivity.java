package mx.edu.utng.primaria.activities.write;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.primaria.R;

public class AnimalsWriteActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvRabbit;
    private TextView tvBee;
    private TextView tvSheep;
    private TextView tvButherfly;
    private TextView tvCat;
    private TextView tvDog;
    private TextView tvHorse;
    private TextView tvPig;
    private TextView tvLion;
    private TextView tvMonkey;
    private TextView tvSnail;

    private EditText etRabbit;
    private EditText etBee;
    private EditText etSheep;
    private EditText etButherfly;
    private EditText etCat;
    private EditText etDog;
    private EditText etHorse;
    private EditText etPig;
    private EditText etLion;
    private EditText etMonkey;
    private EditText etSnail;
    private Button btRabbit;
    private Button btBee;
    private Button btSheep;
    private Button btButherfly;
    private Button btCat;
    private Button btDog;
    private Button btHorse;
    private Button btPig;
    private Button btLion;
    private Button btMonkey;
    private Button btSnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_write);
        this.setTitle("Animals Writing");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvRabbit = (TextView) findViewById(R.id.tv_question_rabbit);
        tvBee = (TextView) findViewById(R.id.tv_question_bee);
        tvSheep = (TextView) findViewById(R.id.tv_question_sheep);
        tvButherfly = (TextView) findViewById(R.id.tv_question_butherfly);
        tvCat = (TextView) findViewById(R.id.tv_question_cat);
        tvDog = (TextView) findViewById(R.id.tv_question_dog);
        tvHorse = (TextView) findViewById(R.id.tv_question_horse);
        tvPig = (TextView) findViewById(R.id.tv_question_pig);
        tvLion = (TextView) findViewById(R.id.tv_question_lion);
        tvMonkey = (TextView) findViewById(R.id.tv_question_monkey);
        tvSnail = (TextView) findViewById(R.id.tv_question_snail);

        etRabbit = (EditText) findViewById(R.id.et_rabbit);
        etBee = (EditText) findViewById(R.id.et_bee);
        etSheep = (EditText) findViewById(R.id.et_sheep);
        etButherfly = (EditText) findViewById(R.id.et_butherfly);
        etCat = (EditText) findViewById(R.id.et_cat);
        etDog = (EditText) findViewById(R.id.et_dog);
        etHorse = (EditText) findViewById(R.id.et_horse);
        etPig = (EditText) findViewById(R.id.et_pig);
        etLion = (EditText) findViewById(R.id.et_lion);
        etMonkey = (EditText) findViewById(R.id.et_monkey);
        etSnail = (EditText) findViewById(R.id.et_snail);


        btRabbit = (Button) findViewById(R.id.bt_rabbit);
        btBee = (Button) findViewById(R.id.bt_bee);
        btSheep = (Button) findViewById(R.id.bt_sheep);
        btButherfly = (Button) findViewById(R.id.bt_butherfly);
        btCat = (Button) findViewById(R.id.bt_cat);
        btDog = (Button) findViewById(R.id.bt_dog);
        btHorse = (Button) findViewById(R.id.bt_horse);
        btPig = (Button) findViewById(R.id.bt_pig);
        btLion = (Button) findViewById(R.id.bt_lion);
        btMonkey = (Button) findViewById(R.id.bt_monkey);
        btSnail = (Button) findViewById(R.id.bt_snail);


        btRabbit.setOnClickListener(this);
        btBee.setOnClickListener(this);
        btSheep.setOnClickListener(this);
        btButherfly.setOnClickListener(this);
        btCat.setOnClickListener(this);
        btDog.setOnClickListener(this);
        btHorse.setOnClickListener(this);
        btPig.setOnClickListener(this);
        btLion.setOnClickListener(this);
        btMonkey.setOnClickListener(this);
        btSnail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String rabbit = etRabbit.getText().toString();
        String bee = etBee.getText().toString();
        String sheep = etSheep.getText().toString();
        String butherfly = etButherfly.getText().toString();
        String cat = etCat.getText().toString();
        String dog = etDog.getText().toString();
        String horse = etHorse.getText().toString();
        String pig = etPig.getText().toString();
        String lion = etLion.getText().toString();
        String monkey = etMonkey.getText().toString();
        String snail = etSnail.getText().toString();

        switch (v.getId()){
            case R.id.bt_rabbit:
                if(rabbit.equalsIgnoreCase("rabbit")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_bee:
                if(bee.equalsIgnoreCase("bee")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_sheep:
                if(sheep.equalsIgnoreCase("sheep")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_butherfly:
                if(butherfly.equalsIgnoreCase("butherfly")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_cat:
                if(cat.equalsIgnoreCase("cat")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_dog:
                if(dog.equalsIgnoreCase("dog")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_horse:
                if(horse.equalsIgnoreCase("horse")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_pig:
                if(pig.equalsIgnoreCase("pig")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_lion:
                if(lion.equalsIgnoreCase("lion")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_monkey:
                if(monkey.equalsIgnoreCase("monkey")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_snail:
                if(snail.equalsIgnoreCase("snail")){
                    Toast.makeText(this, "Esta bien escrito", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "esta mal escrito", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }
}
