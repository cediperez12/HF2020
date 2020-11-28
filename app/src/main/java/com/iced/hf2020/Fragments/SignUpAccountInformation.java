package com.iced.hf2020.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputLayout;
import com.iced.hf2020.R;

public class SignUpAccountInformation extends Fragment {

    @BindViews({
            R.id.f_sign_up_account_info_email_add_til,
            R.id.f_sign_up_account_info_pass_til,
            R.id.f_sign_up_account_info_confirm_pass_til,
    })
    TextInputLayout tils[];

    private String strEmail,strPass,strConfirmPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up_account_information, container, false);
        ButterKnife.bind(view);
        return view;
    }

    public String getEmail(){
        return tils[0].getEditText().getText().toString().trim();
    }

    public String getStrPass(){
        return tils[1].getEditText().getText().toString().trim();
    }

    public String getStrConfirmPass(){
        return tils[2].getEditText().getText().toString().trim();
    }
}