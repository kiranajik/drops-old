package com.kiranajik.pracexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class org_home extends AppCompatActivity {
    Button view_existing;
    Button create_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_home);

        view_existing = findViewById(R.id.view_existing);
        create_new = findViewById(R.id.create_new);

        view_existing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(org_home.this,existing_org_camps.class);
                startActivity(i);
            }
        });

        create_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(org_home.this,org_new_camp.class);
                startActivity(i);
            }
        });
    }
}