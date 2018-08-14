package com.example.madiha.fyp;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

public class calculateinheritance extends AppCompatActivity {

    TextView show;
    TextToSpeech t1;

    String result;
    Button rate;
    PopupWindow m;
    RatingBar r;
   Button ratebar;

     private RelativeLayout mRelativeLayout;
     private  RelativeLayout mlayout;



    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.r1);



        Bundle x=getIntent().getExtras();

        String res=x.getString("result");

        result=res;

        username=x.getString("username");
        show=(TextView)findViewById(R.id.textView2);
        show.setText(res.toString());
        rate=(Button) findViewById(R.id.button1);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        final View customView = inflater.inflate(R.layout.popup,null);

        rate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                m = new PopupWindow(
                        customView,
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );


                m.showAtLocation(mRelativeLayout,Gravity.CENTER,0,0);

            }
        });


        ratebar=(Button) customView.findViewById(R.id.rate_button);
        r=(RatingBar)customView.findViewById(R.id.ratingBar2);

        ratebar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String a=String.valueOf(r.getRating());
            rating obj= new rating(getApplicationContext(),username,a);
            obj.execute();


            }
        });



        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        t1.speak(res, TextToSpeech.QUEUE_FLUSH, null);

    }

    public void back(View v)
    {

        try
        {

            Intent intent=new Intent(this, MainActivity.class);
            intent.putExtra("username",username);
            startActivity(intent);

        }
        catch(Exception e)
        {


        }




    }

   public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }



    public  void viewRules(View v)
    {
        Intent intent=new Intent(this, rules.class);
        intent.putExtra("result",result);
        startActivity(intent);


    }


}
