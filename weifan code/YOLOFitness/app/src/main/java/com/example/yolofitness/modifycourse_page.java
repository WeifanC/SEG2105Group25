package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.util.Locale;


public class modifycourse_page extends AppCompatActivity {
    public EditText Difficulty, Day, Hours;
    public Button Confirm;
    public String difficulty,day,hours;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifycourse_page);
        Difficulty = (EditText)findViewById(R.id.modify_difficulty);
        Day = (Button)findViewById(R.id.modify_day);
        Hours = (EditText)findViewById(R.id.modify_hours) ;
        Confirm =(Button) findViewById(R.id.modify_confirm);
        databaseHelper = new DatabaseHelper(this);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty=Difficulty.getText().toString();
                hours=Hours.getText().toString();
                if (difficulty.equals("1")||difficulty.equals("2")||difficulty.equals("3")){
                }
            }
        });
        Day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
}
}
