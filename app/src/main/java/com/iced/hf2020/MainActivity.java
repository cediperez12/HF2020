package com.iced.hf2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.iced.hf2020.Fragments.DoctorHomeFragment;
import com.iced.hf2020.Fragments.RunnerHomeFragment;
import com.iced.hf2020.Fragments.UserHomeFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_bottomNav)
    BottomNavigationView bottomNav;

    @BindView(R.id.main_frame_layout)
    FrameLayout fragmentLayout;

    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null){
            Intent intent = new Intent(getApplicationContext(),SplashActivity.class);
            startActivity(intent);
            finish();
        }else{
            String userType = getIntent().getStringExtra("USER_TYPE");

            switch (userType){
                case "Doctor":
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,new DoctorHomeFragment()).commit();
                    break;
                case "Nurse":
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,new DoctorHomeFragment()).commit();
                    break;
                case "Runner":
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,new RunnerHomeFragment()).commit();
                    break;
                case "User":
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,new UserHomeFragment()).commit();
                    break;
            }
        }
    }

}