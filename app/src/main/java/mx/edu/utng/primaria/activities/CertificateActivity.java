package mx.edu.utng.primaria.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mx.edu.utng.primaria.R;

public class CertificateActivity extends AppCompatActivity {
    private final static String SETTING_USER = "setting_user";
    private final static String SETTING_PASS = "setting_pass";
    private String user;
    private String pass;
    SharedPreferences sharedPreferences;

    private TextView tvX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_certificate);
        this.setTitle("Certificate");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
        user = sharedPreferences.getString(SETTING_USER,"");
        pass = sharedPreferences.getString(SETTING_PASS,"");
        tvX =(TextView)findViewById(R.id.tv_user);
//        tvX.setText(user);

        RelativeLayout viewRoot = new RelativeLayout(getApplicationContext());
        View v = getLayoutInflater().inflate(R.layout.activity_certificate, viewRoot, true);
        viewRoot.setLayoutParams(new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));

        //Aquí hice la logica y asignación de imagenes al collage, poblando cada ImageView correspondiente.

        //Con esta sentencia se evita que el contenedor tenga valores height y width nulos.
        viewRoot.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        //Se asigna un tamaño a la vista contenedora
        viewRoot.layout(0, 0, viewRoot.getMeasuredWidth(), viewRoot.getMeasuredHeight());
        //Se crea el bitmap
        final Bitmap bitmap=Bitmap.createBitmap(viewRoot.getMeasuredWidth(),
                viewRoot.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        //Renderiza la vista del contenedor
        viewRoot.draw(c);
    }
}
