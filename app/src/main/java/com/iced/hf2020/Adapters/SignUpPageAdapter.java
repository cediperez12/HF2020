package com.iced.hf2020.Adapters;

import android.content.Context;
import android.view.View;

import com.iced.hf2020.Fragments.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.iced.hf2020.SignUpActivity;

public class SignUpPageAdapter extends FragmentPagerAdapter {

    public Fragment[] childFragments;

    public SignUpPageAdapter(@NonNull FragmentManager fm,SignUpActivity context) {
        super(fm);
        childFragments = new Fragment[]{
                new SignUpPersonalInformationFragment(),
                new SignUpUserInformation(context),
                new SignUpAccountInformation(),
                new SignUpReviewInformation()
        };
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length;
    }
}
