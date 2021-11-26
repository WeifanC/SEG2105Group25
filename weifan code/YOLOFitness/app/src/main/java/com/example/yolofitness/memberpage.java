package com.example.yolofitness;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class memberpage extends AppCompatActivity {
    public Button member_searchbutton;
    public EditText member_searchbox;
    public ListView view;
    public DatabaseHelper database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberview_page);
        member_searchbutton = findViewById(R.id.member_searchbutton);
        member_searchbox = findViewById(R.id.member_searchbox);


    }

}
