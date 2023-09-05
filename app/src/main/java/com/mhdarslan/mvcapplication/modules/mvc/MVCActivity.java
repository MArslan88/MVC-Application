package com.mhdarslan.mvcapplication.modules.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mhdarslan.mvcapplication.R;
import com.mhdarslan.mvcapplication.modules.mvc.controller.MainController;

public class MVCActivity extends AppCompatActivity {
    public TextView tvDrinkName;
    public ProgressBar progressBar;
    public Button getDrink_btn;
    MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvcactivity);

        tvDrinkName = findViewById(R.id.tvDrinkName);
        progressBar = findViewById(R.id.progressBar);
        getDrink_btn = findViewById(R.id.getDrink_btn);

        mainController = new MainController(this);

        getDrink_btn.setOnClickListener(v -> {
            mainController.suggestDrink();
        });
    }
}