package com.example.arjun.androidnotesprofessional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    TextView mSerializedTextView;
    TextView mDeserializedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSerializedTextView = findViewById(R.id.textview);
        mDeserializedTextView = findViewById(R.id.textView2);

        Gson gson = new Gson();
        Robot robot = new Robot("1", 27, "arjun");

        //Java-JSON Serialization
        String jsonString = gson.toJson(robot);
        mSerializedTextView.setText(jsonString);

        //JSON-Java Deserialization
        Robot robot1 = gson.fromJson(jsonString, Robot.class);
        mDeserializedTextView.setText(robot1.toString());

    }
}
