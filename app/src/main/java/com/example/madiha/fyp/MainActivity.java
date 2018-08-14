package com.example.madiha.fyp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;



public class MainActivity extends AppCompatActivity {

    Button calculate;
    Button history;
    EditText amount;
    EditText numberofsons;
    Spinner select;
    Spinner selectmother;
    Button select1;

    EditText numberofdaughter;
    EditText numberofwife;
    EditText numberOfPaternalBrother;
    EditText  numberOfMaternalBrother;
    EditText husband;
    EditText numberOfGrandDaughter;

    EditText numberOfPaternalGrandMother;
    EditText numberOfGrandFather;

    EditText numberOfMaternalSister;

    EditText numberOfFullSister;

    EditText numberOfPaternalSister;

    EditText numberOfFullBrother;

    EditText numberOfFullPaternalUncle;

    EditText numberOfThirdPersonMale;

    EditText numberOfThirdPersonBoth;

    EditText numberOfThirdPersonFemale;

    EditText numberOfDaughtersSon;

    EditText numberOfDaughtersDaughter;

    EditText numberOfDaughtersDaughtersSon;

    EditText numberOfFullNephew;

    EditText numberOfFullNiece;

    EditText numberOfDaughtersDaughtersDaughter;

    EditText numberOfDaughtersSonsSon;
    EditText numberOfGrandSon;

    EditText numberOfMaternalGrandMother;


    String[] Decision = null;

    TextView show;
    TextToSpeech t1;
     String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle x=getIntent().getExtras();

        username=x.getString("username");


        calculate = (Button) findViewById(R.id.Calculate);
        amount = (EditText) findViewById(R.id.Amount);
        numberofsons = (EditText) findViewById(R.id.Son);
        numberofdaughter = (EditText) findViewById(R.id.Daughter);
        numberofwife = (EditText) findViewById(R.id.Wife);

        Decision = getResources().getStringArray(R.array.Decision);
        select = (Spinner) findViewById(R.id.selectfather);
        selectmother=(Spinner)findViewById(R.id.selectmother);
        numberOfPaternalBrother= (EditText) findViewById(R.id.PaternalBrother);
       numberOfMaternalBrother =(EditText) findViewById(R.id.MaternalBrother);
        husband =(EditText) findViewById(R.id.husband);
        numberOfGrandDaughter =(EditText) findViewById(R.id.GrandDaughter);
        numberOfPaternalGrandMother =(EditText) findViewById(R.id.Paternalgrandmother);
        numberOfGrandFather =(EditText) findViewById(R.id.Grandfather);

        numberOfMaternalSister =(EditText) findViewById(R.id.MaternalSister);


        numberOfFullSister =(EditText) findViewById(R.id.FullSister);

        numberOfPaternalSister =(EditText) findViewById(R.id.PaternalSister);


        numberOfFullBrother =(EditText) findViewById(R.id.FullBrother);

        numberOfFullPaternalUncle =(EditText) findViewById(R.id.FullPaternalUncle);
        numberOfThirdPersonMale =(EditText) findViewById(R.id.thirdMalePerson);

        numberOfThirdPersonFemale =(EditText) findViewById(R.id.thirdFemalePerson);

        numberOfThirdPersonBoth =(EditText) findViewById(R.id.thirdbothPerson);

        numberOfDaughtersSon =(EditText) findViewById(R.id.daughtersSon);
        numberOfDaughtersDaughter =(EditText) findViewById(R.id.daughtersDaughter);
        numberOfDaughtersDaughtersSon=(EditText) findViewById(R.id.daughtersDaughtersSon);
        numberOfFullNephew=(EditText) findViewById(R.id.FullNephew);
        numberOfFullNiece=(EditText) findViewById(R.id.FullNiece);

        numberOfDaughtersDaughtersDaughter=(EditText) findViewById(R.id.daughtersDaughtersDaughter);
        numberOfDaughtersSonsSon=(EditText) findViewById(R.id.daughtersSonsSon);
        numberOfGrandSon=(EditText) findViewById(R.id.GrandSon);
        numberOfMaternalGrandMother=(EditText) findViewById(R.id.Maternalgrandmother);



        show=(TextView)findViewById(R.id.textView2);
        history=(Button)  findViewById(R.id.history);



    history.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showhistory p=new showhistory(getApplicationContext(),username);
            p.execute();
        }
    });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Decision);
        select.setAdapter(adapter);
        selectmother.setAdapter(adapter);




        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedPosition = select.getSelectedItemPosition();
                String father = Decision[selectedPosition];

                int selectmposition=selectmother.getSelectedItemPosition();
                String mother=Decision[selectmposition];




                final String Amount = amount.getText().toString();
                final String Husband = husband.getText().toString();
                final String Son = numberofsons.getText().toString();
                final String Daughter = numberofdaughter.getText().toString();
                final String Wife = numberofwife.getText().toString();
                final String PaternalBrother = numberOfPaternalBrother.getText().toString();
                final String MaternalBrother = numberOfMaternalBrother.getText().toString();
                final String GrandDaughter = numberOfGrandDaughter.getText().toString();
                final String PaternalGrandMother = numberOfPaternalGrandMother.getText().toString();
                final String GrandFather = numberOfGrandFather.getText().toString();
                final String MaternalSister = numberOfMaternalSister.getText().toString();
                final String FullSister = numberOfFullSister.getText().toString();
                final String PaternalSister = numberOfPaternalSister.getText().toString();
                final String FullBrother = numberOfFullBrother.getText().toString();
                final String FullPaternalUncle = numberOfFullPaternalUncle.getText().toString();
                final String ThirdPersonMale = numberOfThirdPersonMale.getText().toString();
                final String ThirdPersonFemale = numberOfThirdPersonFemale.getText().toString();
                final String ThirdPersonBoth = numberOfThirdPersonBoth.getText().toString();
                final String DaughterSon = numberOfDaughtersSon.getText().toString();
                final String DaughterDaughter = numberOfDaughtersDaughter.getText().toString();
                final String DaughterDaughterSon = numberOfDaughtersDaughtersSon.getText().toString();
                final String FullNephew = numberOfFullNephew.getText().toString();
                final String FullNiece = numberOfFullNiece.getText().toString();
                final String DaughterDaughterDaughter = numberOfDaughtersDaughtersDaughter.getText().toString();
                final String DaughterSonSon = numberOfDaughtersSonsSon.getText().toString();
                final String GrandSon = numberOfGrandSon.getText().toString();
                final String MaternalGrandMother = numberOfMaternalGrandMother.getText().toString();

                if (Amount.length() == 0)

                {
                    amount.requestFocus();
                    amount.setError("AMOUNT FIELD CANNOT BE EMPTY");
                }

               else if (Husband.length() == 0)

                {
                    husband.requestFocus();
                    husband.setError("FIELD CANNOT BE EMPTY");
                }
                else if (Son.length() == 0)

                {
                    numberofsons.requestFocus();
                    numberofsons.setError("FIELD CANNOT BE EMPTY");
                }
                else if (Daughter.length() == 0)

                {
                    numberofdaughter.requestFocus();
                    numberofdaughter.setError("FIELD CANNOT BE EMPTY");
                }
                else if (Wife.length() == 0)

                {
                    numberofwife.requestFocus();
                    numberofwife.setError("FIELD CANNOT BE EMPTY");
                }
                  else if (PaternalBrother.length() == 0)

                {
                    numberOfPaternalBrother.requestFocus();
                    numberOfPaternalBrother.setError("FIELD CANNOT BE EMPTY");
                }
                else if (MaternalBrother.length() == 0)

                {
                    numberOfMaternalBrother.requestFocus();
                    numberOfMaternalBrother.setError("FIELD CANNOT BE EMPTY");
                }
                else if (GrandDaughter.length() == 0)

                {
                    numberOfGrandDaughter.requestFocus();
                    numberOfGrandDaughter.setError("FIELD CANNOT BE EMPTY");
                }
                else if (PaternalGrandMother.length() == 0)

                {
                    numberOfPaternalGrandMother.requestFocus();
                    numberOfPaternalGrandMother.setError("FIELD CANNOT BE EMPTY");
                }
                else if (GrandFather.length() == 0)

                {
                    numberOfGrandFather.requestFocus();
                    numberOfGrandFather.setError("FIELD CANNOT BE EMPTY");
                }
                else if (MaternalSister.length() == 0)

                {
                    numberOfMaternalSister.requestFocus();
                    numberOfMaternalSister.setError("FIELD CANNOT BE EMPTY");
                }
                else if (FullSister.length() == 0)

                {
                    numberOfFullSister.requestFocus();
                    numberOfFullSister.setError("FIELD CANNOT BE EMPTY");
                }
                else if (PaternalSister.length() == 0)

                {
                    numberOfPaternalSister.requestFocus();
                    numberOfPaternalSister.setError("FIELD CANNOT BE EMPTY");
                }
                else if (FullBrother.length() == 0)

                {
                    numberOfFullBrother.requestFocus();
                    numberOfFullBrother.setError("FIELD CANNOT BE EMPTY");
                }
                else if (FullPaternalUncle.length() == 0)

                {
                    numberOfFullPaternalUncle.requestFocus();
                    numberOfFullPaternalUncle.setError("FIELD CANNOT BE EMPTY");
                }
                else if (ThirdPersonMale.length() == 0)

                {
                    numberOfThirdPersonMale.requestFocus();
                    numberOfThirdPersonMale.setError("FIELD CANNOT BE EMPTY");
                }
                else if (ThirdPersonFemale.length() == 0)

                {
                    numberOfThirdPersonFemale.requestFocus();
                    numberOfThirdPersonFemale.setError("FIELD CANNOT BE EMPTY");
                }
                else if (ThirdPersonBoth.length() == 0)

                {
                    numberOfThirdPersonBoth.requestFocus();
                    numberOfThirdPersonBoth.setError("FIELD CANNOT BE EMPTY");
                }
                else if (DaughterSon.length() == 0)

                {
                    numberOfDaughtersSon.requestFocus();
                    numberOfDaughtersSon.setError("FIELD CANNOT BE EMPTY");
                }
                else if (DaughterDaughter.length() == 0)

                {
                    numberOfDaughtersDaughter.requestFocus();
                    numberOfDaughtersDaughter.setError("FIELD CANNOT BE EMPTY");
                }
                else if (DaughterDaughterSon.length() == 0)

                {
                    numberOfDaughtersDaughtersSon.requestFocus();
                    numberOfDaughtersDaughtersSon.setError("FIELD CANNOT BE EMPTY");
                }
                else if (FullNephew.length() == 0)

                {
                    numberOfFullNephew.requestFocus();
                    numberOfFullNephew.setError("FIELD CANNOT BE EMPTY");
                }
                else if (FullNiece.length() == 0)

                {
                    numberOfFullNiece.requestFocus();
                    numberOfFullNiece.setError("FIELD CANNOT BE EMPTY");
                }
                else if (DaughterDaughterDaughter.length() == 0)

                {
                    numberOfDaughtersDaughtersDaughter.requestFocus();
                    numberOfDaughtersDaughtersDaughter.setError("FIELD CANNOT BE EMPTY");
                }
                else if (DaughterSonSon.length() == 0)

                {
                    numberOfDaughtersSonsSon.requestFocus();
                    numberOfDaughtersSonsSon.setError("FIELD CANNOT BE EMPTY");
                }
                else if (GrandSon.length() == 0)

                {
                    numberOfGrandSon.requestFocus();
                    numberOfGrandSon.setError("FIELD CANNOT BE EMPTY");
                }
                else if (MaternalGrandMother.length() == 0)

                {
                    numberOfMaternalGrandMother.requestFocus();
                    numberOfMaternalGrandMother.setError("FIELD CANNOT BE EMPTY");
                }


               else {
                    Services x = new Services(username, show, getApplicationContext(), "50c0db3b", amount.getText().toString(), numberofsons.getText().toString(), numberofdaughter.getText().toString(), numberofwife.getText().toString(), father, mother, numberOfPaternalBrother.getText().toString(), numberOfMaternalBrother.getText().toString(), husband.getText().toString(), numberOfGrandDaughter.getText().toString(), numberOfPaternalGrandMother.getText().toString(), numberOfGrandFather.getText().toString(), numberOfMaternalSister.getText().toString(), numberOfFullSister.getText().toString(), numberOfPaternalSister.getText().toString(), numberOfFullBrother.getText().toString(), numberOfFullPaternalUncle.getText().toString(), numberOfThirdPersonMale.getText().toString(), numberOfThirdPersonFemale.getText().toString(), numberOfThirdPersonBoth.getText().toString(), numberOfDaughtersSon.getText().toString(), numberOfDaughtersDaughter.getText().toString(), numberOfDaughtersDaughtersSon.getText().toString(), numberOfFullNephew.getText().toString(), numberOfFullNiece.getText().toString(), numberOfDaughtersDaughtersDaughter.getText().toString(), numberOfDaughtersSonsSon.getText().toString(), numberOfGrandSon.getText().toString(), numberOfMaternalGrandMother.getText().toString());
                    x.execute();
                }

            }
        });
    }


}
