package com.example.mydietdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

public class four_kActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_k);
        setTitle("K - POP PLAYLIST");


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final String[]mid = {"LOVE DIVE - 아이브","INVU - 태연", "MY BAG - 아이들","팡파레 - 다비치", "POSE - 이달의 소녀",
                "TOMBOY - 아이들",  "SMILEY - 예나","Bad - 인피니트","이루리 - 우주소녀"};

        ListView list = (ListView) findViewById(R.id.listview1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mid);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), mid[arg2],
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

}

