package com.example.arjun.androidnotesprofessional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        String jsonString = "{\n" +
                "\"student\":{\"name\":\"Rahul\", \"lastname\":\"sharma\"},\n" +
                "\"marks\":{\"maths\":\"88\"}\n" +
                "}";


        try {
            // Create a new instance of a JSONObject
            final JSONObject object = new JSONObject(jsonString);
            JSONObject studentJSON = object.getJSONObject("student");
            studentJSON.put("name", "Kumar");
            object.remove("student");
            object.put("student", studentJSON);
// Calling toString() on the JSONObject returns the JSON in string format.
            final String json = object.toString();
            mParsedTextView.setText(json);
        } catch (JSONException e) {

        }
    }
}
