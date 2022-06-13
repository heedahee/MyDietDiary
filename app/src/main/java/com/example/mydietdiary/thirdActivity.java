package com.example.mydietdiary;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class thirdActivity extends AppCompatActivity {
    private EditText height, weight;
    Button btnback, btn1;
    TextView resulttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI 계산기");
        setContentView(R.layout.third);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resulttext = findViewById(R.id.result);
        btnback = findViewById(R.id.btnback);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void bmi(){
        float a,b,c;
        a = Float.parseFloat(height.getText().toString()) / 100;
        b = Float.parseFloat(weight.getText().toString());
        c = b / (a*a);
        resulttext.setText(""+c);
        if (c < 18.5) {
            Toast.makeText(getApplicationContext(), "저체중", Toast.LENGTH_LONG).show();
        } else if (c >= 18.5 && c <= 24.9) {
            Toast.makeText(getApplicationContext(), "정상 체중", Toast.LENGTH_LONG).show();
        } else if (c >= 25 && c<= 29.9) {
            Toast.makeText(getApplicationContext(), "과체중", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(getApplicationContext(), "비만", Toast.LENGTH_LONG).show();
    }
}
