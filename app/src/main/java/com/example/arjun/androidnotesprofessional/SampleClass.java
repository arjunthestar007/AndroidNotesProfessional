package com.example.arjun.androidnotesprofessional;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class SampleClass {

    MyCustomListener myCustomListener;

    public SampleClass() {
        this.myCustomListener = null;
    }

    public void setMyCustomListener(MyCustomListener myCustomListener) {
        this.myCustomListener = myCustomListener;
    }

    public void doSomething() {
        fetchImages();
    }

    private void fetchImages() {
        if (myCustomListener != null) {

            String bitmap = null;
            List<Bitmap> bitmapList = new ArrayList<>();

            if (bitmap == null) {
                myCustomListener.onFailure("null");
            } else {
                myCustomListener.onSuccess(bitmapList);

            }

        }
    }

}
