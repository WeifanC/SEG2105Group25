package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Displaypage extends AppCompatActivity {
    public String ID,identity;
    public TextView msg_welcome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaypage);
        Bundle bundle = getIntent().getExtras();
        ID = bundle.getString("user");
        identity = bundle.getString("identify");
        msg_welcome = (TextView) findViewById(R.id.textView2);
        msg_welcome.setText("Welcome "+ ID + ", You are now successfully sign in as "+ identity+".");


    }
}