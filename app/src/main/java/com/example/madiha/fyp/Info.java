package com.example.madiha.fyp;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

/**
 * Created by madiha on 1/3/2018.
 */


public class Info extends AppCompatActivity  {

    TextView check1;
    EditText editRollno, editName, editMarks;

    Button btnAdd, btnDelete, btnModify, btnView, btnViewAll, btnShowInfo, check;
    SQLiteDatabase db;

   Button b;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        check1=(TextView)findViewById(R.id.textView);


        try
        {
            InputStream i=getAssets().open("rules.txt");

            int size=i.available();

            byte[] r=new byte[size];
            i.read(r);
            i.close();
            String text=new String(r);

           check1.setText(text.toString());


        }
        catch(Exception e) {


        }


    }

    public void exit(View v)
    {


        Intent obj= new Intent(this,alert.class);
        startActivity(obj);
    }
}

