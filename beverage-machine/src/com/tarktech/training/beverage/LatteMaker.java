package com.tarktech.training.beverage;

public class LatteMaker extends BeverageMaker {

    public String dispenseBeverage() {
        if(getAvailableBeverageCount() <= 0) {
            return "Latte is out of stock!";
        }
        updateBeverageQuantity();
        return "Enjoy a cup of Latte made with fresh creamy milk!";
    }
}
