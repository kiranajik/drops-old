package com.kiranajik.pracexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class userQr extends AppCompatActivity {

    ImageView imgqr;
    Button btncncl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_qr);
        imgqr=findViewById(R.id.qr);
        btncncl=findViewById(R.id.buttoncancel);

        imgqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(userQr.this,userDonationDone.class);
                startActivity(i);
            }
        });

        btncncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(userQr.this,DonarHome.class);
                startActivity(i);
            }
        });
    }
}