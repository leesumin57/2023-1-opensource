package com.cookandroid.animalpick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.TabActivity;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabSpec tabSpecFirst = tabHost.newTabSpec("First").setIndicator("강아지");
        tabSpecFirst.setContent(R.id.first);
        tabHost.addTab(tabSpecFirst);

        TabSpec tabSpecSecond = tabHost.newTabSpec("second").setIndicator("고양이");
        tabSpecSecond.setContent(R.id.second);
        tabHost.addTab(tabSpecSecond);

        TabSpec tabSpecThird = tabHost.newTabSpec("third").setIndicator("토끼");
        tabSpecThird.setContent(R.id.third);
        tabHost.addTab(tabSpecThird);

        TabSpec tabSpecFourth = tabHost.newTabSpec("Fourth").setIndicator("말");
        tabSpecFourth.setContent(R.id.Fourth);
        tabHost.addTab(tabSpecFourth);
        tabHost.setCurrentTab(0);
    }
}