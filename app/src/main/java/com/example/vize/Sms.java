package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity {
    private EditText userPhone, userMessage;
    private Button SendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        userPhone = findViewById(R.id.inputPhone);
        userMessage = findViewById(R.id.inputMessage);
        SendBtn = findViewById(R.id.send);


        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Sms.this, Manifest.permission.SEND_SMS) ==
                        PackageManager.PERMISSION_GRANTED){
                    sendSms();
                }else {
                    ActivityCompat.requestPermissions(Sms.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }


    private void sendSms() {
        String phone = userPhone.getText().toString();
        String message = userMessage.getText().toString();


        if(!phone.isEmpty() && !message.isEmpty()){
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phone,null, message,null,null);
            Toast.makeText(this,"gönderim başarılı", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"gönderim başarısız", Toast.LENGTH_SHORT).show();
        }
    }
}











