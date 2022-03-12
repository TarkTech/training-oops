package com.tarktech.training.beverage.maker;

public class MochaMaker extends BeverageMaker {

    public MochaMaker() {
    }

    public String dispenseBeverage() {
        if (getAvailableBeverageCount() == 0) {
            return "Sorry, Beverage is out of stock!";
        }
        updateBeverageCount();
        return "Enjoy your cup of Mocha made from exotic chocolate!";
    }
}
