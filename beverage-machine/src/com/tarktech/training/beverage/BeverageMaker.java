package com.tarktech.training.beverage;

public class BeverageMaker {
    private int availableBeverageCount;
    private int dispensedBeverageCount;

    public BeverageMaker(){
        availableBeverageCount = 5;
        dispensedBeverageCount = 0;
    }

    public int getDispensedBeverageCount() {
        return dispensedBeverageCount;
    }

    public int getAvailableBeverageCount() {
        return availableBeverageCount;
    }

    protected void updateBeverageQuantity() {
        availableBeverageCount--;
        dispensedBeverageCount++;
    }
}
