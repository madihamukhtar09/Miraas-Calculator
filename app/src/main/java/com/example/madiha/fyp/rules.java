package com.example.madiha.fyp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class rules extends AppCompatActivity {
ImageButton check;


    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);


        Bundle x=getIntent().getExtras();

        result=x.getString("result");

        check= (ImageButton) findViewById(R.id.imageButton2);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent x=new Intent(getApplicationContext(),Info.class
                );
                startActivity(x);



            }
        });



    }

    public void backToCalculate(View v)
    {
        Intent intent=new Intent(this, calculateinheritance.class);
        intent.putExtra("result",result);
        startActivity(intent);


    }


    public void moveToInfo(View v)
    {
        Intent intent=new Intent(this, Info.class);
        startActivity(intent);


    }

}
