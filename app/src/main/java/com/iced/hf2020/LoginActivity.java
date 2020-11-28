package com.iced.hf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iced.hf2020.Utilities.User;

public class LoginActivity extends AppCompatActivity {

    @BindViews({R.id.login_til_email, R.id.login_til_password})
    TextInputLayout til[];

    private FirebaseAuth auth;
    private DatabaseReference userDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        auth = FirebaseAuth.getInstance();
        userDatabaseReference = FirebaseDatabase.getInstance().getReference("user");
    }

    @OnClick(R.id.login_btn_login)
    public void clickLogin(){
        String strEmail = til[0].getEditText().getText().toString().trim();
        String strPass = til[1].getEditText().getText().toString().trim();

        auth.signInWithEmailAndPassword(strEmail,strPass)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        FirebaseUser user = authResult.getUser();
                        userDatabaseReference.child(user.getUid()).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                User user = snapshot.getValue(User.class);
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                intent.putExtra("USER_TYPE",user.getUserType());
                                startActivity(intent);
                                finish();

                                userDatabaseReference.removeEventListener(this);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                new MaterialAlertDialogBuilder(LoginActivity.this)
                                        .setTitle("Warning")
                                        .setMessage(error.getMessage())
                                        .setPositiveButton("Okay",null)
                                        .create()
                                        .show();
                            }
                        });


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        new MaterialAlertDialogBuilder(LoginActivity.this)
                                .setTitle("Warning")
                                .setMessage(e.getMessage())
                                .setPositiveButton("Okay",null)
                                .create()
                                .show();
                    }
                });
    }

    @OnClick(R.id.login_txtv_signup)
    public void clickSignUp(){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}