package com.iced.hf2020;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iced.hf2020.Utilities.Hospital;
import com.iced.hf2020.Utilities.Patient;

import java.util.List;

public class HospitalInformationActivity extends AppCompatActivity {

    @BindView(R.id.hospital_information_toolbar)
    MaterialToolbar toolbar;

    @BindView(R.id.hospital_information_txtv_hospital_name)
    TextView txtvHospitalName;

    @BindView(R.id.hospital_information_recyclerView)
    RecyclerView recyclerView;

    private DatabaseReference hospitalReference;
    private List<Patient> patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_information);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.round_chevron_left_black_18dp);

        hospitalReference = FirebaseDatabase.getInstance().getReference("hospitals");

        String hospitalId = getIntent().getStringExtra("HOSPITAL_ID");
        hospitalReference = hospitalReference.child(hospitalId);

        hospitalReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Hospital h =  snapshot.getValue(Hospital.class);
                txtvHospitalName.setText(h.getHospitalName());
                hospitalReference.removeEventListener(this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        hospitalReference.child("patients").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Patient patient = snapshot.getValue(Patient.class);
                String name = patient.getFirstName() + " " + patient.getLastName();
                String sickness = patient.getCondition().getSickness();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}