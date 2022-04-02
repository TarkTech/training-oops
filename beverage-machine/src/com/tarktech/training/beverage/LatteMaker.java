package com.tarktech.training.beverage;

public class LatteMaker {
    private int availableLatteCount;
    private int dispensedLatteCount;

    public LatteMaker(){
        availableLatteCount = 5;
        dispensedLatteCount = 0;
    }

    public String dispenseBeverage() {
        if(availableLatteCount <= 0) {
            return "Latte is out of stock!";
        }
        dispensedLatteCount++;
        availableLatteCount--;
        return "Enjoy a cup of Latte made with fresh creamy milk!";
    }

    public int getDispensedBeverageCount() {
        return dispensedLatteCount;
    }

    public int getAvailableBeverageCount() {
        return availableLatteCount;
    }
}
