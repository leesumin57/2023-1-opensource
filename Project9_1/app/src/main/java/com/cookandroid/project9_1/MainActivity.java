package com.cookandroid.project9_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 전역상수 선언, 메뉴에서 선택한 것이 선인지 원인지를 구분하기 위해 사용할 것
    final static int LINE = 1, CIRCLE = 2;
    static int curShape = LINE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case 1 :
                curShape = LINE;    // 선
                return true;
            case 2 :
                curShape = CIRCLE;  // 원
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        // 시작점과 끝점 좌표를 저장히기 위한 클래스 멤버 변수 4개를 선언
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                // 처음 터치했을 때가 선의 시작점이나 원의 중심점이 되는데 이 위치를 기억
                case MotionEvent.ACTION_DOWN :
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                // 화면을 터치한 상태에서 드래그하는 것은 ACTION_MOVE에 해당
                case MotionEvent.ACTION_MOVE :
                    // 화면에서 손가락을 떼면 발생
                case MotionEvent.ACTION_UP :
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    // invalidate( )를 호출하면 화면이 무효화되고
                    // onDraw( ) 메서드를 자동으로 실행
                    this.invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            // 선의 두께
            paint.setStrokeWidth(5);
            // 채우기 여부
            paint.setStyle(Paint.Style.STROKE);
            // 선의 색상
            paint.setColor(Color.RED);

            switch (curShape) {
                case LINE :
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE :
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                            + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
            }
        }
    }
}