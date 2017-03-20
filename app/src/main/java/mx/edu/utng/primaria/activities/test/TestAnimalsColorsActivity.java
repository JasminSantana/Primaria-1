package mx.edu.utng.primaria.activities.test;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import mx.edu.utng.primaria.R;

public class TestAnimalsColorsActivity extends AppCompatActivity implements View.OnClickListener {
	private RadioButton rbColorYellow;
	private RadioButton rbColorBrown;
	private RadioButton rbColorBlue;
	private EditText etColorGreen;
	private EditText etColorRed;
	private EditText etAnimalBee;
	private EditText etAnimalSheep;
	private EditText etAnimalMonkey;
	private RadioButton rbAnimalButherfly;
	private RadioButton rbAnimalRabbit;
	private ImageView ivSendAC;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_animals_colors);
		this.setTitle("Test Animals and Colors");

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		rbColorYellow = (RadioButton) findViewById(R.id.rb_color_yellow);
		rbColorBrown = (RadioButton) findViewById(R.id.rb_color_brown);
		rbColorBlue = (RadioButton) findViewById(R.id.rb_color_blue);
		etColorRed = (EditText) findViewById(R.id.et_color_red);
		etColorGreen = (EditText) findViewById(R.id.et_color_green);
		etAnimalBee=(EditText)findViewById(R.id.et_animal_bee);
		etAnimalSheep=(EditText)findViewById(R.id.et_animal_sheep);
		etAnimalMonkey=(EditText)findViewById(R.id.et_animal_monkey);
		rbAnimalButherfly=(RadioButton)findViewById(R.id.rb_animal_buthetfly);
		rbAnimalRabbit=(RadioButton)findViewById(R.id.rb_animal_rabbit);
		ivSendAC = (ImageView) findViewById(R.id.iv_send_ac);
		etColorRed.getText().toString();
		etColorGreen.getText().toString();
		etAnimalBee.getText().toString();
		etAnimalSheep.getText().toString();
		etAnimalMonkey.getText().toString();


		rbColorYellow.setOnClickListener(this);
		rbColorBrown.setOnClickListener(this);
		rbColorBlue.setOnClickListener(this);
		etColorRed.setOnClickListener(this);
		etColorGreen.setOnClickListener(this);
		etAnimalBee.setOnClickListener(this);
		etAnimalSheep.setOnClickListener(this);
		etAnimalMonkey.setOnClickListener(this);
		rbAnimalButherfly.setOnClickListener(this);
		rbAnimalRabbit.setOnClickListener(this);
		ivSendAC.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int scoreTest = 0;
		String colorRed = etColorRed.getText().toString();
		String colorGreen = etColorGreen.getText().toString();
		String animalBee = etAnimalBee.getText().toString();
		String animalSheep = etAnimalSheep.getText().toString();
		String animalMonkey = etAnimalMonkey.getText().toString();

		if(rbColorYellow.isChecked()){
			scoreTest = scoreTest + 1;
		}
		if(rbColorBrown.isChecked()){
			scoreTest = scoreTest + 1;
		}
		if(colorRed.equalsIgnoreCase("red")){
			scoreTest = scoreTest + 1;
		}
		if(rbColorBlue.isChecked()){
			scoreTest = scoreTest + 1;
		}
		if(colorGreen.equalsIgnoreCase("green")){
			scoreTest = scoreTest + 1;
		}
		if(animalBee.equalsIgnoreCase("bee")){
			scoreTest=scoreTest+1;
		}
		if(animalSheep.equalsIgnoreCase("sheep")){
			scoreTest=scoreTest+1;
		}
		if(animalMonkey.equalsIgnoreCase("monkey")){
			scoreTest=scoreTest+1;
		}
		if(rbAnimalButherfly.isChecked()){
			scoreTest=scoreTest+1;
		}
		if(rbAnimalRabbit.isChecked()){
			scoreTest=scoreTest+1;
		}
		int scoreFinal = scoreTest;
		if(ivSendAC.isPressed()){
			ContentValues values = new ContentValues();
			values.put("", scoreFinal);

			Toast  toast = Toast.makeText(this,"Final score Test: "+scoreTest,Toast.LENGTH_SHORT);
			toast.show();
		}

	}
}
