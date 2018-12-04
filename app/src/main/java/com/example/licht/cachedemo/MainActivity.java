package com.example.licht.cachedemo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.http.HttpResponseCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "HTTP_CACHE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void request(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL("http://123.207.23.225:3080").openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.connect();
                        InputStream inputStream = connection.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                        Log.d(TAG, "run: br"+br.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    public void openCache(View view) {
//        服务器要加上 缓存时间 response.addHeader("Cache-control","max-age=5")
        File cacheDir = new File(getCacheDir().getAbsoluteFile(), "http");
        if (!cacheDir.exists()){
            boolean mkdirs = cacheDir.mkdirs();
            if (!mkdirs){
                Log.d(TAG, "openCache: "+"create catalongue  error");
                return;
            }
        }
        long maxSize = 10*1024*1024;
        try {
            HttpResponseCache.install(cacheDir,maxSize);
            Log.d(TAG, "openCache: "+"打开缓存");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void request2(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   HttpURLConnection  url = (HttpURLConnection) new URL("http://123.207.23.225:8080/tomcat.png").openConnection();
                    url.setRequestMethod("GET");
                    url.setDoInput(true);
                    url.connect();

                    BitmapFactory.decodeStream(  url.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    public void deletecache(View view) {
        HttpResponseCache installed = HttpResponseCache.getInstalled();
        if (installed != null){
            try {
                installed.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bitMapCom(View view) {
        startActivity(new Intent(this,BitmapCompressActivity.class));
    }
}
