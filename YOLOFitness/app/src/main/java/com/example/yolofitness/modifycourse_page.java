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
    public Button Confirm,Cancel;
    DatabaseHelper databaseHelper;
    private static final String TAG = "TestDatePickerActivity";
    private TextView texttime,textcap;
    private EditText et_time,et_cap;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private NumberPicker Hours = null;
    String[] difficultyArray = {"Easy", "Moderate ", "Hard"};
    String[] dateArray = {"Monday", "Tuesday ", "Wednesday","Thursday","Friday","Saturday","Sunday"};
    private int classid;
    private String classdifficult;
    private String classdate;
    private String classtime;
    private String classhours;
    private String capacity;

    /**
     * onmethod method for instructor to modify page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String instructor = bundle.getString("user");
        classid = bundle.getInt("classid");
        classdifficult = bundle.getString("diff");
        classdate = bundle.getString("date");
        classtime = bundle.getString("time");
        int hours = Integer.parseInt(bundle.getString("hours"));
        capacity = bundle.getString("capacity");

        setContentView(R.layout.activity_modifycourse_page);
//        mDatePicker = (TextView) findViewById(R.id.modify_date);
//        mDatePicker.setText(classdate);

        textcap =(TextView) findViewById(R.id.tx_cap);
        texttime =(TextView) findViewById(R.id.tx_starttime);
        et_time = (EditText) findViewById(R.id.et_starttime);
        et_time.setText(classtime);
        et_cap = (EditText) findViewById(R.id.et_capacity);
        et_cap.setText(capacity);
        Confirm = (Button) findViewById(R.id.modify_confirm);
        Cancel = (Button) findViewById(R.id.modify_cancel);
        databaseHelper = new DatabaseHelper(this);

        Hours = (NumberPicker) findViewById(R.id.modify_hours);
        Hours.setMinValue(1);
        Hours.setMaxValue(5);
        Hours.setValue(hours);
        Spinner spinnerdiff = findViewById(R.id.spinner);
        ArrayAdapter<String> difficuty = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, difficultyArray);
        spinnerdiff.setAdapter(difficuty);
        for (int i =0; i<difficultyArray.length;i++){
            if (classdifficult.equals(difficultyArray[i])){
                spinnerdiff.setSelection(i);
            }else{
                spinnerdiff.setSelection(0);
            }
        }
        spinnerdiff.setOnItemSelectedListener(new MyOnItemSelectedListener());

        Spinner spinnerdate = findViewById(R.id.spinner_date);
        ArrayAdapter<String> date = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, dateArray);
        spinnerdate.setAdapter(date);
        for (int i =0; i<dateArray.length;i++){
            if (classdate.equals(dateArray[i])){
                spinnerdate.setSelection(i);
            }else{
                spinnerdate.setSelection(0);
            }
        }
        spinnerdate.setOnItemSelectedListener(new MyOnItemSelectedListener());


        /**
         * update data to database
         * @return null
         */
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capacity = et_cap.getText().toString();
                classtime = et_time.getText().toString();

                if (classtime.contains("[123456789]"))
                if (classhours == null){
                    classhours = hours+"";
                }
                databaseHelper.UpdateClass(classid,instructor,classdifficult,classdate,classtime,classhours,capacity);
                Bundle finalBundle = new Bundle();;
                finalBundle.putString("user",instructor);
                Intent intent = new Intent(modifycourse_page.this, instructor_page.class);
                intent.putExtras(finalBundle);
                startActivity(intent);
            }
        });
            /**
             * cancel class
             */
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.cancelclass(classid);
                Bundle finalBundle = new Bundle();;
                finalBundle.putString("user",instructor);
                Intent intent = new Intent(modifycourse_page.this, instructor_page.class);
                intent.putExtras(finalBundle);
                Toast.makeText(modifycourse_page.this, "This class is cancelled", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        /**
         * display message
         */
        Hours.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                classhours=newVal+"";
                Toast.makeText(modifycourse_page.this, "This class is " + classhours + " hour long.", Toast.LENGTH_SHORT).show();
            }
        });
   }

        class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener{
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                classdifficult=difficultyArray[i];
                classdate=dateArray[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }
    }



