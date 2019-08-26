package com.example.arjun.androidnotesprofessional;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2;
    String firstWord, lastWord;
    Spannable spannable;
    CustomTextView customTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.t1);
        textView2 = findViewById(R.id.t2);
        customTextView=findViewById(R.id.t3);
        firstWord = "Spannable";
        lastWord = "Color";


        spannable = new SpannableString(firstWord + lastWord);
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.BLUE), firstWord.length(), firstWord.length() + lastWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView1.setText(spannable);

        firstWord = "Spannable";
        lastWord = "Font";

        spannable = new SpannableString(firstWord + lastWord);
        spannable.setSpan(new RelativeSizeSpan(1.1f), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // set size
        spannable.setSpan(new RelativeSizeSpan(0.8f), firstWord.length(), firstWord.length() + lastWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // set size
        textView2.setText(spannable);
    }
}
