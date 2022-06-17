package com.example.mydietdiary;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class secondActivity extends AppCompatActivity {
    DatePicker dp;
    EditText et;
    Button btn, btn1;
    String filename;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setTitle("하루일기 작성 화면");
        setContentView(R.layout.second);
        dp = findViewById(R.id.dp);
        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);

        Calendar sss = Calendar.getInstance();
        int cy = sss.get(Calendar.YEAR);
        int cm = sss.get(Calendar.MONTH);
        int cd = sss.get(Calendar.DAY_OF_MONTH);

        dp.init(cy, cm, cd, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                filename = Integer.toString(i) + "_" + Integer.toString(i1) + "_" + Integer.toString(i2) + ".txt";
                String str = readDiary(filename);
                et.setText(str);
                btn.setEnabled(true);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = et.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), filename + "이 저장됨", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }  });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public String readDiary (String filename){
        String diaryStr = null;
        try {
            FileInputStream inFs = openFileInput(filename);
            byte[] txt = new byte[100];
            inFs.read(txt);
            inFs.close();
            String str = new String(txt);
            diaryStr = str.trim();
            btn1.setText("수정하기");
        } catch (IOException e) {
            et.setHint("작성된 내용 없음");
            btn1.setText("새로 저장");
        }
        return diaryStr;
    }
}
