package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText emailL, passL;
    Button btnL;
    int counter=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailL=findViewById(R.id.emailL);
        passL=findViewById(R.id.passL);
        btnL=findViewById(R.id.btnL);

        String registeredEmail=getIntent().getStringExtra("email");
        String registeredPassword=getIntent().getStringExtra("password");

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailL.getText().toString();
                String password=passL.getText().toString();
                if(registeredEmail.equals(email)&& registeredPassword.equals(password))
                {
                    Intent intent=new Intent(Login.this,LoginSuccessful.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
                counter--;
                if (counter==0)
                {
                    Toast.makeText(getBaseContext(),"FAILED LOGIN ATTEMPTS",Toast.LENGTH_LONG).show();
                            btnL.setEnabled(false);
                }
            }
        });
    }
}


