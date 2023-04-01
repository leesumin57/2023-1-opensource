package com.cookandroid.project7_2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btnBackgroundChange, btnButtonChange;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        btnBackgroundChange = (Button) findViewById(R.id.btnBackgroundChange);
        registerForContextMenu(btnBackgroundChange);
        btnButtonChange = (Button) findViewById(R.id.btnButtonChange);
        registerForContextMenu(btnButtonChange);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if(v == btnBackgroundChange){
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if(v == btnButtonChange){
            mInflater.inflate(R.menu.menu2, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.menuGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menuBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                btnBackgroundChange.setRotation(45);
                return true;
            case R.id.subSizeUP:
                btnButtonChange.setScaleX(2);
                return true;
        }
        return false;
    }
}


