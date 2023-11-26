package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button randomButton = (Button) findViewById(R.id.random);

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Random.class);
                startActivity(intent);
            }
        });

        Button convertedButton = (Button) findViewById(R.id.converted);

        convertedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Converted.class);
                startActivity(intent);
            }
        });

        Button smsButton = (Button) findViewById(R.id.sms);

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sms.class);
                startActivity(intent);
            }
        });
     }
}