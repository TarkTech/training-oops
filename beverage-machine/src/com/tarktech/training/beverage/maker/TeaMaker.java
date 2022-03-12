package com.tarktech.training.beverage.maker;


public class TeaMaker extends BeverageMaker {


    public String dispenseBeverage() {
        validateBeveragesAreAvailable();
        updateBeverageCount();
        return "Enjoy your Hot Masala Tea!";
    }
}
