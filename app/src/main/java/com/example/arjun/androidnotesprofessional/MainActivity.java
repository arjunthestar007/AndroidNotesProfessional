package com.example.arjun.androidnotesprofessional;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyCustomListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //two ways
        // implements listener
        SampleClass sampleClass = new SampleClass();
        sampleClass.setMyCustomListener(this);


        //anonymous inner class:
        SampleClass sampleClass1 = new SampleClass();
        sampleClass1.setMyCustomListener(new MyCustomListener() {
            @Override
            public void onSuccess(List<Bitmap> bitmapList) {

            }

            @Override
            public void onFailure(String error) {

            }
        });

        // set null
        sampleClass.setMyCustomListener(null);
    }

    @Override
    public void onSuccess(List<Bitmap> bitmapList) {

    }

    @Override
    public void onFailure(String error) {

    }
}
