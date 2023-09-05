package com.mhdarslan.mvcapplication.modules.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mhdarslan.mvcapplication.R;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NormalActivity extends AppCompatActivity {
    String[] drinkList = {"Mint Margarita", "Spiking coffee", "Sweet Bananas", "Tomato Tang", "Apple Berry smoothie"};
    TextView tvDrinkName;
    ProgressBar progressBar;
    Button getDrink_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        tvDrinkName = findViewById(R.id.tvDrinkName);
        progressBar = findViewById(R.id.progressBar);
        getDrink_btn = findViewById(R.id.getDrink_btn);

        getDrink_btn.setOnClickListener(v -> {
            suggestDrink();
        });
    }

    private void suggestDrink() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        final String[] drinkName = {""};
        // before executing background task
        progressBar.setVisibility(View.VISIBLE);
        tvDrinkName.setVisibility(View.INVISIBLE);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                // background work here

                try {
                    Thread.sleep(1000); // mimic server request / long execution
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                drinkName[0] = drinkList[new Random().nextInt(drinkList.length)];

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // UI thread work here
                        tvDrinkName.setText(drinkName[0]);
                        tvDrinkName.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        });

    }
}