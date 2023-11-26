package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;

public class Converted extends AppCompatActivity {

    private TextView resultTextView;
    private EditText userInput;
    private EditText userInput2;
    private TextView resultTextView2;

    private EditText inputTemperature;
    private  TextView resultTextView3;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converted);

        userInput = findViewById(R.id.textInput);
        resultTextView = findViewById(R.id.result1);
        Spinner spinner = findViewById(R.id.spinner);

        // Spinner için veri listesini oluşturun
        List<String> categories = new ArrayList<>();
        categories.add("Seçim yapınız");
        categories.add("Binary");
        categories.add("Octal");
        categories.add("Hexadecimal");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        // Spinner üzerinde seçim yapıldığında gerçekleşecek olayları dinleyin
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Seçilen öğeyi alabilirsiniz
                String selectedCategory = categories.get(position);

                // Kullanıcının girdiği değeri alın
                String userInputValue = userInput.getText().toString();

                // Kullanıcının girdiği değeri ve seçilen kategoriye göre dönüşüm işlemini gerçekleştirin
                convertAndDisplayResult(userInputValue, selectedCategory);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Hiçbir şey seçilmediğinde yapılacak işlemler
            }
        });


//ikinci yapı
        userInput2 = findViewById(R.id.textInput2);
        resultTextView2 = findViewById(R.id.result2);
        Spinner spinner2 = findViewById(R.id.spinner2);



        List<String> categories2 = new ArrayList<>();
        categories2.add("seçim yapınız");
        categories2.add("Kilo Byte");
        categories2.add("Byte");
        categories2.add("Kibi Byte");
        categories2.add("Bit");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Seçilen öğeyi alabilirsiniz
                String selectedCategory2 = categories2.get(position);

                // Kullanıcının girdiği değeri alın
                String userInputValue2 = userInput2.getText().toString();

                // Kullanıcının girdiği değeri ve seçilen kategoriye göre dönüşüm işlemini gerçekleştirin
                convertAndDisplayResult2(userInputValue2, selectedCategory2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Hiçbir şey seçilmediğinde yapılacak işlemler
            }
        });

        //üçüncü yapı
        // RadioButton'lar için RadioGroup içinde bir olay dinleyici ekleyin
        inputTemperature = findViewById(R.id.textInput3);
        resultTextView3 = findViewById(R.id.result3);
        radioGroup = findViewById(R.id.radioGrup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int radioGrup) {
                // Seçilen RadioButton'ı bulun
                RadioButton selectedRadioButton = findViewById(radioGrup);

                // Seçilen RadioButton'ın metnini alın
                String conversionType = selectedRadioButton.getText().toString();

                // Kullanıcının girdiği sıcaklık değerini alın
                String inputTemperatureValue = inputTemperature.getText().toString();

                // Dönüşümü gerçekleştirip sonucu gösteren metodu çağırın
                convertAndDisplayResult3(inputTemperatureValue, conversionType);
            }
        });
    }

    // Kullanıcının girdiği değeri ve seçilen kategoriye göre dönüşüm işlemini gerçekleştiren metod
    private void convertAndDisplayResult(String userInputValue, String selectedCategory) {
        // Kullanıcının girdiği değeri kontrol edin (boş olup olmadığını, geçerli bir sayı olup olmadığını kontrol edebilirsiniz)
        if (userInputValue.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Lütfen bir sayı girin", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Girilen değeri integer'a çevirin
            int decimalNumber = Integer.parseInt(userInputValue);
            // Seçilen kategoriye göre dönüşüm işlemini gerçekleştirin
            String result = "";
            switch (selectedCategory) {
                case "Binary":
                    result = Integer.toBinaryString(decimalNumber);
                    break;
                case "Octal":
                    result = Integer.toOctalString(decimalNumber);
                    break;
                case "Hexadecimal":
                    result = Integer.toHexString(decimalNumber);
                    break;
            }
            // Sonucu TextView'e yazdırın
            resultTextView.setText(result);
        } catch (NumberFormatException e) {
            // Girilen değer bir sayıya çevrilemezse hata mesajı gösterin
            Toast.makeText(getApplicationContext(), "Geçerli bir sayı girin", Toast.LENGTH_SHORT).show();
        }
    }

//megaByte
    private void convertAndDisplayResult2(String userInputValue2, String selectedCategory2){
        if(userInputValue2.isEmpty()){
            Toast.makeText(getApplicationContext(), "Lütfen bir sayı girin", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            int decimalNumber2 = Integer.parseInt(userInputValue2);
            String result2 = "";
            switch (selectedCategory2) {
                case "Kilo Byte":
                    double kilobyte = decimalNumber2 * 1000;
                    result2 = String.valueOf(kilobyte);
                    break;
                case "Byte":
                    double byteValue = decimalNumber2 * 1024 *1024;
                    result2 = String.valueOf(byteValue);
                    break;
                case "Kibi Byte":
                    double kibiByte = decimalNumber2 * 1024;
                    result2 = String.valueOf(kibiByte);
                    break;
                case "Bit":
                    double bitValue = decimalNumber2 * 8 * 1024 * 1024;
                    result2 = String.valueOf(bitValue);
                    break;
            }
            resultTextView2.setText(result2);
        }catch (NumberFormatException e) {
            // Girilen değer bir sayıya çevrilemezse hata mesajı gösterin
            Toast.makeText(getApplicationContext(), "Geçerli bir sayı girin", Toast.LENGTH_SHORT).show();
        }
    }


    //derece
    // Kullanıcının girdiği değeri ve seçilen kategoriye göre dönüşüm işlemini gerçekleştiren metod
    // Sıcaklık dönüşümünü gerçekleştiren ve sonucu gösteren metod
    private void convertAndDisplayResult3(String inputTemperatureValue, String conversionType) {
        if (inputTemperatureValue.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Lütfen bir sıcaklık değeri girin", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double inputTemperature = Double.parseDouble(inputTemperatureValue);
            String result3 = "";

            if (conversionType.equals("Celsius to Fahrenheit")) {
                double fahrenayt = (inputTemperature * 9/5) +32;
                result3 = String.valueOf(fahrenayt);

            } else if (conversionType.equals("Celsius to Kelvin")) {
                double kelvin = inputTemperature + 273.15;
                result3 = String.valueOf(kelvin);

            }

            resultTextView3.setText(result3);

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Geçerli bir sıcaklık değeri girin", Toast.LENGTH_SHORT).show();
        }
    }
}