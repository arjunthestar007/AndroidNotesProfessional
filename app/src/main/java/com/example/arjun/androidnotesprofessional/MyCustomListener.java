package com.example.arjun.androidnotesprofessional;

import android.graphics.Bitmap;

import java.util.List;

//In this interface, you can define messages, which will be send to owner.
public interface MyCustomListener {

    //In this case we have two messages,
    //the first that is sent when the process is successful.
    void onSuccess(List<Bitmap> bitmapList);

    //And The second message, when the process will fail.
    void onFailure(String error);
}
