package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Displaypage extends AppCompatActivity {
    public String ID,identity;
    public TextView msg_welcome;
    public Button bt_member, bt_instructor;
    Timer timer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaypage);
        Bundle bundle = getIntent().getExtras();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ;
                ID = bundle.getString("user");
                identity = bundle.getString("identify");
                msg_welcome = (TextView) findViewById(R.id.textView2);
                msg_welcome.setText("Welcome "+ ID + ", You are now successfully sign in as "+ identity+".");
                if (identity.equals("Instructor")){
                    Intent intent = new Intent(Displaypage.this,instructor_page.class);
                    startActivity(intent);
                }else{
                    // member page
                }
//                bt_instructor = findViewById(R.id.bt_instructor);
//                bt_member = findViewById(R.id.bt_membercourse);
//                bt_instructor.setOnClickListener(v -> {
//                    Intent intent = new Intent(Displaypage.this,instructor_page.class);
//                });
            }
        },3000);

    }
}