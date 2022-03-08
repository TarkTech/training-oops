package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public abstract class BeverageMaker {
    private int availableBeveragesCount;
    private int totalBeveragesDispensed;

    public BeverageMaker() {
        availableBeveragesCount = 5;
        totalBeveragesDispensed = 0;
    }

    public abstract String makeBeverage();

    public abstract BeverageType getBeverageType();

    protected void validateBeveragesAreAvailable(){
        if(availableBeveragesCount == 0){
            BeverageType beverageType = getBeverageType();
            throw new RuntimeException("Sorry! " + beverageType + " is out of stock!");
        }
    }

    protected void beverageDispensed(){
        totalBeveragesDispensed++;
        availableBeveragesCount--;
    }

    public int getBeveragesDrunkByUser() {
        return totalBeveragesDispensed;
    }

    public int getAvailableBeverages() {
        return availableBeveragesCount;
    }
}
