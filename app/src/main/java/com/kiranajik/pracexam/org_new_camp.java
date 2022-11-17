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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class org_new_camp extends AppCompatActivity {

    EditText camp_name;
    EditText no_of_pts;
    EditText camp_city;
    EditText camp_time;
    EditText camp_date;
    EditText camp_address;

    private FirebaseAuth mAuth;
    String user_email;
    FirebaseFirestore db;
    Button create_btn;

    @Override
    public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser != null){
                 user_email = currentUser.getEmail().toString();
            }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_new_camp);

        camp_name = findViewById(R.id.camp_name);
        no_of_pts = findViewById(R.id.no_of_pts);
        camp_city = findViewById(R.id.camp_city);
        camp_time = findViewById(R.id.camp_time);
        camp_date = findViewById(R.id.camp_date);
        camp_address = findViewById(R.id.camp_address);


        create_btn = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        Map<String, Object> camp = new HashMap<>();


        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camp.put("host", user_email);
                camp.put("camp_name", camp_name.getText().toString());
                camp.put("no_of_pts", no_of_pts.getText().toString());
                camp.put("camp_city", camp_city.getText().toString());
                camp.put("camp_time", camp_time.getText().toString());
                camp.put("camp_date", camp_date.getText().toString());
                camp.put("camp_address", camp_address.getText().toString());
                create_camp(camp);
                Intent i = new Intent(org_new_camp.this, existing_org_camps.class);
                startActivity(i);
            }
        });



    }

    private void create_camp(Map<String, Object> param)
    {
        db.collection("camps")
                .add(param)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Error", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Error", "Error adding document", e);
                    }
                });
    }


}