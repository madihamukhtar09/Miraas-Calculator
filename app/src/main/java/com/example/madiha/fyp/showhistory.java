package com.example.madiha.fyp;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.icu.text.Normalizer2;
import android.os.AsyncTask;
import android.os.Bundle;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madiha on 1/9/2018.
 */

public class showhistory extends AsyncTask<String[],String,String> {





    public final String SOAP_ACTION = "http://tempuri.org/showhistory";

    public  final String OPERATION_NAME = "showhistory";

    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

    ArrayList<ModelH> fill=new ArrayList<ModelH>();

    String s;

    Context x;

    String username;

    public showhistory(Context x,String username)
    {
        this.x=x;


        this.username=username;

    }
     @Override
    protected String doInBackground(String[]... params) {
         String SOAP_ADDRESS ="http://412f80ec.ngrok.io/Rules.asmx";

        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, OPERATION_NAME);


         PropertyInfo ss = new PropertyInfo();
         ss.setName("username");
         ss.setType(String.class);
         ss.setValue(username);

         request.addProperty(ss);



        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);


        try {

            httpTransport.call(SOAP_ACTION, envelope);
            SoapObject response = (SoapObject) envelope.getResponse();

            for(int i=0;i<response.getPropertyCount();i++){
                ModelH d=new ModelH();
                d.Username=response.getProperty(i).toString();
                i++;
                d.input=response.getProperty(i).toString();
                i++;
                d.Result=response.getProperty(i).toString();
                i++;
                d.time=response.getProperty(i).toString();

                fill.add(d);



            }

          s="a";

        } catch (Exception exception) {
            String a = exception.toString();
        }




        return s;
    }


    @Override
    protected void onPostExecute(String s) {

        Intent l=new Intent(x,History.class);
        Bundle tt=new Bundle();
        tt.putSerializable("details",fill);
        l.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        l.putExtras(tt);
        x.startActivity(l);

    }
}
