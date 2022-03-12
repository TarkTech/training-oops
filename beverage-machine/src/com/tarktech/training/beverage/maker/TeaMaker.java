package com.tarktech.training.beverage.maker;


public class TeaMaker extends BeverageMaker {
    public TeaMaker() {
    }

    public String dispenseBeverage() {
        if (getAvailableBeverageCount() == 0) {
            return "Sorry, Beverage is out of stock!";
        }
        updateBeverageCount();
        return "Enjoy your Hot Masala Tea!";
    }
}
