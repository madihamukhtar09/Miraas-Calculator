package com.example.madiha.fyp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.ksoap2.transport.HttpTransportSE;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;


/**
 * Created by madiha on 1/6/2018.
 */

public class C_login  extends AsyncTask<String,String,String> {

    public final String SOAP_ACTION = "http://tempuri.org/login";

    public  final String OPERATION_NAME = "login";

    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

    public String webservice;

    Context x;

    String r="";

    String username;

    String password;

    public C_login(Context x,String username,String password)
    {
        this.username=username;

        this.password=password;

        this.x=x;

    }

    @Override
    protected String doInBackground(String... params) {
        String SOAP_ADDRESS ="http://412f80ec.ngrok.io/Rules.asmx";
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, OPERATION_NAME);

        PropertyInfo ss = new PropertyInfo();
        ss.setName("username");
        ss.setType(String.class);
        ss.setValue(username);

        request.addProperty(ss);

        PropertyInfo s = new PropertyInfo();
        s.setName("password");
        s.setType(String.class);
        s.setValue(password);
        request.addProperty(s);




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
        Toast.makeText(x,s.toString(), Toast.LENGTH_LONG).show();
    }
}





