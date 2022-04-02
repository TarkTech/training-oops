package com.tarktech.training.beverage;

public class CappuccinoMaker {
    private int availableCappuccinoCount;
    private int dispensedCappuccinoCount;

    public CappuccinoMaker(){
        availableCappuccinoCount = 5;
        dispensedCappuccinoCount = 0;
    }

    public String dispenseBeverage() {
        if(availableCappuccinoCount <= 0) {
            return "Cappuccino is out of stock!";
        }
        dispensedCappuccinoCount++;
        availableCappuccinoCount--;
        return "Enjoy your cappuccino made from freshly brewed beans!";
    }

    public int getDispensedBeverageCount() {
        return dispensedCappuccinoCount;
    }

    public int getAvailableBeverageCount() {
        return availableCappuccinoCount;
    }
}
