package com.cookandroid.project6_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtUrl;
    Button btnGo,btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = (EditText)findViewById(R.id.edtUrl);
        btnGo = (Button)findViewById(R.id.btnGo);
        btnBack = (Button)findViewById(R.id.btnBack);
        web = (WebView)findViewById(R.id.webView1);

        web.setWebViewClient(new WebViewClient());

        WebSettings webset = web.getSettings();
        webset.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl(edtUrl.getText().toString());
            }
        });// btnGo

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });//btnBack
    }

    class WebViewClient extends android.webkit.WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }//Web
}
//
//public class MainActivity extends AppCompatActivity {
//    EditText etUrl;
//    Button btnMove, btnBack;
//    WebView web;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        etUrl = (EditText) findViewById(R.id.etUrl);
//        btnMove = (Button) findViewById(R.id.btnMove);
//        btnBack = (Button) findViewById(R.id.btnBack);
//        web = (WebView) findViewById(R.id.webView);
//        web.setWebViewClient(new CookWebViewClient());
//
//        WebSettings webSet = web.getSettings();
//        webSet.setBuiltInZoomControls(true);
//        webSet.setJavaScriptEnabled(true);
//
//        btnMove.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                web.loadUrl(edtUrl.getText().toString());
//            }
//        });
//
//        btnBack.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                web.goBack();
//            }
//        });
//    }
//
//    class CookWebViewClient extends WebViewClient{
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            return super.shouldOverrideUrlLoading(view, url);
//        }
//    }
//}
