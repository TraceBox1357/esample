package com.example.myapplication.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {
    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public int isValid() {
        if(TextUtils.isEmpty(getEmail())){
            return 0;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            return 1;
        }
        else if(getPassword().length()==0){
            return 2;
        }
        else if(getPassword().length()<=6){
            return 3;
        }
        else
            return -1;
    }
}
