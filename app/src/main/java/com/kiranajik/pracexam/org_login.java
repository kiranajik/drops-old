package com.kiranajik.pracexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class org_login extends AppCompatActivity {
    Button go;
    EditText user_login_email;
    EditText user_login_passwd;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_login);
        mAuth = FirebaseAuth.getInstance();
        go = findViewById(R.id.user_sign_in_btn);
        user_login_email = findViewById(R.id.user_login_email);
        user_login_passwd = findViewById(R.id.user_login_passwd);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAccount(user_login_email.getText().toString(),user_login_passwd.getText().toString());
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


    private void loginAccount(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("error", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("error", "signInWithEmail:failure", task.getException());
                            Toast.makeText(org_login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent i = new Intent(org_login.this, org_home.class);
            startActivity(i);
        } else {
            Toast.makeText(org_login.this, "Authentication failed., Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void reload() {
        Intent i = new Intent(org_login.this, org_home.class);
        startActivity(i);
    }
}

