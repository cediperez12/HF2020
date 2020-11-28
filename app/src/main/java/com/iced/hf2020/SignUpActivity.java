package com.iced.hf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iced.hf2020.Adapters.SignUpPageAdapter;
import com.iced.hf2020.Fragments.SignUpAccountInformation;
import com.iced.hf2020.Fragments.SignUpPersonalInformationFragment;
import com.iced.hf2020.Fragments.SignUpReviewInformation;
import com.iced.hf2020.Fragments.SignUpUserInformation;
import com.iced.hf2020.Utilities.User;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.sign_up_material_toolbar)
    MaterialToolbar toolbar;
    @BindView(R.id.sign_up_btn_nex)
    Button btnNext;
    @BindView(R.id.sign_up_vp)
    public ViewPager viewPager;
    @BindView(R.id.sign_up_vp_dot_indicator)
    DotsIndicator dotsIndicator;

    private SignUpPageAdapter adapter;

    private FirebaseAuth mAuth;
    private DatabaseReference userDatabaseReference;

    private String strFirstName, strLastName, strMiddleName, strUserType, emailAdd, strPass, strConPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.round_chevron_left_black_18dp);

        adapter = new SignUpPageAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);

        mAuth = FirebaseAuth.getInstance();
        userDatabaseReference = FirebaseDatabase.getInstance().getReference("users");

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                final int pos = position;
                if(position == adapter.getCount()){
                    btnNext.setText("Create this new account.");
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mAuth.createUserWithEmailAndPassword(emailAdd,strPass)
                                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    User user = new User(strFirstName,strLastName,strMiddleName,strUserType,emailAdd,strConPass);

                                    userDatabaseReference.child(authResult.getUser().getUid()).setValue(user)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                                    intent.putExtra("USER_TYPE",strUserType);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    new MaterialAlertDialogBuilder(SignUpActivity.this)
                                                            .setTitle("Warning")
                                                            .setMessage("Something went wrong while Signing up")
                                                            .setPositiveButton("Okay",null)
                                                            .create().show();
                                                }
                                            });


                                }
                            })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            new MaterialAlertDialogBuilder(SignUpActivity.this)
                                                    .setTitle("Warning")
                                                    .setMessage("Something went wrong while Signing up")
                                                    .setPositiveButton("Okay",null)
                                                    .create().show();
                                        }
                                    });
                        }
                    });
                }else{
                    btnNext.setText("Next");
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SignUpPersonalInformationFragment personalFragment = (SignUpPersonalInformationFragment) adapter.childFragments[0];
                            SignUpUserInformation userInformationFragment = (SignUpUserInformation)adapter.childFragments[1];
                            SignUpAccountInformation accountInformationFragment = (SignUpAccountInformation)adapter.childFragments[2];
                            SignUpReviewInformation reviewInformationFragment = (SignUpReviewInformation)adapter.childFragments[3];

                            switch (pos){
                                case 2:
                                    emailAdd = accountInformationFragment.getEmail();
                                    strPass = accountInformationFragment.getStrPass();
                                    strConPass = accountInformationFragment.getStrConfirmPass();
                                    break;

                                case 1:
                                    strUserType = userInformationFragment.getUserType();
                                    break;

                                case 0:
                                    strFirstName = personalFragment.getFirstName();
                                    strLastName = personalFragment.getLastName();
                                    strMiddleName = personalFragment.getMiddleName();
                                    break;
                            }
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}