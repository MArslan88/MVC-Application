package com.mhdarslan.mvcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.mhdarslan.mvcapplication.modules.mvc.MVCActivity;
import com.mhdarslan.mvcapplication.modules.normal.NormalActivity;

public class MainActivity extends AppCompatActivity {
    Button simple_btn, mvc_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simple_btn = findViewById(R.id.simple_btn);
        mvc_btn = findViewById(R.id.mvc_btn);

        simple_btn.setOnClickListener(v -> {
            startActivity(new Intent(this, NormalActivity.class));
        });

        mvc_btn.setOnClickListener(v -> {
            startActivity(new Intent(this, MVCActivity.class));
        });

    }
}