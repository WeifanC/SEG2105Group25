package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second_page extends AppCompatActivity {
    public Button addClass,deleteClass,AccountInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        AccountInfo=(Button) findViewById(R.id.Accountmanage);
        addClass =(Button) findViewById(R.id.addclass);
        deleteClass = (Button) findViewById(R.id.deleteclass);







        AccountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Second_page.this, DeleteClasspage.class);
            }
        });


    }
}