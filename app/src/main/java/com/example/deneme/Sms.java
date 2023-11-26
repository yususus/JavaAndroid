package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SubscriptionManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.telephony.SmsManager;
import android.app.PendingIntent;
import android.widget.Toast;

public class Sms extends AppCompatActivity {
    private EditText userNumber, userMessage;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);





        userNumber = findViewById(R.id.phoneNumber);
        buttonSend = findViewById(R.id.send);
        userMessage = findViewById(R.id.messageText);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında yapılacak işlemler
                if(ContextCompat.checkSelfPermission(Sms.this, Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED){
                    //metod oluşturalım

                    sendSMS();
                }else {
                    //izin alınmazsa
                    ActivityCompat.requestPermissions(Sms.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//sistem çalışıyor mu kontrol edelim
        if(requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //metodu çağıralım

            sendSMS();
        }else {
            Toast.makeText(this,"izin reddildi",Toast.LENGTH_SHORT).show();
        }
    }

    private void sendSMS() {
        //string Formunda verileri alalım
        String phone = userNumber.getText().toString();
        String message = userMessage.getText().toString();

        //ifadeler boş mu dolu kontrol edelim
        if(!phone.isEmpty() && !message.isEmpty()){
            SmsManager smsManager = SmsManager.getDefault();
            //mesaj gönder
            smsManager.sendTextMessage(phone,null,message,null,null);
            //popup mesaj
            Toast.makeText(this,"gönderim başarılı", Toast.LENGTH_SHORT).show();
        }else {
            //göndermezse
            Toast.makeText(this,"başarısız oldu", Toast.LENGTH_SHORT).show();
        }
    }


}