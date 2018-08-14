package com.example.madiha.fyp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class rating extends AsyncTask<String,String,String> {


    public final String SOAP_ACTION = "http://tempuri.org/rating";

    public  final String OPERATION_NAME = "rating";

    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

    public String webservice;

    Context x;

    String r="";

    String userid;

    String rating;

    public rating(Context x,String userid,String rating)
    {
 this.userid=userid;
 this.rating=rating;


        this.x=x;

    }

    @Override
    protected String doInBackground(String... params) {
        String SOAP_ADDRESS = "http://412f80ec.ngrok.io/Rules.asmx";
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, OPERATION_NAME);

        PropertyInfo ss = new PropertyInfo();
        ss.setName("userid");
        ss.setType(String.class);
        ss.setValue(userid);

        request.addProperty(ss);

        PropertyInfo s = new PropertyInfo();
        s.setName("rating");
        s.setType(String.class);
        s.setValue(rating);
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
