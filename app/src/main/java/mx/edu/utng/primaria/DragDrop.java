package mx.edu.utng.primaria;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DragDrop extends AppCompatActivity implements View.OnTouchListener,
        View.OnDragListener {

    private TextView bt1;
    private TextView bt2;
    private TextView bt3;
    private TextView tv1;

    @Override
    public boolean onDrag(View v, DragEvent event) {
        if(event.getAction()==DragEvent.ACTION_DROP){
            TextView dropped = (TextView) event.getLocalState();
            TextView dropTarget = (TextView) v;

            dropped.setVisibility(View.INVISIBLE);

            String text=dropTarget.getText().toString();
            if(text.equals(bt1.getText().toString())) bt1.setVisibility(View.VISIBLE);
            else if(text.equals(bt2.getText().toString())) bt2.setVisibility(View.VISIBLE);
            else if(text.equals(bt3.getText().toString())) bt3.setVisibility(View.VISIBLE);

            dropTarget.setText(dropped.getText());
            dropTarget.setBackgroundColor(Color.BLUE);
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        }
        else return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);
        this.setTitle("Pruebas");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        bt1 = (TextView)findViewById(R.id.bt_1);
        bt2 = (TextView)findViewById(R.id.bt_2);
        bt3 = (TextView)findViewById(R.id.bt_3);
        tv1 = (TextView)findViewById(R.id.tv_insert_text);

        bt1.setOnTouchListener(this);
        bt2.setOnTouchListener(this);
        bt3.setOnTouchListener(this);
        tv1.setOnDragListener(this);
    }
}

