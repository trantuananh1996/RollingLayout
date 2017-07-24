package com.jkb.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jkb.rollinglayout.RollingLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RollingLayout rollingLayout = (RollingLayout) findViewById(R.id.rolling);
        rollingLayout.setAdapter(new RollingAdapter(this));
        rollingLayout.startRolling();
    }
}
