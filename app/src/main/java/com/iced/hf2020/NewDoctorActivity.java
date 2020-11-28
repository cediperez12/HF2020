package com.iced.hf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.iced.hf2020.Utilities.Notification;
import com.iced.hf2020.Utilities.User;

public class NewDoctorActivity extends AppCompatActivity {

    @BindView(R.id.new_doctor_toolbar)
    Toolbar toolbar;

    @BindView(R.id.new_doctor_til_email)
    TextInputLayout tilEmail;

    @BindView(R.id.new_doctor_btn)
    Button btn;

    private DatabaseReference reference;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doctor);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.round_chevron_left_black_18dp);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");

        String strEmail = tilEmail.getEditText().getText().toString().trim();

        Query query = reference.orderByChild("emailAddress").equalTo(strEmail);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String userKey = snapshot.getKey();

                DatabaseReference referenceNotification = FirebaseDatabase.getInstance().getReference("users").child(userKey).child("notification");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}