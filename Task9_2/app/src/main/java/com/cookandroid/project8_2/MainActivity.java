package com.cookandroid.project8_2;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;

@SuppressWarnings("deprecation")
/*
sd카드 특정 폴더의 이미지 파일을 보여주는 간단한 이미지 뷰어
기본제공 위젯만으로는 해결 불가. 커스텀위젯을 만들어,
activity_mail.xml에 넣는다.
여기서 만들 커스텀 위젯은, 지정된 이미지 파일을 출력하는 역할을 맡음.

그림파일을 sd카드에 넣어둔 다음, device file explorer에서 sdcard/pictures에 사진을 넣어둔다.
androidManifest.mxl파일에 sd카드를 사용할 수 있도록 퍼미션을 지정하자.

직풀은, 위의 실습을, 버튼 사이에 "현 그림 번호/전체 그림 개수" 텍스트뷰가
나타나게 한다.
토스트메시지를 없애고, 첫번째 그림에서 이전 그림을 클릭시 마지막 그림이, 마지막 그림에서
다음 그림을 클릭시 첫번째 그림이 나오게 한다.
*/
public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum;
    File[] imageFiles;
    String imageFname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[] {Manifest
                .permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

//sd카드에서 파일을 읽어 listFiles()로 배열을 만들고
//첫 번째 파일의 이름을 추출해 mypictures 클래스의 imagepathd에 전달.
//그럼 첫번째 그림이 화면에 출력된다.
        imageFiles = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/Pictures").listFiles();
        imageFname=imageFiles[0].toString();
        myPicture.imagePath=imageFname;


        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum <= 0) {
                    Toast.makeText(getApplicationContext(), "첫번째 그림입니다",
                            Toast.LENGTH_SHORT).show();
                } else {
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum >=imageFiles.length-1) {
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다",
                            Toast.LENGTH_SHORT).show();
                } else {
                    curNum++;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                }
            }
        });
    }
}