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
        // Create a new instance of a JSONObject
        JSONObject object = new JSONObject();
        // Create a new instance of a JSONArray
        JSONArray array = new JSONArray();
        // With put() you can add a value to the array.
        JSONObject object1 = new JSONObject();
        try {
            object1.put("loc1", "tambaram");
            object1.put("loc2", "perugalathur");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        array.put(object1);


        try {
            // With put you can add a name/value pair to the JSONObject
            object.put("name", "Arjun");
            object.put("content", "Hello World!!!1");
            object.put("year", 2016);
            object.put("value", 3.23);
            object.put("member", true);
            object.put("null_value", JSONObject.NULL);
            object.put("my_loc_array", array);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        // Calling toString() on the JSONObject returns the JSON in string format.
        final String json = object.toString();
        mTextView.setText(json);


        // JSONArray nested inside JSONObject

        JSONObject root = null;
        try {
            root = new JSONObject(json);
            JSONArray booksArray = root.getJSONArray("my_loc_array");
            JSONObject firstBook = booksArray.getJSONObject(0);
            String title = firstBook.getString("loc1");
            mParsedTextView.setText(title);
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
