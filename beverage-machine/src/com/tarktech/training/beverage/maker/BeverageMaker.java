package com.tarktech.training.beverage.maker;

public abstract class BeverageMaker {
    private int dispensedBeverageCount;
    private int availableBeverageCount;

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


    public abstract String dispenseBeverage();
}
