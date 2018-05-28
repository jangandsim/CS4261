package com.example.jang0.summergt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {

    Button buttonSend;
    EditText textPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        buttonSend = findViewById(R.id.button1);
        textPhoneNo = findViewById(R.id.phone);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String lat = intent.getStringExtra("lat");
                String lon = intent.getStringExtra("lon");
                String phoneNo = textPhoneNo.getText().toString();
                String sms = "HELP me I am at  Latitude: " + lat +  "   " + "Longitude: " + lon;
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"SMS faild, please try again later!",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                Intent intent2 = new Intent(SMSActivity.this, MapsActivity.class);
                startActivity(intent2);
            }
        });
    }
}
