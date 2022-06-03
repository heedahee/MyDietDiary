package com.example.mydietdiary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    Button btn1, btn2, btn3;
    EditText et;
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MDD");
        dp = findViewById(R.id.dp);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        et = findViewById(R.id.et);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, secondActivity.class);
                startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, thirdActivity.class);
                startActivity(intent2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, fourActivity.class);
                startActivity(intent3);
            }
        });
        Calendar sss = Calendar.getInstance();
        int cy = sss.get(Calendar.YEAR);
        int cm = sss.get(Calendar.MONTH);
        int cd = sss.get(Calendar.DAY_OF_MONTH);
    }
}
