package com.reshika.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.reshika.esoftwarica.ui.home.HomeFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
private EditText etUser,etPassword;
private Button btnLogin;
//private ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Binding
        etUser=findViewById(R.id.etUser);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

                if(TextUtils.isEmpty(etUser.getText()))
                {
                    etUser.setError("Please enter Username");
                    etUser.requestFocus();
                    return;
                }
                else if(TextUtils.isEmpty(etPassword.getText()))
                {
                    etPassword.setError("Please enter Password");
                    etPassword.requestFocus();
                    return;
                }


                if(etUser.getText().toString().equals("softwarica") && etPassword.getText().toString().equals("coventry"))
                {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials!!", Toast.LENGTH_SHORT).show();
                }
    }
}
