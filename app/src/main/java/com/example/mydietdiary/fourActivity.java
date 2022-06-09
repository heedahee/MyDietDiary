package com.example.mydietdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class fourActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    ListView listViewMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";
    MediaPlayer mplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);
        ActivityCompat.requestDragAndDropPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}.MODE_PRIVATE);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mplayer = new MediaPlayer();
                    mplayer.setDataSource(mp3Path + selectMP3);
                    mplayer.prepare();
                    mplayer.start();
                    btn1.setClickable(false);
                    btn2.setClickable(true);
                } catch (IOException e) {
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mplayer = new MediaPlayer();
                    mplayer.setDataSource(mp3Path + selectMP3);
                    mplayer.prepare();
                    mplayer.start();
                    btn4.setClickable(false);
                    btn5.setClickable(true);
                } catch (IOException e) {

                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final String[] mid = {"LOVE me - 비오", "Ballerino - 리쌍", "먹색의 별 - 디핵",
                "비누 - 비비", "인생네컷 - Gist", "꽃다운 나이 - 릴러말즈", "단추 - 릴러말즈"};
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
        final String[]mid2 = {"Dance Monkey - Tones And I","Every second - Mina Okabe", "Shut up - Mia Rodriguez",
                "Working - Tate McRae,Khalid", "Hold on - Justin Bieber", "Hey siri - salem ilese"};
        ListView list2 = (ListView) findViewById(R.id.listview2);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, mid2);
        list2.setAdapter(adapter2);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), mid2[arg2],
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

}

