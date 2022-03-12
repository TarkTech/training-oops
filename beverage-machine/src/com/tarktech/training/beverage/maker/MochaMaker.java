package com.tarktech.training.beverage.maker;

public class MochaMaker extends BeverageMaker {

    public MochaMaker() {
    }

    public String dispenseBeverage() {
        validateBeveragesAreAvailable();
        updateBeverageCount();
        return "Enjoy your cup of Mocha made from exotic chocolate!";
    }
}
