package com.tarktech.training.beverage;

public class MochaMaker {
    private int availableMochaCount;
    private int dispensedMochaCount;

    public MochaMaker(){
        availableMochaCount = 5;
        dispensedMochaCount = 0;
    }

    public String dispenseBeverage() {
        if(availableMochaCount <= 0) {
            return "Mocha is out of stock!";
        }
        dispensedMochaCount++;
        availableMochaCount--;
        return "Enjoy a cup of hot mocha made from Swiss dark chocolates!";
    }

    public int getDispensedBeverageCount() {
        return dispensedMochaCount;
    }

    public int getAvailableBeverageCount() {
        return availableMochaCount;
    }
}
