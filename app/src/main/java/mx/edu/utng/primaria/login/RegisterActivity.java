package mx.edu.utng.primaria.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.sqlite.DbHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btRegister;
    private TextView tvLogin;
    private EditText etUserName;
    private EditText etUserApellidos;
    private EditText etEmail;
    private EditText etPassword;
    private DbHelper dbLearningEnglish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbLearningEnglish = new DbHelper(this);
        btRegister = (Button)findViewById(R.id.bt_register);
        tvLogin = (TextView)findViewById(R.id.tv_login);
        etUserName=(EditText)findViewById(R.id.et_user_name);
        etUserApellidos=(EditText)findViewById(R.id.et_user_apellidos);
        etEmail = (EditText)findViewById(R.id.et_email);
        etPassword = (EditText)findViewById(R.id.et_password);
        btRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_register:
                register();
                break;
            case R.id.tv_login:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
            default:

        }
    }

    private void register(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String nombreUsuario=etUserName.getText().toString();
        String apellidosUsuario=etUserApellidos.getText().toString();

        if(nombreUsuario.isEmpty()&&apellidosUsuario.isEmpty()&&email.isEmpty() && password.isEmpty()){
            displayToast("Username/password/apellidos field empty");
        }else{

            dbLearningEnglish.addUser(nombreUsuario,apellidosUsuario,email,password);
            displayToast("User registered ");
            finish();

        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
