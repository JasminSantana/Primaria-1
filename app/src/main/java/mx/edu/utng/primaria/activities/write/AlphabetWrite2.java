package mx.edu.utng.primaria.activities.write;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.menu.MainActivity;

public class AlphabetWrite2 extends AppCompatActivity implements View.OnClickListener{
    private EditText etEi;
    private EditText etCi;
    private EditText etI;
    private EditText etLli;
    private EditText etEich;
    private EditText etAi;
    private EditText etKei;
    private EditText etArr;
    private EditText etTi;
    private EditText etVi;
    private EditText etDoblo;
    private EditText etGuay;
    private EditText etZi;

    private Button btReview;
    private Button btFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphabet_write);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        etEi=(EditText)findViewById(R.id.et_ei);
        etCi=(EditText)findViewById(R.id.et_ci);
        etI=(EditText)findViewById(R.id.et_e);
        etLli=(EditText)findViewById(R.id.et_lli);
        etEich=(EditText)findViewById(R.id.et_eich);
        etAi=(EditText)findViewById(R.id.et_ai_write);
        etKei=(EditText)findViewById(R.id.et_kei);
        etArr=(EditText)findViewById(R.id.et_arr);
        etTi=(EditText)findViewById(R.id.et_ti);
        etVi=(EditText)findViewById(R.id.et_v_write);
        etDoblo=(EditText)findViewById(R.id.et_w_write);
        etGuay=(EditText)findViewById(R.id.et_y_write);
        etZi=(EditText)findViewById(R.id.et_zi_write);

        etEi.setText("EI");
        etEi.setEnabled(false);

        btReview=(Button)findViewById(R.id.bt_review_alphabet);
        btReview.setOnClickListener(this);

        btFinish=(Button)findViewById(R.id.bt_finish_letter);
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar=new Intent(AlphabetWrite2.this,MainActivity.class);
                startActivity(regresar);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(btReview.isPressed()) {
            String a = etEi.getText().toString().toUpperCase();

            if (a.equalsIgnoreCase("Ei")) {
                etEi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etEi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String c = etCi.getText().toString().toUpperCase();

            if (c.equalsIgnoreCase("Ci")) {
                etCi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etCi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String e = etI.getText().toString().toUpperCase();

            if (e.equalsIgnoreCase("I")) {
                etI.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etI.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String g = etLli.getText().toString().toUpperCase();

            if (g.equalsIgnoreCase("LLI")) {
                etLli.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etLli.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String h = etEich.getText().toString().toUpperCase();

            if (h.equalsIgnoreCase("EICH")) {
                etEich.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etEich.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String i = etAi.getText().toString().toUpperCase();

            if (i.equalsIgnoreCase("AI")) {
                etAi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etAi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String k = etKei.getText().toString().toUpperCase();
            etKei.setEnabled(false);
            if (k.equalsIgnoreCase("KEI")) {
                etKei.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etKei.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String r = etArr.getText().toString().toUpperCase();

            if (r.equalsIgnoreCase("ARR")) {
                etArr.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etArr.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String t = etTi.getText().toString().toUpperCase();

            if (t.equalsIgnoreCase("TI")) {
                etTi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etTi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String vi = etVi.getText().toString().toUpperCase();

            if (vi.equalsIgnoreCase("VI")) {
                etVi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etVi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String w = etDoblo.getText().toString().toUpperCase();

            if (w.equalsIgnoreCase("DOBLO IU")) {
                etDoblo.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etDoblo.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String y = etGuay.getText().toString().toUpperCase();

            if (y.equalsIgnoreCase("GUAY")) {
                etGuay.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etGuay.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String z = etZi.getText().toString().toUpperCase();

            if (z.equalsIgnoreCase("ZI")) {
                etZi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                etZi.setBackgroundColor(getResources().getColor(R.color.red));
            }

        }//fin


    }
}
