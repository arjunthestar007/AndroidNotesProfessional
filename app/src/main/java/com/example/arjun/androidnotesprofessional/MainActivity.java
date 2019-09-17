package com.example.arjun.androidnotesprofessional;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.textview1);

//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i < 5; i++) {
//                    try {
//                        Thread.sleep(5000);
//                        mTextView.setText(String.valueOf(i));
//
//                    } catch ( InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        final int finalI = i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText((int) SystemClock.currentThreadTimeMillis());

                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();




    }
}
