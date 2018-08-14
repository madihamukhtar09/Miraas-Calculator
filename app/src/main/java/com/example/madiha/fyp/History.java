package com.example.madiha.fyp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    int count=0;
TableLayout p;

    ArrayList<String> ad=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        ArrayList<ModelH> myList = (ArrayList<ModelH>) getIntent().getSerializableExtra("details");

        p = (TableLayout) findViewById(R.id.table1);


        TableRow rowHeader = new TableRow(getApplicationContext());
        rowHeader.setBackgroundColor(Color.parseColor("#BDBDBD"));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText = {"User_Name", "Input", "Result", "Time"};

        for (String c : headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(12);
            tv.setPadding(9, 9, 9, 9);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        p.addView(rowHeader);

        for (int i = 0; i < myList.size(); i++) {
            ad.add(myList.get(i).Username);
            ad.add(myList.get(i).input);
            ad.add(myList.get(i).Result);
            ad.add(myList.get(i).time);
        }

        TableRow row = null;

        for (String text : ad) {

            if (count == 0) {

                row = new TableRow(this);
                row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
            }

            count++;


            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(12);
            tv.setPadding(9, 9, 9 ,9);
            tv.setText(text);
            row.addView(tv);


            if (count == 4) {


                p.addView(row);
                count = 0;


            }


        }
    }

}
