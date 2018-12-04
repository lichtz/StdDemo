package com.example.licht.cachedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class BitmapCompressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_compress);
    }

    public void quilityCom(View view) {

        BitmapFactory.Options options = new BitmapFactory.Options();

        Bitmap bitmap = BitmapFactory.decodeFile("", options);
        compressImageToFile(bitmap,new File(""));
    }
    public  static void compressImageToFile(Bitmap bmp, File file){
//        bmp.compress(Bitmap.CompressFormat.WEBP,100,out)

    }
}
