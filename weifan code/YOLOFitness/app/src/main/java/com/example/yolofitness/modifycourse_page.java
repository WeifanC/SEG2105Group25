package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;


public class modifycourse_page extends AppCompatActivity {
    public Button Confirm;
    DatabaseHelper databaseHelper;
    private static final String TAG = "TestDatePickerActivity";
    private TextView mDatePicker;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private NumberPicker Hours = null;
    String[] difficultyArray = {"Easy", "Moderate ", "Hard"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifycourse_page);
        mDatePicker = (TextView) findViewById(R.id.modify_date);
        Confirm = (Button) findViewById(R.id.modify_confirm);
        databaseHelper = new DatabaseHelper(this);
        Hours = (NumberPicker) findViewById(R.id.modify_hours);
        Hours.setMinValue(1);
        Hours.setMaxValue(2);
        Hours.setValue(1);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> difficuty = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, difficultyArray);
        spinner.setAdapter(difficuty);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());


        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(modifycourse_page.this, instructor_page.class);
                startActivity(intent);
            }
        });
        Hours.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(modifycourse_page.this, "This class is " + newVal + " hour long.", Toast.LENGTH_SHORT).show();
            }
        });
        mDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        modifycourse_page.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: date: " + year + "/" + month + "/" + dayOfMonth);
                int rm = month + 1;
                mDatePicker.setText(year + "/" + rm + "/" + dayOfMonth);
            }
        };
    }

        class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener{
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(modifycourse_page.this, difficultyArray[i], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }
    }



