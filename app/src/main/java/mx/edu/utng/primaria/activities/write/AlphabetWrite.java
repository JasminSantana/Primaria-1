package mx.edu.utng.primaria.activities.write;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.edu.utng.primaria.R;

/**
 * Created by Santana on 2/24/2017.
 */

public class AlphabetWrite extends AppCompatActivity implements View.OnClickListener {
    /* private ImageView ivA;
     private ImageView ivB;
     private TextView tvA;
     private TextView tvB;*/
    private EditText etBi;
    private EditText etDi;
    private  EditText etEf;
    private EditText etEl;
    private EditText etEn;
    private EditText etOu;
    private EditText etLlei;
    private EditText etKiu;
    private EditText etEs;
    private EditText etUi;
    private EditText etEm;
    private EditText etPi;
    private EditText etEx;

    private Button btReview;
    private Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_write);
        // setContentView(R.layout.activity_diseno_abc);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        etBi=(EditText)findViewById(R.id.et_bi);
        etDi=(EditText)findViewById(R.id.et_di);
        etEf=(EditText)findViewById(R.id.et_ef);
        etEl=(EditText)findViewById(R.id.et_ele);
        etEn=(EditText)findViewById(R.id.et_en);
        etOu=(EditText)findViewById(R.id.et_ou);
        etLlei=(EditText)findViewById(R.id.et_llei);
        etKiu=(EditText)findViewById(R.id.et_kiu);
        etEs=(EditText)findViewById(R.id.et_es);
        etUi=(EditText)findViewById(R.id.et_ui_write);
        etEm=(EditText)findViewById(R.id.et_m_write);
        etPi=(EditText)findViewById(R.id.et_p_write);
        etEx=(EditText)findViewById(R.id.et_ex_write);

        etBi.setText("BI");
        etBi.setEnabled(false);

        btReview=(Button)findViewById(R.id.bt_review);

        btReview.setOnClickListener(this);

        btNext=(Button)findViewById(R.id.bt_next_letter);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente=new Intent(AlphabetWrite.this,AlphabetWrite2.class);
                startActivity(siguiente);
            }
        });
        /*ivA=(ImageView)findViewById(R.id.iv_a);
        ivB=(ImageView)findViewById(R.id.iv_b);

        tvA=(TextView)findViewById(R.id.tv_a);
        tvB=(TextView)findViewById(R.id.tv_b);
        //escuhando para moverse
        ivA.setOnLongClickListener(longClickListener);
        ivB.setOnLongClickListener(longClickListener);
        //al estar sobre la img

        tvA.setOnDragListener(dragListener);
        tvB.setOnDragListener(dragListener);*/

    }

    @Override
    public void onClick(View v) {
        if(btReview.isPressed()){
            String b=etBi.getText().toString().toUpperCase();

            if(b.equalsIgnoreCase("BI")){
                etBi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etBi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String d=etDi.getText().toString().toUpperCase();
            if(d.equalsIgnoreCase("DI")){
                etDi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etDi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String f=etEf.getText().toString().toUpperCase();
            if(f.equalsIgnoreCase("EF")){
                etEf.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etEf.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String l=etEl.getText().toString().toUpperCase();
            if(l.equalsIgnoreCase("EL")){
                etEl.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etEl.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String n=etEn.getText().toString().toUpperCase();
            if(n.equalsIgnoreCase("EN")){
                etEn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etEn.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String o=etOu.getText().toString().toUpperCase();
            if(o.equalsIgnoreCase("OU")){
                etOu.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etOu.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String j=etLlei.getText().toString().toUpperCase();
            if(j.equalsIgnoreCase("LLEI")){
                etLlei.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etLlei.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String q=etKiu.getText().toString().toUpperCase();
            if(q.equalsIgnoreCase("KIU")){
                etKiu.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etKiu.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String s=etEs.getText().toString().toUpperCase();
            if(s.equalsIgnoreCase("ES")){
                etEs.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etEs.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String u=etUi.getText().toString().toUpperCase();
            if(u.equalsIgnoreCase("UI")){
                etUi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etUi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String m=etEm.getText().toString().toUpperCase();
            if(m.equalsIgnoreCase("EM")){
                etEm.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etEm.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String p=etPi.getText().toString().toUpperCase();
            if(p.equalsIgnoreCase("PI")){
                etPi.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etPi.setBackgroundColor(getResources().getColor(R.color.red));
            }
            String x=etEx.getText().toString().toUpperCase();
            if(x.equalsIgnoreCase("EX")){
                etEx.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etEx.setBackgroundColor(getResources().getColor(R.color.red));
            }
        }
    }
}
