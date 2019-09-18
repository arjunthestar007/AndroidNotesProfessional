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
        mParsedTextView=findViewById(R.id.textView2);
        // Create a new instance of a JSONObject
        JSONObject object = new JSONObject();
        // Create a new instance of a JSONArray
        JSONArray array = new JSONArray();
        // With put() you can add a value to the array.
        array.put("Perugalathur");
        array.put("Siruseri");

        try {
            // With put you can add a name/value pair to the JSONObject
            object.put("name", "Arjun");
            object.put("content", "Hello World!!!1");
            object.put("year", 2016);
            object.put("value", 3.23);
            object.put("member", true);
            object.put("null_value", JSONObject.NULL);
            object.put("my_loc_array", array);
            // Calling toString() on the JSONObject returns the JSON in string format.


        } catch (JSONException e) {
            e.printStackTrace();
        }



        final String json = object.toString();
        mTextView.setText(json);

        StringBuilder str=new StringBuilder();
        try {
            JSONObject jsonObject=new JSONObject(json);
            String name = jsonObject.getString("name");
            String content = jsonObject.getString("content");
            int year = jsonObject.getInt("year");
            str.append("Name :"+name);

            JSONArray names = jsonObject.getJSONArray("my_loc_array");

            for (int i = 0; i < names.length(); i++) {
                str.append("Location :"+names.get(i));



            }
            mParsedTextView.setText(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
