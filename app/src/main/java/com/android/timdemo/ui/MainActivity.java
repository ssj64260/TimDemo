package com.android.timdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.timdemo.R;

public class MainActivity extends AppCompatActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
