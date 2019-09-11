package com.example.arjun.androidnotesprofessional;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.arjun.androidnotesprofessional.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        ActivityMainBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        Item item = new Item("Example item", "This is an example item.");
        binding.setItem(item);
    }
}
