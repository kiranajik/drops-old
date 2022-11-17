package com.kiranajik.pracexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class signup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button user_signup_btn;
    EditText user_email;
    EditText user_passwd;
    EditText user_confirm_passwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        user_signup_btn = findViewById(R.id.sign_up_btn);
        user_email = findViewById(R.id.user_email);
        user_passwd = findViewById(R.id.user_passwd);
        user_confirm_passwd = findViewById(R.id.user_confirm_passwd);
        user_signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount(user_email.getText().toString(),user_passwd.getText().toString());
            }
        });


    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            reload();
//        }
//    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.e("error name", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }


    private void reload() {
        Intent i = new Intent(signup.this, DonarHome.class);
        startActivity(i);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent i = new Intent(signup.this, login.class);
            startActivity(i);
        } else {
            Toast.makeText(signup.this, "Authentication failed., Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }


}