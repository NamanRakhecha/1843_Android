package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://www.google.com");

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        checkconnection();

    }

    public void checkconnection(){

        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = manager.getActiveNetworkInfo();
        if(null != activenetwork){
            if(activenetwork.getType()==ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, " Wifi Enabled ", Toast.LENGTH_SHORT).show();
            }
            else if(activenetwork.getType()==ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this, " Data Pack Enabled ", Toast.LENGTH_SHORT).show();
            }
            }

        else{
            Toast.makeText(this, " No Data ", Toast.LENGTH_SHORT).show();
            }
        }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

}