package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Controller.IloginController;
import com.example.myapplication.Controller.LoginController;
import com.example.myapplication.View.IloginView;

public class MainActivity extends AppCompatActivity implements IloginView {

    TextView email,password;
    Button login;
    IloginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.Email);
        password=findViewById(R.id.Password);
        login=findViewById(R.id.Login);

        loginController = new LoginController(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginController.onLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });

    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}