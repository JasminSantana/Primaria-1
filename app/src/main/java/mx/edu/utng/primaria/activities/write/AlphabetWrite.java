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
    private EditText etEx;

    private Button btReview;
    private Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_write);
       // setContentView(R.layout.activity_diseno_abc);
        this.setTitle("Alphabet Writing");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        etBi=(EditText)findViewById(R.id.et_bi);
        etDi=(EditText)findViewById(R.id.et_di);
        etEf=(EditText)findViewById(R.id.et_ef);
        etEl=(EditText)findViewById(R.id.et_el);
        etEn=(EditText)findViewById(R.id.et_en);
        etOu=(EditText)findViewById(R.id.et_ou);
        etLlei=(EditText)findViewById(R.id.et_llei);
        etKiu=(EditText)findViewById(R.id.et_kiu);
        etEs=(EditText)findViewById(R.id.et_es);
        etUi=(EditText)findViewById(R.id.et_ui);
        etEx=(EditText)findViewById(R.id.et_ex);

        btNext=(Button)findViewById(R.id.bt_next_letter);
        btReview=(Button)findViewById(R.id.bt_review);
        btNext.setOnClickListener(this);
        btReview.setOnClickListener(this);
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
            if(f.equalsIgnoreCase("EN")){
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
            String k=etKiu.getText().toString().toUpperCase();
            if(k.equalsIgnoreCase("KIU")){
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
            String x=etEx.getText().toString().toUpperCase();
            if(x.equalsIgnoreCase("EX")){
                etEx.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }else{
                etEx.setBackgroundColor(getResources().getColor(R.color.red));
            }
        }else {

        }
    }


/*

View.OnLongClickListener longClickListener=new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        ClipData data=ClipData.newPlainText("","");
        View.DragShadowBuilder shadowBuilder=new View.DragShadowBuilder(v);
        v.startDrag(data,shadowBuilder,v,0);

        return true;
    }
};
    //escuchador para el movimiento
    View.OnDragListener dragListener=new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent=event.getAction();
            final View view=(View)event.getLocalState();
           switch (dragEvent){

               case DragEvent.ACTION_DRAG_ENTERED:


                    if(view.getId()!=R.id.iv_a){
                        //tvA.setText("no es correcto");
                        tvA.setBackgroundColor(getResources().getColor(R.color.blue));
                       }
                    else {
                        tvA.setText(" EI correcto");
                       }
                    /*if(view.getId()!=R.id.iv_b){
                        tvB.setBackgroundColor(getResources().getColor(R.color.blue));
                    }
                    else {
                        tvB.setText(" BI correcto");
                        //tvB.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    }

                   // break;
               /* case DragEvent.ACTION_DRAG_EXITED:
                  //  break;
                //case DragEvent.ACTION_DROP:
                    //if(view.getId()==R.id.iv_b){
                    //}
                    break;
            }
            return true;
        }
    };*/

}
