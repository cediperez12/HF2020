package com.iced.hf2020.Fragments;

import android.content.Context;
import android.os.Bundle;

import com.iced.hf2020.SignUpActivity;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.iced.hf2020.R;


public class SignUpUserInformation extends Fragment {

    private SignUpActivity activity;

    @BindViews({R.id.f_sign_up_user_info_btn_user,
            R.id.f_sign_up_user_info_btn_nurse,
            R.id.f_sign_up_user_info_btn_doctor,
            R.id.f_sign_up_user_info_btn_runner})
    public Button[] btnList;

    private String userType;

    public SignUpUserInformation(SignUpActivity context){
        this.activity = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up_user_information, container, false);
        ButterKnife.bind(view);
        return view;
    }

    @OnClick({
            R.id.f_sign_up_user_info_btn_user,
            R.id.f_sign_up_user_info_btn_nurse,
            R.id.f_sign_up_user_info_btn_doctor,
            R.id.f_sign_up_user_info_btn_runner
    })
    public void onClick(View view){
        switch (view.getId()){
            case R.id.f_sign_up_user_info_btn_user:
                userType = "User";
                break;

            case R.id.f_sign_up_user_info_btn_nurse:
                userType = "Nurse";
                break;

            case R.id.f_sign_up_user_info_btn_doctor:
                userType = "Doctor";
                break;

            case R.id.f_sign_up_user_info_btn_runner:
                userType = "Runner";
                break;
        }

        activity.viewPager.setCurrentItem(2);
    }

    public String getUserType(){
        return userType;
    }
}