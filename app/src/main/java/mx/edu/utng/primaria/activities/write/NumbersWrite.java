package mx.edu.utng.primaria.activities.write;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.edu.utng.primaria.R;

/**
 * Created by Santana on 3/15/2017.
 */

public class NumbersWrite extends AppCompatActivity {
    private EditText etSeven;
    private EditText etFive;
    private EditText etSix;
    private EditText etTwo;
    private EditText etNine;
    private EditText etTen;
    private EditText etMenosSix;
    private EditText etMenosOne;
    private EditText etMenosFive;
    private Button btReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_write);
        this.setTitle("Numbers Writing");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        etSeven=(EditText)findViewById(R.id.et_seven);
        etFive=(EditText)findViewById(R.id.et_five);
        etSix=(EditText)findViewById(R.id.et_six);
        etTwo=(EditText)findViewById(R.id.et_two);
        etNine=(EditText)findViewById(R.id.et_nine);
        etTen=(EditText)findViewById(R.id.et_ten);
        etMenosSix=(EditText)findViewById(R.id.et_menos_six);
        etMenosOne=(EditText)findViewById(R.id.et_menos_one);
        etMenosFive=(EditText)findViewById(R.id.et_menos_five);
        btReview=(Button)findViewById(R.id.bt_review);

        btReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btReview.isPressed()) {
                    String seven = etSeven.getText().toString().toUpperCase();
                    if (seven.equalsIgnoreCase("SEVEN")) {
                        etSeven.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etSeven.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String five = etFive.getText().toString().toUpperCase();
                    if (five.equalsIgnoreCase("FIVE")) {
                        etFive.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etFive.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String six = etSix.getText().toString().toUpperCase();
                    if (six.equalsIgnoreCase("SIX")) {
                        etSix.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etSix.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String two = etTwo.getText().toString().toUpperCase();
                    if (two.equalsIgnoreCase("TWO")) {
                        etTwo.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etTwo.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String nine = etNine.getText().toString().toUpperCase();
                    if (nine.equalsIgnoreCase("NINE")) {
                        etNine.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etNine.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String ten = etTen.getText().toString().toUpperCase();
                    if (ten.equalsIgnoreCase("TEN")) {
                        etTen.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etTen.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String menosSix = etMenosSix.getText().toString().toUpperCase();
                    if (menosSix.equalsIgnoreCase("SIX")) {
                        etMenosSix.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etMenosSix.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String menosOne = etMenosOne.getText().toString().toUpperCase();
                    if (menosOne.equalsIgnoreCase("ONE")) {
                        etMenosOne.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etMenosOne.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    String menosFive = etMenosFive.getText().toString().toUpperCase();
                        if (menosFive.equalsIgnoreCase("FIVE")) {
                        etMenosFive.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }else {
                        etMenosFive.setBackgroundColor(getResources().getColor(R.color.red));
                    }


                }//review
            }
        });
    }
}
