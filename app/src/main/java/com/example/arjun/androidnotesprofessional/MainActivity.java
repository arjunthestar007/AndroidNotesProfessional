package com.example.arjun.androidnotesprofessional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    TextView mParsedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview);
        mParsedTextView = findViewById(R.id.textView2);

        String jsonStr = "{name:james}";
        String name=null, surname;

        JSONObject json = null; // Check if the field "name" is present String name, surname;
        try {
            json = new JSONObject(jsonStr);

            // This will be true, since the field "name" is present on our JSON.
            if (json.has("name")) {
                name = json.getString("name");
            } else {
                name = "John";
            }
// This will be false, since our JSON doesn't have the field "surname".
            if (json.has("surname")) {
                surname = json.getString("surname");
            } else {
                surname = "Doe";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        mTextView.setText(name);
    }
}
