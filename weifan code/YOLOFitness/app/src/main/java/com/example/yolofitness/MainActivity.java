package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.renderscript.*;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public EditText UserID, Password;
    public Button logInbotton,signupbotton, forgetBotton;
    RenderScript Rscript;
    DatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserID = (EditText)findViewById(R.id.User);
        Password = (EditText)findViewById(R.id.password);
        logInbotton = (Button) findViewById(R.id.logIn);
        signupbotton =(Button) findViewById(R.id.signup);
        forgetBotton = (Button) findViewById(R.id.forget);
        database = new DatabaseHelper(this);

        signupbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpPage.class);
                startActivity(intent);
            }
        });

        logInbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id =UserID.getText().toString();
                String password = Password.getText().toString();
                Intent intent;
                if ((id.equals("admin")) && (password.equals("admin123"))) {
                    intent = new Intent(MainActivity.this, AddClassPage.class);
                }else{
                    intent = new Intent(MainActivity.this, Displaypage.class);
                }
                startActivity(intent);

            }



        });


    }
    //  Testing admin.
    /*public void Admin(String User, String UserPassword) {
        if ((User.equals("admin")) && (UserPassword.equals("admin123"))) {
            Intent intent = new Intent(MainActivity.this, AddClassPage.class);
            startActivity(intent);
        }

    }*/
}





