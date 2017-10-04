package com.example.kishorebaktha.webview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText url;
    Button openurl;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openurl=(Button)findViewById(R.id.button);
        url=(EditText) findViewById(R.id.editText);
        web=(WebView)findViewById(R.id.web);
        openurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlv=url.getText().toString();
                web.getSettings().setLoadsImagesAutomatically(true);
                web.getSettings().setJavaScriptEnabled(true);
                web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                web.setWebViewClient(new WebViewClient());
                web.loadUrl(urlv);
            }
        });
        ActionBar ab=getSupportActionBar();
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.info_id:
                Toast.makeText(getApplicationContext(),"info icon selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_id:
                Toast.makeText(getApplicationContext(),"setting icon selected",Toast.LENGTH_SHORT).show();
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
