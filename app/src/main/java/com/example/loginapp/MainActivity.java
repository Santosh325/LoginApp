package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   TextView email,password;
   Button registration;

   String getEmail, getPassword;
   boolean length = true;
   boolean letter = true;
   boolean twoDigit = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.editEmailAddress);
        password = findViewById(R.id.editPassword);
        registration = findViewById(R.id.editButton);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmail = email.getText().toString();
                getPassword = password.getText().toString();
                boolean length = true;
                boolean letter = true;
                boolean digit = true;
                boolean upperCase = true;
                if (getPassword.length() < 8) {
                    length = false;
                } else {
                    char c;
                    int digitCount = 0;
                    int upperCaseCount = 0;
                    for (int i = 0; i < password.length(); i++) {
                        c = getPassword.charAt(i);
                        if (!Character.isLetterOrDigit(c)) {
                            letter = false;
                        } else if (Character.isDigit(c)) {
                            digitCount++;
                        } else if (Character.isUpperCase(c)) {
                              upperCaseCount ++;
                        }
                    }
                    if (digitCount < 2)   {
                        digit = false;
                    }
                    if(upperCaseCount < 1) {
                        upperCase = false;
                    }
                }

                if(getEmail.equals("") || getPassword.equals("")) {
                    Toast.makeText(getApplicationContext(),"Please enter username and password",Toast.LENGTH_LONG).show();
                } else {
                    if(length == true && letter == true && digit == true && upperCase == true) {
                        Toast.makeText(getApplicationContext(),"you are logged",Toast.LENGTH_LONG).show();
                        email.setText("");
                        password.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(),"your password must have atleast 1 capital Letter and 2 digits and more than 10 character",Toast.LENGTH_LONG).show();

                    }
                }
            }


        });

    }

}
