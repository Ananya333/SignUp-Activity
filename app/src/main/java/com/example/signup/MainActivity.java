package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emailSign,passSign;
    Button btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailSign = findViewById(R.id.emailS);
        passSign = findViewById(R.id.passS);
        btnS = findViewById(R.id.btnS);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailSign.getText().toString();
                String password = passSign.getText().toString();

                if (!isValidPassword(password)) {
                    Toast.makeText(MainActivity.this, "Password Does not match the rules",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
    }
            Pattern lowercase = Pattern.compile("^.*[a-z].*$");
            Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
            Pattern number = Pattern.compile("^.*[0-9].*$");
            Pattern specialCharacter = Pattern.compile("^.*[^a-zA-Z0-9].*$");

            private Boolean isValidPassword(String password) {
                if (password.length() < 8) {
                    return false;
                }
                if (!lowercase.matcher(password).matches()) {
                    return false;
                }
                if (!uppercase.matcher(password).matches()) {
                    return false;
                }
                if (!number.matcher(password).matches()) {
                    return false;
                }
                if (!specialCharacter.matcher(password).matches()) {
                    return false;
                }
                return true;
            }
        }


