package com.example.root.loginexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    DatabaseHalper helper = new DatabaseHalper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void onRegisterclick (View v){
        if(v.getId() == R.id.sregister){
            EditText name1 = (EditText)findViewById(R.id.sname);
            EditText email1 = (EditText)findViewById(R.id.semail);
            EditText uname1 = (EditText)findViewById(R.id.musername);
            EditText pass1 = (EditText)findViewById(R.id.mpassword);
            EditText cpass1 = (EditText)findViewById(R.id.scpassword);
            String name = name1.getText().toString();
            String email = email1.getText().toString();
            String username = uname1.getText().toString();
            String pass = pass1.getText().toString();
            String cpass = cpass1.getText().toString();
            if(!pass.equals(cpass)){
                Toast passw = Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT);
                passw.show();
            }
            else{
                Contact c = new Contact();
                c.setName(name);
                c.setEmail(email);
                c.setUsername(username);
                c.setPass(pass);
                helper.insertContact(c);
            }
        }
    }
}
