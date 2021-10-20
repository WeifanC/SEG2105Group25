package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {
    public EditText AccountNum, signupPassword, tv_identity;
    public Button signupConfirm, studentbutton,instructorbutton;
    DatabaseHelper database;




    @Override// Signup page on click and get input.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        AccountNum = (EditText)findViewById(R.id.signuppage_user);
        signupPassword = (EditText)findViewById(R.id.signuppage_password);
        tv_identity = (EditText)findViewById(R.id.identity);
        signupConfirm = (Button) findViewById(R.id.confirmbotton);
        database = new DatabaseHelper(this);
        signupConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_account =AccountNum.getText().toString();
                String password = signupPassword.getText().toString();
                String member_identity = tv_identity.getText().toString();
                boolean Account_add =database.add_accountdata(user_account,password,member_identity);
                if (user_account.equals("")|| password.equals("")|| tv_identity.equals("")){
                    Toast.makeText((SignUpPage.this), "invalid input",Toast.LENGTH_SHORT).show();

                }
                if(Account_add ==false) {
                    Toast.makeText((SignUpPage.this), "please try different account", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SignUpPage.this,"registered complete",Toast.LENGTH_LONG).show();
                }



                Intent intent = new Intent(SignUpPage.this, MainActivity.class);
                startActivity(intent);

            }
        });




    }




}