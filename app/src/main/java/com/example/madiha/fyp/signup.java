package com.example.madiha.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    EditText name;

    EditText username;


    EditText password;



    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.input_name);

        username = (EditText) findViewById(R.id.editText2);

        password = (EditText) findViewById(R.id.editText1);

        sign = (Button) findViewById(R.id.signup);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Name = name.getText().toString();

                final String UserName = username.getText().toString();

                final String Password = password.getText().toString();

                if (Name.length() == 0)

                {
                    name.requestFocus();
                    name.setError("NAME FIELD CANNOT BE EMPTY");
                }
                else if (!Name.matches("[a-zA-Z ]+")) {
                    name.requestFocus();
                    name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                else if (UserName.length() == 0) {
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

                    signit p = new signit(getApplicationContext(), username.getText().toString(), password.getText().toString());
                    p.execute();
                }

            }
        });
    }


    public  void  log(View v)
    {
        Intent obj= new Intent(this,LogIn.class);
        startActivity(obj);
    }
    public void login(View v)
    {


        Intent obj= new Intent(this,LogIn.class);
        startActivity(obj);
    }
}