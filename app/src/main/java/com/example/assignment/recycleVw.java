package com.example.assignment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class recycleVw extends AppCompatActivity {
    private RecyclerView recV;
    private String[] names = {"Suman", "Sunil", "Dipesh", "Sandesh", "Om", "Himanshu", "Rishi", "Prabesh", "Saroj", "Albesh", "Sachin",
            "Milan", "Sanal", "Pushpa", "Krishna", "Wasif"};
    private String[] location = {"morang", "sunal", "dharan", "khotang", "hetauda", "sinduli", "jumla", "ktm", "ilam", "jhapa", "pathree",
            "lumbini", "pokhara", "sanjhya", "letang", "banepa"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        recV = findViewById(R.id.rv);
        recV.setLayoutManager(new LinearLayoutManager(this));
        recV.setAdapter(new CustomAdapter(this, names, location));
    }
}
