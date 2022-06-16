package com.example.mydietdiary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class four_mainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("PLAY LIST");
        setContentView(R.layout.four_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btnback = findViewById(R.id.btnback);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(four_mainActivity.this, four_kActivity.class);
                startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/thankyoububu"));
                startActivity(urlintent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(four_mainActivity.this, four_pActivity.class);
                startActivity(intent3);
            }

        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}