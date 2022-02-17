package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText uname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLogStatus();
        btn1 = findViewById(R.id.signbtn);
        btn2 = findViewById(R.id.logbtn);
        uname = findViewById(R.id.emailbtn);
        pass = findViewById(R.id.textpass);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp =getSharedPreferences("test", Context.MODE_PRIVATE);
                String testUsername =sp.getString("username","suman");
                String testPassword = sp.getString("password","suman");
                String fetchUsername =uname.getText().toString();
                String fetchPassword =pass.getText().toString();

                if(testUsername.equals(fetchUsername) && testPassword.equals(fetchPassword)){
                    SharedPreferences lp =getSharedPreferences("state",Context.MODE_PRIVATE);
                    SharedPreferences.Editor edi =lp.edit();
                    edi.putBoolean("loginDemo",true);
                    edi.apply();

                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);

                }

                else{
                    Toast.makeText(MainActivity.this,"Incorrect Uername and Password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void checkLogStatus(){
        SharedPreferences sp =getSharedPreferences("state", MODE_PRIVATE);
        boolean state =sp.getBoolean("loginDemo", false);
        if(state){
        Intent i =new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);
        }
    }
}