package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.renderscript.*;


public class MainActivity extends AppCompatActivity {
    public EditText UserID, Password;
    public Button logInbotton,signupbotton, forgetBotton;
    RenderScript Rscript;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserID = (EditText)findViewById(R.id.User);
        Password = (EditText)findViewById(R.id.password);
        logInbotton = (Button) findViewById(R.id.logIn);
        signupbotton =(Button) findViewById(R.id.signup);
        forgetBotton = (Button) findViewById(R.id.forget);
        logInbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountConfirmed(UserID.getText().toString(), Password.getText().toString());
            }

        });


    }
    //  Testing admin.
    public void AccountConfirmed(String User, String UserPassword) {
        if ((User == "admin") && (UserPassword == "admin123")) {
            Intent intent = new Intent(MainActivity.this, Second_page.class);
            startActivity(intent);
        }
    }

    // sign Up page.
    public void signupPage(){
            Intent intent = new Intent(MainActivity.this, SignUpPage.class);
            startActivity(intent);
            }
        }




