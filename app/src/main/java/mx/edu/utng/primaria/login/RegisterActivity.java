package mx.edu.utng.primaria.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
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
        final String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();
        String nombreUsuario=etUserName.getText().toString();
        String apellidosUsuario=etUserApellidos.getText().toString();

        if(email.isEmpty()||password.isEmpty()||nombreUsuario.isEmpty()||apellidosUsuario.isEmpty()) {
            etUserName.setError("You should write in the box");
            etEmail.setError("You should write in the box");
            etPassword.setError("You should write in the box");
            etUserApellidos.setError("You should write in the box");


        }else if (nombreUsuario.isEmpty()) {
            etUserName.setError("You should write in the box");
        } else {
            if (etUserName.getText().length() < 3) {
                etUserName.setError("The name have to be of the more letter");
            }

        }
        if (apellidosUsuario.isEmpty()) {
            etUserApellidos.setError("You should write in the box");
        } else {

            if (etUserApellidos.getText().length() < 3) {
                etUserApellidos.setError("The lastname have to be of the more letter");

            }
            if (email.isEmpty()) {
                etEmail.setError("You should write in the box");
            } else

            if (etEmail.getText().length() < 3 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("The email is not write correct ");

            }else
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("The email is not write correct");

            }else
            if (password.isEmpty()) {
                etPassword.setError("You should write in the box");
            } else if (etPassword.getText().length() < 3 ) {
                etPassword.setError("The password have to be of the more letter");

            }else if(dbLearningEnglish.getEmails(email)){
                etEmail.setError("This email is used, please insert a new email");
            }
            else{
                dbLearningEnglish.addUser(nombreUsuario, apellidosUsuario, email, password);
                displayToast("User registered ");
                finish();
            }
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
