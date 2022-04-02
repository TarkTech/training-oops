package com.tarktech.training.beverage;

public class TeaMaker {
    private int availableTeaCount;
    private int dispensedTeaCount;

    public TeaMaker(){
        availableTeaCount = 5;
        dispensedTeaCount = 0;
    }

    public String dispenseBeverage() {
        if(availableTeaCount <= 0) {
            return "Tea is out of stock!";
        }
        dispensedTeaCount++;
        availableTeaCount--;
        return "Enjoy your Hot Masala Tea!";
    }

    public int getDispensedBeverageCount() {
        return dispensedTeaCount;
    }

    public int getAvailableBeverageCount() {
        return availableTeaCount;
    }
}
