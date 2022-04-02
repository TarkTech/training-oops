package com.tarktech.training.beverage;

public class TeaMaker extends BeverageMaker {

    public String dispenseBeverage() {
        if(getAvailableBeverageCount() <= 0) {
            return "Tea is out of stock!";
        }
        updateBeverageQuantity();
        return "Enjoy your Hot Masala Tea!";
    }
}
