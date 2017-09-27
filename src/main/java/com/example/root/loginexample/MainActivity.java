package com.example.root.loginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHalper helper = new DatabaseHalper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonclick (View v){
        if(v.getId() == R.id.mlogin){
            EditText a = (EditText)findViewById(R.id.musername);
            EditText b = (EditText)findViewById(R.id.mpassword);
            String  uname= a.getText().toString();
            String  pass= b.getText().toString();
            String password = helper.searchpass(uname);
            if(pass.equals(password)){
                Intent i = new Intent(this, display.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
            else{
                Toast msg = Toast.makeText(this, "Credentials don't match", Toast.LENGTH_SHORT);
                msg.show();
            }
        }
        if (v.getId() == R.id.msignup){
            Intent i = new Intent(this, signup.class);
            startActivity(i);
        }

    }
}
