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

public class four_hActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_h);
        setTitle("HIP - HOP PLAYLIST");


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final String[] mid = {"LOVE me - 비오", "먹색의 별 - 디핵", "비누 - 비비", "인생네컷 - Gist", "꽃다운 나이 - 릴러말즈", "로켓 - 송민호",
               "불협화음 - Mudd the student", "만남은 쉽고 이별은 어려워 - 베이식", "해변 - B.I"};
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

