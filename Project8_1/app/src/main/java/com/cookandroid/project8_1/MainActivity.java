package com.cookandroid.project8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

@SuppressWarnings("deprecation")

/*
1. activity_main.xml의 텍스트뷰를 에디트텍스트로 변경
2. <여기를 클릭>을 클릭 시, activity_main.xml의 에디트 텍스트 내용이
대화상자의 에디트 텍스트에 나타나게 한다
3. 대화상자에서 <확인>을 클릭시, 대화상자의 에디트텍스트 내용이
activity_main.xml의 에디트텍스트 내용으로 변겨오디게 한다
4.대화상자에서 <취소> 클릭시 토스트가 화면 임의 위치에 나타나게 한다.
*/
public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    Button button1;
    EditText edtDiary;
    String FileName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        button1 = (Button) findViewById(R.id.button1);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker,
                                      int i, int i1, int i2) {
                FileName = Integer.toString(i) + "_" +
                        Integer.toString(i1 + 1) + "_" +
                        Integer.toString(i2) + ".txt";

                String str = readDiary(FileName);
                edtDiary.setText(str);
                button1.setEnabled(true);
            }
        });

//readDiary에 의해 수정하기 또는 저장하기로 보이는 파일
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(FileName,
                            Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();

                    Toast.makeText(getApplicationContext(), FileName +
                            "이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });
    }

    String readDiary(String fName) {
        String diaryStr=null;
        FileInputStream inFs;
        try {
            inFs=openFileInput(fName);
            byte[] txt= new byte[500];
            inFs.read(txt);
            inFs.close();

//읽어온 txt를 문자열로 변경 후, trim()메소드를 통해
//앞뒤의 공백 제거, 반환할 dairyStr에 대입.
//현재는 일기가 있는 상태이므로, 화면 버튼 글자를
//수정하기로 변경
            diaryStr=(new String(txt)).trim();
            button1.setText("수정하기");
        }
        catch(IOException e){
//일기가 있다면 일기 내용 반환, 없다면 새로저장으로 변경
            edtDiary.setHint("일기 없음");
            button1.setText("새로 저장");
        }
//일기 파일 있다면 일기 내용이 반환, 없다면 null이 반환될 것
        return diaryStr;
    }
}
/*
파일을 직접 보는 방법: 오른쪽 아래의 Device File EXPLORER탭 클릭.
DATA-DATA-com.cookandroid.profect..-files 확장시, 생성한 일기파일 목록이 보임
*/