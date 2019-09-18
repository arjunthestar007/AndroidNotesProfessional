package com.example.arjun.androidnotesprofessional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview);

        // Create a new instance of a JSONObject
        JSONObject object = new JSONObject();
        try {
            // With put you can add a name/value pair to the JSONObject
            object.put("name", "test");
            object.put("content", "Hello World!!!1");
            object.put("year", 2016);
            object.put("value", 3.23);
            object.put("member", true);
            object.put("null_value", JSONObject.NULL);
            // Calling toString() on the JSONObject returns the JSON in string format.


        } catch (JSONException e) {
            e.printStackTrace();
        }


        final String json = object.toString();
        mTextView.setText(json);

    }
}
