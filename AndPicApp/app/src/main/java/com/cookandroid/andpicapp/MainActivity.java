package com.cookandroid.andpicapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    Switch swiAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog,rdoCat,rdoRabbit;
    Button btnOK ,btn1,btn2;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        swiAgree = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.Rdocat);
        rdoRabbit = (RadioButton) findViewById(R.id.Rdorabbit);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        imgPet = (ImageView) findViewById(R.id.Imgpet);

        swiAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(swiAgree.isChecked()==true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                else
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.q);
                        break;
                    case R.id.Rdocat:
                        imgPet.setImageResource(R.drawable.r);
                        break;
                    case R.id.Rdorabbit:
                        imgPet.setImageResource(R.drawable.s);
                        break;
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swiAgree.setChecked(false);
            }
        });


    }
}