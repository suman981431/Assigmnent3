package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    Button btn1;
    EditText uname,pass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        btn1 = findViewById(R.id.signbtn);
        uname =findViewById(R.id.emailbtn);
        pass = findViewById(R.id.textpass);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = uname.getText().toString();
                String Password = pass.getText().toString();

                SharedPreferences sp = getSharedPreferences("test", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit =sp.edit();
                edit.putString("username",Username);
                edit.putString("password",Password);
                edit.apply();

                Intent i = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i);

            }
        });


    }
}
