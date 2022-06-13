package com.example.mydietdiary;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
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
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    DatePicker dp;
    EditText et;
    Button btnback, btn1;
    String filename;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setTitle("하루일기 작성 화면");
        setContentView(R.layout.second);
        dp = findViewById(R.id.dp);
        et = findViewById(R.id.et);
        btnback = findViewById(R.id.btnback);
        btn1 = findViewById(R.id.btn1);

        Calendar sss = Calendar.getInstance();
        int cy = sss.get(Calendar.YEAR);
        int cm = sss.get(Calendar.MONTH);
        int cd = sss.get(Calendar.DAY_OF_MONTH);

        //데이터 베이스 불러옴, 테이블 생성
        myHelper = new myDBHelper(this);
        filename = Integer.toString(cy) + "_" + Integer.toString(cm + 1) + "_" + Integer.toString(cd);
        String str = readDiary(filename);
        et.setText(str);
        btn1.setEnabled(true);

        dp.init(cy, cm, cd, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                filename = Integer.toString(i) + "_" + Integer.toString(i1+1) + "_" + Integer.toString(i2);
                String str = readDiary(filename);
                et.setText(str);
                btn1.setEnabled(true);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("UPDATE myDiary SET content = '"
                        + et.getText().toString()
                        +"'WHERE diaryDate ='" + filename + ";'");
                sqlDB.close();
                btn1.setText("수정하기");
                Toast.makeText(getApplicationContext(),"저장됨",Toast.LENGTH_LONG).show();
            }

        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super(context,"myDB",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE myDiary(diaryDate char(10),content varchar(500));");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS myDiary;");
            onCreate(db);
        }
    }
    String readDiary(String fName){
        String diaryDate = null;
        String diaryContent = null;
        try {
            sqlDB = myHelper.getReadableDatabase();
            Cursor cursor;
            cursor = sqlDB.rawQuery("SELECT * FROM myDiary WHERE diaryDate = '"
            +fName+"';",null);
            while (cursor.moveToNext()){
                diaryDate = cursor.getString(0);
                diaryContent = cursor.getString(1);
            }
            if (diaryContent == null){
                et.setHint("일기 없음");
                btn1.setText("새로 저장");
                if(diaryDate != fName){
                    sqlDB.execSQL("INSERT INTO myDiary VALUES('"+fName+"',"+null+");");
                            return diaryContent;
                }
            }
            btn1.setText("수정하기");
            cursor.close();
            sqlDB.close();
        }catch (SQLiteException e){
            Toast.makeText(getApplicationContext(),"에러 발생",Toast.LENGTH_SHORT).show();
        }
        return diaryContent;
    }
}

