package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class instructor_page extends AppCompatActivity {
    public EditText ET_search;
    public Button bt_modify, bt_meau;
    public TextView TV_instructor;
    public String classname;
    DatabaseHelper database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_page);
        bt_modify = (Button) findViewById(R.id.bt_modifycourse);
        bt_meau = findViewById(R.id.bt_backtomain);
        ET_search = (EditText)findViewById(R.id.ET_Search);
        TV_instructor = findViewById(R.id.TV_instructor);
        bt_meau.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        bt_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classname=ET_search.getText().toString();
                boolean verify = database.Verify_Classname(classname);
                if (verify) {
                    Intent intent = new Intent(instructor_page.this, modifycourse_page.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(instructor_page.this,"Classname incorrected",Toast.LENGTH_LONG).show();
                }
                }
            });
        }
    }



