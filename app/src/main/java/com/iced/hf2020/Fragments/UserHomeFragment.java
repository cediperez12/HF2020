package com.iced.hf2020.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iced.hf2020.R;

public class UserHomeFragment extends Fragment {

    @BindView(R.id.f_user_home_recyclerv)
    RecyclerView recylerview;

    private DatabaseReference hospitalReference;
    private DatabaseReference userReference;
    private FirebaseUser currentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        hospitalReference = FirebaseDatabase.getInstance().getReference("hospitals");
        userReference = FirebaseDatabase.getInstance().getReference("users").child(currentUser.getUid());



        return inflater.inflate(R.layout.fragment_user_home, container, false);
    }


}