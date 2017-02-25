package mx.edu.utng.primaria.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        setContentView(R.layout.activity_certificate);
        sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
        user = sharedPreferences.getString(SETTING_USER,"");
        pass = sharedPreferences.getString(SETTING_PASS,"");
        tvX =(TextView)findViewById(R.id.tv_user);
        tvX.setText(user);
    }
}
