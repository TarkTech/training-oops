package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public abstract class BeverageMaker {
    private int availableBeveragesCount;
    private int totalBeveragesDispensed;

    public BeverageMaker() {
        availableBeveragesCount = 5;
        totalBeveragesDispensed = 0;
    }

    public String makeBeverage(){
        if(availableBeveragesCount == 0){
            throw new RuntimeException("Sorry! beverage is out of stock!");
        }

        totalBeveragesDispensed++;
        availableBeveragesCount--;

        String freshlyBrewedBeverage = brewFreshBeverage();
        return freshlyBrewedBeverage;
    }

    public int getBeveragesDrunkByUser() {
        return totalBeveragesDispensed;
    }

    public int getAvailableBeverages() {
        return availableBeveragesCount;
    }

    protected abstract String brewFreshBeverage();
}
