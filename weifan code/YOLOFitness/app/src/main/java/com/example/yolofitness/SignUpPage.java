package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpPage extends AppCompatActivity implements View.OnClickListener{
    public EditText AccountNum, signupPassword;
    public Button signupConfirm, studentbutton,instructorbutton;
    public TextView tvidentity;

    @Override// Signup page on click and get input.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        AccountNum = (EditText)findViewById(R.id.signuppage_user);
        signupPassword = (EditText)findViewById(R.id.signuppage_password);
        signupConfirm = (Button) findViewById(R.id.confirmbotton);
        studentbutton = (Button) findViewById(R.id.studentbt);
        instructorbutton = (Button) findViewById(R.id.instructorbt);
        signupConfirm.setOnClickListener(this);
        studentbutton.setOnClickListener(this);
        instructorbutton.setOnClickListener(this);



    }
    //display message for difference type of register ( may be wrong need to check )
    public void  Register(View v){
            if (v.equals(studentbutton)){
                tvidentity.equals("You are new registered as student");
        }else if(v.equals(instructorbutton)){
                tvidentity.equals("you are now registered as instructor");

            }
    }

    //confirm sign up account and password.
    public void onClick(View v){
        switch(v.getId()){
            case R.id.confirmbotton:
                break;

        }
    }
    //back to main log in page
    public void BackToMain()
    {
        Intent intent = new Intent(SignUpPage.this, MainActivity.class);
        startActivity(intent);
    }
}