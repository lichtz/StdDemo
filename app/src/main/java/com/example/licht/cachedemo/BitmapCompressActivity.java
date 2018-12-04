package com.example.licht.cachedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    public static void comprssBitmapSize(Bitmap bmp,File file) {
        Bitmap result = Bitmap.createBitmap(bmp.getWidth() / 2, bmp.getHeight() / 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        RectF rectF = new RectF(0, 0, bmp.getWidth() / 2, bmp.getHeight() / 2);
        canvas.drawBitmap(bmp,null,rectF,null);
//        result.compress()

    }

}
