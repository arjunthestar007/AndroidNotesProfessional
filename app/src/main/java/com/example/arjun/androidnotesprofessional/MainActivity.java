package com.example.arjun.androidnotesprofessional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.textview1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String buildDate = dateFormat.format(new Date(BuildConfig.BUILD_DATE));
        Log.d("build date", buildDate);

        // do something depending whether this is a productive build
        if (BuildConfig.IS_PRODUCTION) {
            mTextView.setText(String.valueOf(BuildConfig.IS_PRODUCTION));
        } else {
            mTextView.setText(String.valueOf(BuildConfig.IS_PRODUCTION));
        }

        getResources().getString(R.string.app_name1);
    }
}
