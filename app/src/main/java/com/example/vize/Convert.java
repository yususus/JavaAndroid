package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

public class Convert extends AppCompatActivity {


    private EditText userInput, userInput2, userInput3;
    private TextView resultTextView, resultTextView2, resultTextView3;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);


        userInput = findViewById(R.id.textInput1);
        resultTextView = findViewById(R.id.result1);
        Spinner spinner = findViewById(R.id.spinner1);


        List<String> categories = new ArrayList<>();
        categories.add("SEÇİM YAPINIZ");
        categories.add("ikilik");
        categories.add("sekizlik");
        categories.add("onAltılık");

        ArrayAdapter<String> verilistesi = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        verilistesi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(verilistesi);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedCategory = categories.get(position);

                String userInputValue = userInput.getText().toString();

                convertAndDisplayResult(userInputValue, selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        //ikinci kısım
        userInput2 = findViewById(R.id.textInput2);
        resultTextView2 = findViewById(R.id.result2);
        Spinner spinner2 = findViewById(R.id.spinner2);

        //kilo byte, byte, kibi byte ve
        List<String> categories2 = new ArrayList<>();
        categories2.add("seçim yapınız");
        categories2.add("kiloByte");
        categories2.add("byte");
        categories2.add("kibiByte");


        ArrayAdapter<String> verilistesi2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories2);
        verilistesi2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(verilistesi2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedCategory2 = categories2.get(position);

                String userInputValue2 = userInput2.getText().toString();

                convertAndDisplayResult2(userInputValue2, selectedCategory2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //üçüncü kısım
        userInput3 = findViewById(R.id.textInput3);
        resultTextView3 = findViewById(R.id.result3);
        radioGroup = findViewById(R.id.radioGrup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int radioGrup) {

                RadioButton tiklananButon = findViewById(radioGrup);

                String conversionType = tiklananButon.getText().toString();

                String userInputValue3 = userInput3.getText().toString();

                convertAndDisplayResult3(userInputValue3, conversionType);
            }
        });
    }


    //metotlar
    private void convertAndDisplayResult(String userInputValue, String selectedCategory){
        if(userInputValue.isEmpty()){
            Toast.makeText(getApplicationContext(),"Boş değer döndürülemez", Toast.LENGTH_SHORT ).show();
            return;
        }

        try {
            int decimalNumber = Integer.parseInt(userInputValue);
            String result = "";
            switch (selectedCategory){
                case "ikilik":
                    result = Integer.toBinaryString(decimalNumber);
                    break;
                case "sekizlik":
                    result = Integer.toOctalString(decimalNumber);
                    break;
                case "onAltılık":
                    result = Integer.toHexString(decimalNumber);
                    break;
            }
            resultTextView.setText(result);


        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "ınteger bir sayı giriniz", Toast.LENGTH_SHORT).show();
        }
    }

    //ikinci kısım
    private void convertAndDisplayResult2(String userInputValue2, String selectedCategory2){
        if(userInputValue2.isEmpty()){
            Toast.makeText(getApplicationContext(),"boş değer döndürülemez", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int decimalNumber2 = Integer.parseInt(userInputValue2);
            String result2 = "";
            switch (selectedCategory2){
                case "kiloByte":
                    double kilobyte = decimalNumber2 * 1024;
                    result2 = String.valueOf(kilobyte);
                    break;
                case "byte":
                    double bytee = decimalNumber2 * 1024 *1024;
                    result2 = String.valueOf(bytee);
                    break;
                case "kibiByte":
                    double kibibyte = decimalNumber2 * 1000;
                    result2 = String.valueOf(kibibyte);
                    break;
            }
            resultTextView2.setText(result2);

        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"ınteger bir sayı giriniz", Toast.LENGTH_SHORT).show();
        }
    }
//ucuncu kısım
    private void convertAndDisplayResult3(String userInputValue3, String conversionType){
        if(userInputValue3.isEmpty()){
            Toast.makeText(getApplicationContext(),"lutfen boş deger girmeyin", Toast.LENGTH_SHORT).show();
            return;
        }


        try{
            double tempature = Double.parseDouble(userInputValue3);
            String result3 = "";

            if(conversionType.equals("Celsius to Fahrenheit")){
                double fahrenayt = (tempature * 9/5) + 32;
                result3 = String.valueOf(fahrenayt);
            } else if (conversionType.equals("Celsius to Kelvin")) {
                double kelvin = tempature + 273.15;
                result3 = String.valueOf(kelvin);
            }

            resultTextView3.setText(result3);


        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Double sayı giriniz", Toast.LENGTH_SHORT).show();
        }
    }



}