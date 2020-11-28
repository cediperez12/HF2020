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

public class SignUpPersonalInformationFragment extends Fragment {

    @BindViews({R.id.f_sign_up_personal_til_first_name,R.id.f_sign_up_personal_til_last_name,R.id.f_sign_up_personal_til_middle_name})
    public TextInputLayout[] tilList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sign_up_personal_information, container, false);
        ButterKnife.bind(view);
        return view;
    }

    public String getFirstName(){
        return tilList[0].getEditText().getText().toString().trim();
    }

    public String getLastName(){
        return tilList[1].getEditText().getText().toString().trim();
    }

    public String getMiddleName(){
        return tilList[2].getEditText().getText().toString().trim();
    }
}