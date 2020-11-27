package com.iced.hf2020;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash_login_btn)
    Button btnLogin;

    @BindView(R.id.splash_txtv_signup)
    TextView txtvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.splash_login_btn)
    public void onClickLogin(){

    }

    @OnClick(R.id.splash_txtv_signup)
    public void onClickSignUp(){

    }
}