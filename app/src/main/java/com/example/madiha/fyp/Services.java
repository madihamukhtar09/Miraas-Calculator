package com.example.madiha.fyp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by madiha on 11/22/2017.
 */

public class Services extends AsyncTask<String,String,String> {

    TextView show;


    public final String SOAP_ACTION = "http://tempuri.org/HelloWorld";

    public  final String OPERATION_NAME = "HelloWorld";

    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

    public String webservice;

    Context x;

    String r="";

    String amount;

    String son;

    String Numberofdaughter;
    String NumberofWife;
     String Father;

    String Mother;

    String PaternalBrother;
    String MaternalBrother;

    String husband;

    String GrandDaughter;
    String PaternalGrandMother;
    String GrandFather;
    String MaternalSister;
    String FullSister;
    String PaternalSister;
    String FullBrother;
    String FullPaternalUncle;

    String ThirdPersonMale;

    String ThirdPersonFemale;
    String ThirdPersonBoth;
    String DaughtersSon;
    String DaughtersDaughter;
    String DaughtersDaughtersSon;
    String FullNephew;
    String FullNiece;
    String DaughtersDaughtersDaughter;
    String DaughtersSonsSon;
    String GrandSon;
    String MaternalGrandMother;

    String username;


    public Services(String username,TextView show,Context x, String webservice,String amount,String Numberofson,String Numberofdaughter, String NumberofWife ,String father, String mother ,String numberOfPaternalBrother, String numberOfMaternalBrother, String husband, String numberOOfGrandDaughter, String numberOfPaternalGrandMother, String numberOfGrandFather, String numberOfMaternalSister, String numberOfFullSister, String numberOfPaternalSister, String numberOfFullBrother, String numberOfFullPaternalUncle, String numberOfThirdPersonMale, String numberOfThirdPersonFemale, String numberOfThirdPersonBoth, String numberOfDaughtersSon, String numberOfDaughtersDaughter,String numberOfDaughtersDaughtersSon, String numberOfFullNephew, String numberOfFullNiece, String numberOfDaughtersDaughtersDaughter, String numberOfDaughtersSonsSon, String numberOfGrandSon, String numberOfMaternalGrandMother)
    {

        this.username=username;
        this.show=show;
        this.webservice=webservice;

        this.x=x;

        this.amount=amount;

        this.son=Numberofson;


        this.Numberofdaughter=Numberofdaughter;
        this.NumberofWife=NumberofWife;
        this.Father=father;
        this.Mother=mother;
        this.PaternalBrother=numberOfPaternalBrother;
        this.MaternalBrother=numberOfMaternalBrother;
        this.husband=husband;
        this.GrandDaughter=numberOOfGrandDaughter;
        this.PaternalGrandMother=numberOfPaternalGrandMother;
        this.GrandFather=numberOfGrandFather;
        this.MaternalSister=numberOfMaternalSister;
        this.FullSister=numberOfFullSister;
        this.PaternalSister=numberOfPaternalSister;
        this.FullBrother=numberOfFullBrother;
        this.FullPaternalUncle=numberOfFullPaternalUncle;
        this.ThirdPersonMale=numberOfThirdPersonMale;
        this.ThirdPersonFemale=numberOfThirdPersonFemale;
        this.ThirdPersonBoth=numberOfThirdPersonBoth;
        this.DaughtersSon=numberOfDaughtersSon;
        this.DaughtersDaughter=numberOfDaughtersDaughter;
        this.DaughtersDaughtersSon=numberOfDaughtersDaughtersSon;
        this.FullNephew=numberOfFullNephew;
        this.FullNiece=numberOfFullNiece;
        this.DaughtersDaughtersDaughter=numberOfDaughtersDaughtersDaughter;
        this.DaughtersSonsSon=numberOfDaughtersSonsSon;
        this.GrandSon=numberOfGrandSon;
        this.MaternalGrandMother=numberOfMaternalGrandMother;


    }


    @Override
    protected String doInBackground(String... params) {


        String SOAP_ADDRESS = "http://412f80ec.ngrok.io/Rules.asmx";
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, OPERATION_NAME);

        PropertyInfo us = new PropertyInfo();
        us.setName("username");
        us.setType(String.class);
        us.setValue(username);
        request.addProperty(us);

        PropertyInfo ss = new PropertyInfo();
       ss.setName("amounts");
        ss.setType(String.class);
        ss.setValue(amount);

       request.addProperty(ss);

        PropertyInfo sons = new PropertyInfo();
        sons.setName("numberOfSon");
        sons.setType(String.class);
        sons.setValue(son);
        request.addProperty(sons);

        PropertyInfo daughter = new PropertyInfo();
        daughter.setName("numberOfDaughter");
        daughter.setType(String.class);
        daughter.setValue(Numberofdaughter);
        request.addProperty(daughter);

        PropertyInfo wife = new PropertyInfo();
        wife.setName("numberOfWife");
        wife.setType(String.class);
        wife.setValue(NumberofWife);
        request.addProperty(wife);




        PropertyInfo father = new PropertyInfo();
        father.setName("father");
        father.setType(String.class);
        father.setValue(Father);
        request.addProperty(father);


        PropertyInfo mother = new PropertyInfo();
        mother.setName("mother");
        mother.setType(String.class);
        mother.setValue(Mother);
        request.addProperty(mother);


        PropertyInfo paternal = new PropertyInfo();
        paternal.setName("numberOfPaternalBrother");
        paternal.setType(String.class);
        paternal.setValue(PaternalBrother);
        request.addProperty(paternal);

        PropertyInfo maternal = new PropertyInfo();
        maternal.setName("numberOfMaternalBrother");
        maternal.setType(String.class);
        maternal.setValue(MaternalBrother);
        request.addProperty(maternal);



        PropertyInfo Husband = new PropertyInfo();
        Husband.setName("husband");
        Husband.setType(String.class);
        Husband.setValue(husband);
        request.addProperty(Husband);




        PropertyInfo granddaughter = new PropertyInfo();
        granddaughter.setName("numberOfGrandDaughter");
        granddaughter.setType(String.class);
        granddaughter.setValue(GrandDaughter);
        request.addProperty(granddaughter);


        PropertyInfo paternalgrandmother = new PropertyInfo();
        paternalgrandmother.setName("numberOfPaternalGrandMother");
        paternalgrandmother.setType(String.class);
        paternalgrandmother.setValue(PaternalGrandMother);
        request.addProperty(paternalgrandmother);


        PropertyInfo grandfather = new PropertyInfo();
        grandfather.setName("numberOfGrandFather");
        grandfather.setType(String.class);
        grandfather.setValue(GrandFather);
        request.addProperty(grandfather);


        PropertyInfo maternalsister = new PropertyInfo();
        maternalsister.setName("numberOfMaternalSister");
        maternalsister.setType(String.class);
        maternalsister.setValue(MaternalSister);
        request.addProperty(maternalsister);

        PropertyInfo fullsister = new PropertyInfo();
        fullsister.setName("numberOfFullSister");
        fullsister.setType(String.class);
        fullsister.setValue(FullSister);
        request.addProperty(fullsister);

        PropertyInfo paternalsister = new PropertyInfo();
        paternalsister.setName("numberOfPaternalSister");
        paternalsister.setType(String.class);
        paternalsister.setValue(PaternalSister);
        request.addProperty(paternalsister);

        PropertyInfo fullbrother = new PropertyInfo();
        fullbrother.setName("numberOfFullBrother");
        fullbrother.setType(String.class);
        fullbrother.setValue(FullBrother);
        request.addProperty(fullbrother);


        PropertyInfo fullpaternaluncle = new PropertyInfo();
        fullpaternaluncle.setName("numberOfFullPaternalUncle");
        fullpaternaluncle.setType(String.class);
        fullpaternaluncle.setValue(FullPaternalUncle);
        request.addProperty(fullpaternaluncle);



        PropertyInfo thirdpersonmale = new PropertyInfo();
        thirdpersonmale.setName("numberOfThirdPersonMale");
        thirdpersonmale.setType(String.class);
        thirdpersonmale.setValue(ThirdPersonMale);
        request.addProperty(thirdpersonmale);


        PropertyInfo thirdpersonfemale = new PropertyInfo();
        thirdpersonfemale.setName("numberOfThirdPersonFemale");
        thirdpersonfemale.setType(String.class);
        thirdpersonfemale.setValue(ThirdPersonFemale);
        request.addProperty(thirdpersonfemale);


        PropertyInfo thirdpersonboth = new PropertyInfo();
        thirdpersonboth.setName("numberOfThirdPersonBoth");
        thirdpersonboth.setType(String.class);
        thirdpersonboth.setValue(ThirdPersonBoth);
        request.addProperty(thirdpersonboth);


        PropertyInfo daughtersson = new PropertyInfo();
        daughtersson.setName("numberOfDaughtersSon");
        daughtersson.setType(String.class);
        daughtersson.setValue(DaughtersSon);
        request.addProperty(daughtersson);

        PropertyInfo daughtersdaughter = new PropertyInfo();
        daughtersdaughter.setName("numberOfDaughtersDaughter");
        daughtersdaughter.setType(String.class);
        daughtersdaughter.setValue(DaughtersDaughter);
        request.addProperty(daughtersdaughter);


        PropertyInfo daughtersdaughtersson = new PropertyInfo();
        daughtersdaughtersson .setName("numberOfDaughtersDaughtersSon");
        daughtersdaughtersson .setType(String.class);
        daughtersdaughtersson .setValue(DaughtersDaughtersSon);
        request.addProperty(daughtersdaughtersson);

        PropertyInfo fullnephew = new PropertyInfo();
        fullnephew .setName("numberOfFullNephew");
        fullnephew .setType(String.class);
        fullnephew.setValue(FullNephew);
        request.addProperty(fullnephew);

        PropertyInfo fullniece = new PropertyInfo();
        fullniece .setName("numberOfFullNiece");
        fullniece.setType(String.class);
        fullniece.setValue(FullNiece);
        request.addProperty(fullniece);



        PropertyInfo daughtersdaughtersdaughter = new PropertyInfo();
        daughtersdaughtersdaughter.setName("numberOfDaughtersDaughtersDaughter");
        daughtersdaughtersdaughter.setType(String.class);
        daughtersdaughtersdaughter.setValue(DaughtersDaughtersDaughter);
        request.addProperty(daughtersdaughtersdaughter);

        PropertyInfo daughterssonsson = new PropertyInfo();
        daughterssonsson.setName("numberOfDaughtersSonsSon");
        daughterssonsson.setType(String.class);
        daughterssonsson.setValue(DaughtersSonsSon);
        request.addProperty(daughterssonsson);


        PropertyInfo grandson = new PropertyInfo();
        grandson.setName("numberOfGrandSon");
        grandson.setType(String.class);
        grandson.setValue(GrandSon);
        request.addProperty(grandson);


        PropertyInfo maternalgrandmother = new PropertyInfo();
        maternalgrandmother.setName("numberOfMaternalGrandMother");
        maternalgrandmother .setType(String.class);
        maternalgrandmother .setValue(MaternalGrandMother);
        request.addProperty(maternalgrandmother);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);


        try {

            httpTransport.call(SOAP_ACTION, envelope);
            final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            r = response.toString();

        } catch (Exception exception) {
            r = exception.toString();
        }

        return r;



    }

    @Override
    protected void onPostExecute(String s) {

        Intent p=new Intent(x,calculateinheritance.class);

        p.putExtra("result",s.toString());

        p.putExtra("username",username);

        p.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        x.startActivity(p);


    }
}
