package com.tarktech.training.beverage;

public class CappuccinoMaker extends BeverageMaker {
    public String dispenseBeverage() {
        if(getAvailableBeverageCount() <= 0) {
            return "Cappuccino is out of stock!";
        }
        updateBeverageQuantity();
        return "Enjoy your cappuccino made from freshly brewed beans!";
    }
}
