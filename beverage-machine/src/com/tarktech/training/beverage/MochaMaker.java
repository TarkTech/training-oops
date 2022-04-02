package com.tarktech.training.beverage;

public class MochaMaker extends BeverageMaker {
    public String dispenseBeverage() {
        if(getAvailableBeverageCount() <= 0) {
            return "Mocha is out of stock!";
        }
        updateBeverageQuantity();
        return "Enjoy a cup of hot mocha made from Swiss dark chocolates!";
    }
}
