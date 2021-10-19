package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity implements View.OnClickListener{
    public EditText AccountNum, signupPassword;
    public Button signupConfirm, studentbutton,instructorbutton;


    @Override// Signup page on click and get input.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        AccountNum = (EditText)findViewById(R.id.signuppage_user);
        signupPassword = (EditText)findViewById(R.id.signuppage_password);
        signupConfirm = (Button) findViewById(R.id.confirmbotton);
        studentbutton = (Button) findViewById(R.id.studentbt);
        instructorbutton = (Button) findViewById(R.id.instructorbt);
        signupConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(signupConfirm.getContext(),"registered complete",Toast.LENGTH_LONG).show();
            }
        });
        studentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(studentbutton.getContext(), "you are now registering as a student",Toast.LENGTH_SHORT).show();

            }
        });
        instructorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(instructorbutton.getContext(), "you are now registering as an instructor" ,Toast.LENGTH_SHORT).show();
            }
        });



    }


    //confirm sign up account and password.
    public void onClick(View v){
        switch(v.getId()){
            case R.id.confirmbotton:
                break;

        }

    }

}