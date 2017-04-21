package mx.edu.utng.primaria.activities.test;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.activities.CertificateActivity;
import mx.edu.utng.primaria.menu.MainActivity;
import mx.edu.utng.primaria.sqlite.DbHelper;

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
	private DbHelper db;
	private String idUser;
	private final static String SETTING_USER = "setting_user";
	private String user;
	SharedPreferences sharedPreferences;

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

		db = new DbHelper(this);

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
			sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
			user = sharedPreferences.getString(SETTING_USER,"");
			idUser = db.getIdUser(user);
			Log.i("el id del usuario es ", idUser);
			String data = db.getScore(idUser, 2);
			if(data!=null){
				db.updateScore(idUser,2,String.valueOf(scoreTest));
			}else{
				db.addScore(String.valueOf(scoreTest),idUser,2);
			}
			if (scoreTest>=8) {
				final AlertDialog.Builder builder = new AlertDialog.Builder(TestAnimalsColorsActivity.this);
				builder.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ F E L I C I D A D E S ! </b></font>"))
						.setIcon(getResources().getDrawable(R.drawable.winner_acv))
						.setMessage("HAS CONCLUIDO LA ACTIVIDAD ANIMALS AND COLORS," +
								" AHORA PUEDES SEGUIR CON LA SIGUIENTE ACTIVIDAD:" +
								Html.fromHtml("<b>FAMILY AND CLOTHES.</b>"))
						.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								startActivity(new Intent(getApplicationContext(), MainActivity.class));
							}
						});
				builder.show();
			}else{
				final AlertDialog.Builder builderFather = new AlertDialog.Builder(TestAnimalsColorsActivity.this);
				builderFather.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ I N C O R R E C T O ! </b></font>"))
						.setIcon(getResources().getDrawable(R.drawable.winner_acv))
						.setMessage("LO SENTIMOS, PARA PODER PASAR ESTE TEST TIENES QUE " +
								"OBTENER UNA CALIFICACION MAYOR Ó IGUAL A 8, TU CALIFICACIÓN " +
								"ACTUAL ES: "+scoreFinal)
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
