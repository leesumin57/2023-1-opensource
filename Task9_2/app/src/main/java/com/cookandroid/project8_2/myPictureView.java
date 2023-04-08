package com.cookandroid.project8_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {
    String imagePath=null;
//myPictrueView에 보여줄 이미지 파일의 경로 및 파일 이름 저장 변수

    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
//imagePath에 값이 있으면(경로 및 파일 이름이 이미지파일에 지정되엇다면)
//화면에 그림파일을 출력
        if(imagePath!=null) {
            Bitmap bitmap= BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap, 0, 0, null);
            bitmap.recycle();
        }
    }
}