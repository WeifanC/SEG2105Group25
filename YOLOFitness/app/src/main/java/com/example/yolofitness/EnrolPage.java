package com.example.yolofitness;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnrolPage extends AppCompatActivity {
    public Button confirm,back;
    public TextView hint;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("user");
        int classid = bundle.getInt("classid");
        String classdifficult = bundle.getString("diff");
        String classdate = bundle.getString("date");
        int hours = Integer.parseInt(bundle.getString("hours"));
        String capacity = bundle.getString("capacity");
        String[] memberslist = bundle.getStringArray("membername");

        setContentView(R.layout.activity_memberenrolpage);
        confirm = findViewById(R.id.bt_enrolconfirm);
        back = findViewById(R.id.bt_enrolpageback);


    }
}
