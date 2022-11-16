package com.kiranajik.pracexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserChoose extends AppCompatActivity {

    Button orgnzn, donr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choose);

        orgnzn=findViewById(R.id.organization);
        donr=findViewById(R.id.donar);

        orgnzn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserChoose.this,auth.class);
                startActivity(i);
            }
        });

        donr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserChoose.this,auth.class);
                startActivity(i);
            }
        });
    }
}