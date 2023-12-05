package com.example.vize;

import static com.example.deneme.R.id.counTextField;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.params.MeteringRectangle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import android.os.Bundle;
import android.widget.Toast;

public class Random extends AppCompatActivity {

    private EditText number,min,max;
    private TextView sonuc;
    private Button olustur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        Button backButton = findViewById(R.id.backBtnRandom);
        Button createButtom = findViewById(R.id.btnCreate);
        EditText countTextField = (EditText) findViewById(R.id.counTextField);
        EditText maxTextField = findViewById(R.id.maxTextField);
        EditText minTextField = findViewById(R.id.minTextField);
        LinearLayout mainLayout = findViewById(R.id.mainLayout);

        //scroll ve layout olusturuyoruz
        ScrollView scrollView = new ScrollView(this);
        LinearLayout scrollLinearLayout = new LinearLayout(this);
        scrollLinearLayout.setOrientation(LinearLayout.VERTICAL);
        //scrollviewa layoutu ekliyoruz
        scrollView.addView(scrollLinearLayout);


        //back butonu dinleme basılırsa geri dönme işlemi icinde yapılacak
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //burada ıntent olusturup aktifleştiriyoruz ıntentım aldıgı parametreler 1.si = güncel view 2.si hedef view

                Intent intent = new Intent(Random.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //create button dinleme
        createButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adet textfieldından değeri alıp inte cevirdik
                String countString = countTextField.getText().toString();
                int count = Integer.parseInt(countString);
                //aynı işlemi yaptık string -> int
                String minString = minTextField.getText().toString();
                int min = Integer.parseInt(minString);
                //aynı işlemi yaptık string -> int
                String maxString = maxTextField.getText().toString();
                int max = Integer.parseInt(maxString);
                //random sayı uretmek için nesne olusturduk
                Random rnd  = new Random();


                for (int i = 0 ; i <count ; i++ ){
                    //isimlendirme yanlıs yapılmıs iki row bir column olacak normalde
                    //layout nesnelerimizi üretiyoruz

                    LinearLayout sutunbir = new LinearLayout(Random.this);
                    LinearLayout columnbir = new LinearLayout(Random.this);
                    LinearLayout columniki = new LinearLayout(Random.this);
                    sutunbir.setOrientation(LinearLayout.VERTICAL);
                    columnbir.setOrientation(LinearLayout.HORIZONTAL);
                    columniki.setOrientation(LinearLayout.HORIZONTAL);
                    //viewda ki random min değer için bir adet view max için bir view ayarlıyoruz
                    TextView textView = new TextView(Random.this);
                    TextView textView2 = new TextView(Random.this);
                    //progress barımızı da ayarladık
                    ProgressBar progressBar2 = new ProgressBar(Random.this, null, android.R.attr.progressBarStyleHorizontal);
                    //max ve min değer arasında üretilen random sayı için bir adet view
                    TextView textView3 = new TextView(Random.this);

                    //verilen aralıkta iki adet random sayı ürettik
                    int randomValueOne = rnd.nextInt(max - min + 1) + min;
                    int randomValueTwo= rnd.nextInt(max - min + 1) + min;


                    int maxValue  ;
                    int minValue ;

                    //üretilen sayıların büyüklük kucukluk kontrolunu yapıp min ve max değişkenlerine atadık
                    if(randomValueOne>randomValueTwo){
                        maxValue = randomValueOne;
                        minValue = randomValueTwo ;
                    }
                    else if (randomValueOne<randomValueTwo){
                        maxValue = randomValueTwo ;
                        minValue = randomValueOne ;
                    }
                    else {
                        maxValue = randomValueTwo ;
                        minValue = randomValueOne ;
                    }

                    //olusan yeni min max aralıgında yeni bir random sayı urettik
                    int randomNumber= rnd.nextInt(maxValue - minValue + 1) + minValue;
                    //bu sayının progressbarda ne kadar yer dolduracagını yuzdelik olarak hesapladıl
                    double percent = (double)((randomNumber-minValue)*100)/(maxValue-minValue);
                    int maxProgress = 100;
                    //progressbarı doldurduk
                    int progressValue = (int) ((percent / 100.0) * maxProgress);

                    //uretilen sayıyı ve yuzde oranını textviewa yazdık
                    textView.setText(Integer.toString(randomNumber) + " = %" + Double.toString(percent));
                    //textviewı columna ekledik
                    columnbir.addView(textView);


                    textView2.setText("Min:"+Integer.toString(minValue));
                    columniki.addView(textView2);

                    //progressbarı doldurduk
                    progressBar2.setProgress(progressValue);
                    columniki.addView(progressBar2);

                    textView3.setText("max :"+Integer.toString(maxValue));
                    columniki.addView(textView3);

                    sutunbir.addView(columnbir);
                    sutunbir.addView(columniki);

                    scrollLinearLayout.addView(sutunbir);




                }
                mainLayout.addView(scrollView);



            }
        });

    }

    private int nextInt(int i) {
        return 0;
    }
}