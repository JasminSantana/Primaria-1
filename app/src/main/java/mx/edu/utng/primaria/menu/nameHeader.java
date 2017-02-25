package mx.edu.utng.primaria.menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.login.Session;

/**
 * Created by miPC on 16/02/2017.
 */
public class nameHeader extends AppCompatActivity {
    private Session session;
    private final static String SETTING_USER="setting_user";
    SharedPreferences sharedPreferences;
    private String user;
    private TextView emailUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);

        sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
        user = sharedPreferences.getString(SETTING_USER,"");

        emailUser=(TextView)findViewById(R.id.tv_email);

        emailUser.setText("tengo ggg");
        Toast.makeText(this, "logins is: "+ user +"--" , Toast.LENGTH_LONG).show();




    }







}
