package com.kiranajik.pracexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DonarHome extends AppCompatActivity {

    ImageView donr1,donr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_home);

        donr1=findViewById(R.id.donar1);
        donr2=findViewById(R.id.donar2);

        donr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DonarHome.this,nav.class);
                startActivity(i);
            }
        });
        donr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DonarHome.this,nav.class);
                startActivity(i);
            }
        });
    }
}