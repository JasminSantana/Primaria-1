package mx.edu.utng.primaria.activities.listener;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import mx.edu.utng.primaria.R;

/**
 * Created by Santana on 19/04/2017.
 */

public class October extends AppCompatActivity implements View.OnClickListener{
    private TextView tvOption1;
    private TextView tvOption2;
    private TextView tvOption3;
    private ImageView ivMonth;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        this.setTitle("Months ");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tvOption1=(TextView)findViewById(R.id.tv_option_uno);
        tvOption2=(TextView)findViewById(R.id.tv_option_dos);
        tvOption3=(TextView)findViewById(R.id.tv_option_tres);

        ivMonth=(ImageView) findViewById(R.id.iv_month);
        tvOption1.setOnClickListener(this);
        tvOption2.setOnClickListener(this);
        tvOption3.setOnClickListener(this);
        //imagenes
        ivMonth.setOnClickListener(this);

        //cambia los datos mes de octubre
        ivMonth.setImageResource(R.drawable.october);

        tvOption1.setText("Dicember");
        tvOption1.setBackgroundColor(Color.CYAN);
        tvOption2.setText("August");
        tvOption2.setBackgroundColor(Color.CYAN);
        tvOption3.setText("October");
        tvOption3.setBackgroundColor(Color.CYAN);
    }

    @Override
    public void onClick(View v) {
        if (tvOption1.isPressed()){
            tvOption1.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
        }else if (tvOption2.isPressed()){
            tvOption2.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
        }else if (tvOption3.isPressed()){
            tvOption3.setBackgroundColor(Color.GREEN);
            Toast.makeText(this," :) Is correct!!",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(October.this,May.class);
            startActivity(intent);


        }//mes de octubre

    }
}
