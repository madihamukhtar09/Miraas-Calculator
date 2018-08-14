package com.example.madiha.fyp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import static com.example.madiha.fyp.R.drawable.e;

public class LogIn extends AppCompatActivity {

    EditText username;


    EditText password;

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText) findViewById(R.id.editText1);

        password = (EditText) findViewById(R.id.editText2);

        login = (Button) findViewById(R.id.signup);





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String UserName = username.getText().toString();

                final String Password = password.getText().toString();


                  if (UserName.length() == 0) {
                    username.requestFocus();
                    username.setError("EMAIL FIELD CANNOT BE EMPTY");
                }

                  else if (!UserName.matches( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                          + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                      username.requestFocus();
                      username.setError("ENTER A VALID EMAIL ADDRESS");

                  }

                  else if (Password.length() == 0) {
                      password.requestFocus();
                      password.setError("PASSWORD FIELD CANNOT BE EMPTY");
                  }

             else {
                      Register p = new Register(getApplicationContext(), username.getText().toString(), password.getText().toString());
                      p.execute();
                  }

            }
        });


    }


    public void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("rules.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {

            Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show();

        }
    }

    public void signup(View v)
    {


        Intent obj= new Intent(this,signup.class);
        startActivity(obj);
    }


    }

