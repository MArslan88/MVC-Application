package com.mhdarslan.mvcapplication.modules.mvc.controller;

import android.view.View;

import com.mhdarslan.mvcapplication.modules.mvc.MVCActivity;
import com.mhdarslan.mvcapplication.modules.mvc.model.DrinkModel;

public class MainController {
    private MVCActivity mvcActivity; // view
    private DrinkModel model;
    public MainController(MVCActivity mvcActivity){
        this.mvcActivity = mvcActivity;
        model = new DrinkModel(this);
    }

    public void suggestDrink(){
        // update UI to show feedback to the user
        this.mvcActivity.progressBar.setVisibility(View.VISIBLE);
        this.mvcActivity.tvDrinkName.setVisibility(View.INVISIBLE);
        model.suggestDrink();
    }

    public void onDrinkSuggested(String drinkName){
        this.mvcActivity.tvDrinkName.setText(drinkName);
        this.mvcActivity.tvDrinkName.setVisibility(View.VISIBLE);
        this.mvcActivity.progressBar.setVisibility(View.GONE);
    }
}
