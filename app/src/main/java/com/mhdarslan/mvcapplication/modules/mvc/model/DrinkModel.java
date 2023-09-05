package com.mhdarslan.mvcapplication.modules.mvc.model;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.mhdarslan.mvcapplication.modules.mvc.controller.MainController;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrinkModel {
    String[] drinkList = {"Mint Margarita", "Spiking coffee", "Sweet Bananas", "Tomato Tang", "Apple Berry smoothie"};
    private MainController controller;

    public DrinkModel(MainController controller) {
        this.controller = controller;
    }

    public void suggestDrink() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        final String[] drinkName = {""};
        // before executing background task
//        progressBar.setVisibility(View.VISIBLE);
//        tvDrinkName.setVisibility(View.INVISIBLE);

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
//                        tvDrinkName.setText(drinkName[0]);
//                        tvDrinkName.setVisibility(View.VISIBLE);
//                        progressBar.setVisibility(View.GONE);

                        // after executing background task
                        controller.onDrinkSuggested(drinkName[0]);
                    }
                });
            }
        });

    }
}
