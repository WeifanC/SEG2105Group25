package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ListView;

public class member_enrollpage extends AppCompatActivity {

    public Button enroll,unenroll,bt_menu;
    public ListView lt_member;
    DatabaseHelper databaseHelper;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_enrollpage);
        bt_menu = (Button) findViewById(R.id.bt_backtomain);
        enroll = (Button) findViewById(R.id.bt_enroll);
        unenroll =(Button) findViewById(R.id.bt_unenroll);
        lt_member = (ListView)findViewById(R.id.ltmember);


        lt_member.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ClassModel clickedClass = (ClassModel) adapterView.getItemAtPosition(i);
                String Cinstructor = clickedClass.getMember();
                boolean verify = databaseHelper.Verify_Classname(clickedClass.getName(),Insname);

    }
}