package com.tarktech.training.beverage;

public class BeverageMachine {
    private int availableLatteCount;
    private int availableTeaCount;
    private int availableCappuccinoCount;
    private int availableMochaCount;

    private int totalLatteDispensed;
    private int totalTeaDispensed;
    private int totalCappuccinoDispensed;
    private int totalMochaDispensed;

    public BeverageMachine() {
        availableLatteCount = 5;
        availableTeaCount = 5;
        availableCappuccinoCount=5;
        availableMochaCount=5;

        totalLatteDispensed = 0;
        totalTeaDispensed = 0;
        totalCappuccinoDispensed=0;
        totalMochaDispensed=0;

    }

    public String makeBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                if(availableLatteCount == 0){
                    throw new RuntimeException("Sorry! Latte is out of stock!");
                }
                totalLatteDispensed++;
                availableLatteCount--;
                return "Enjoy your hot Latte with creamy milk!";
            case Tea:
                if(availableTeaCount == 0){
                    throw new RuntimeException("Sorry! Tea is out of stock!");
                }
                totalTeaDispensed++;
                availableTeaCount--;
                return "Enjoy your hot Masala Tea!";
            case Cappuccino:
                if(availableCappuccinoCount == 0){
                    throw new RuntimeException("Sorry! Cappuccino is out of stock!");
                }
                totalCappuccinoDispensed++;
                availableCappuccinoCount--;
                return "Enjoy freshly brewed Cappuccino!";
            case Mocha:
                if(availableMochaCount == 0){
                    throw new RuntimeException("Sorry! Mocha is out of stock!");
                }
                totalMochaDispensed++;
                availableMochaCount--;
                return "Enjoy Swiss Dark Chocolate Mocha!";
            default:
                throw new RuntimeException("Unsupported beverage: " + beverageType);
        }
    }

    public int getBeveragesDrunkByUser(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                return totalLatteDispensed;
            case Tea:
                return totalTeaDispensed;
            case Cappuccino:
                return totalCappuccinoDispensed;
            case Mocha:
                return totalMochaDispensed;
        }
        return 0;
    }

    public int getAvailableBeverages(BeverageType beverageType){
        switch (beverageType) {
            case Latte:
                return availableLatteCount;
            case Tea:
                return availableTeaCount;
            case Cappuccino:
                return availableCappuccinoCount;
            case Mocha:
                return availableMochaCount;
        }
        return 0;
    }

    public int getTotalBeveragesDrunkByUser(){
        return totalLatteDispensed + totalTeaDispensed + totalCappuccinoDispensed + totalMochaDispensed;
    }

    public int getTotalAvailableBeverages(){
        return availableLatteCount + availableTeaCount + availableCappuccinoCount + availableMochaCount;
    }
}
