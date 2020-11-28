package com.iced.hf2020;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_bottomNav)
    BottomNavigationView bottomNav;

    @BindView(R.id.main_frame_layout)
    FrameLayout fragmentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void init(){
        String userType = getIntent().getStringExtra("USER_TYPE");

        switch (userType){

        }
    }

}