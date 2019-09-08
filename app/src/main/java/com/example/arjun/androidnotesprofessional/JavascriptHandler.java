package com.example.arjun.androidnotesprofessional;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JavascriptHandler {
    Context mContext;

    public JavascriptHandler(Context mContext) {
        this.mContext = mContext;
    }

    private static final String TAG = "JavascriptHandler";
    /**
     *  Key point here is the annotation @JavascriptInterface
     *
     */
    @JavascriptInterface
    public void jsCallback() {
        Toast.makeText(mContext, "jsCallback", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "jsCallback: ");

    }
    @JavascriptInterface
    public void jsCallbackTwo(String dummyData) {
        Toast.makeText(mContext, dummyData, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "jsCallbackTwo: ");
    }
}
