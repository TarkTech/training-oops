package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public abstract class BeverageMaker {
    private int dispensedBeverageCount;
    private int availableBeverageCount;

    private String[] msgs= {"Enjoy your Hot Masala Tea!", "Enjoy your Latte with fresh creamy milk!", "Enjoy hot cappuccino made from freshly brewed beans!", "Enjoy your cup of Mocha made from exotic chocolate!", "Enjoy your black tea!"};

    public BeverageMaker(){
        dispensedBeverageCount = 0;
        availableBeverageCount = 5;
    }

    public int getDispensedBeverageCount() {
        return dispensedBeverageCount;
    }

    public int getAvailableBeverageCount() {
        return availableBeverageCount;
    }

    public void updateBeverageCount(){
        dispensedBeverageCount++;
        availableBeverageCount--;
    }

    public void validateBeveragesAreAvailable(){
        if (getAvailableBeverageCount() == 0) {
            throw new RuntimeException("Sorry, Beverage is out of stock!");
        }
    }

    public String configBeverage(BeverageType type){
        validateBeveragesAreAvailable();
        updateBeverageCount();
        return msgs[type.ordinal()];
    }

    public abstract String dispenseBeverage();
}
