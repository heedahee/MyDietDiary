package com.example.mydietdiary;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView today;
    Button btn1, btn2, btn3;
    EditText et;
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MDD");
        calendarView = findViewById(R.id.calendarView);
        today = findViewById(R.id.today);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        et = findViewById(R.id.et);

        DateFormat formatter = new SimpleDateFormat("yyyy년MM월dd일");
        Date date = new Date(calendarView.getDate());
        today.setText(formatter.format(date));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth){
                    String day;
                    day = year + "년" + (month+1) + "월" + dayOfMonth + "일";
                    today.setText(day);
                }
        });

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
                Intent intent3 = new Intent(MainActivity.this, four_mainActivity.class);
                startActivity(intent3);
            }
        });

    }
}
