package com.example.myapplication.Controller;

import com.example.myapplication.Model.User;
import com.example.myapplication.View.IloginView;

public class LoginController implements IloginController {
    IloginView loginView;

    public LoginController(IloginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int logincode=user.isValid();

        switch (logincode){
            case 0:
                loginView.onLoginError("Please Enter a Email");
                break;
            case 1:
                loginView.onLoginError("Please Enter a valid Email");
                break;
            case 2:
                loginView.onLoginError("Please Enter a password");
                break;
            case 3:
                loginView.onLoginError("password should be longer than 6 characters");
                break;
            default:
                loginView.onLoginSuccess("Login Success");
        }
    }
}
