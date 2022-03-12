package com.tarktech.training.beverage;

import com.tarktech.training.beverage.maker.BeverageMaker;

public class BlackTeaMaker extends BeverageMaker {
    public BlackTeaMaker() {
    }

    public String dispenseBeverage() {
        validateBeveragesAreAvailable();
        updateBeverageCount();
        return "Enjoy your black tea!";
    }
}
