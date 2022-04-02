package com.tarktech.training.beverage;


public class BeverageMachine {
    private int availableTeaCount;
    private int dispensedTeaCount;

    private int availableLatteCount;
    private int dispensedLatteCount;

    private int availableCappuccinoCount;
    private int dispensedCappuccinoCount;

    private int availableMochaCount;
    private int dispensedMochaCount;

    public BeverageMachine() {
        availableTeaCount = 5;
        dispensedTeaCount = 0;

        availableLatteCount = 5;
        dispensedLatteCount = 0;

        availableCappuccinoCount = 5;
        dispensedCappuccinoCount = 0;

        availableMochaCount = 5;
        dispensedMochaCount = 0;
    }

    public String dispenseBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                if(availableTeaCount <= 0) {
                    return "Tea is out of stock!";
                }
                dispensedTeaCount++;
                availableTeaCount--;
                return "Enjoy your Hot Masala Tea!";
            case Latte:
                if(availableLatteCount <= 0) {
                    return "Latte is out of stock!";
                }
                dispensedLatteCount++;
                availableLatteCount--;
                return "Enjoy a cup of Latte with fresh creamy milk!";
            case Cappuccino:
                if(availableCappuccinoCount <= 0) {
                    return "Cappuccino is out of stock!";
                }
                dispensedCappuccinoCount++;
                availableCappuccinoCount--;
                return "Enjoy your cappuccino made from freshly brewed beans!";
           case Mocha:
                if(availableMochaCount <= 0) {
                    return "Mocha is out of stock!";
                }
                dispensedMochaCount++;
                availableMochaCount--;
                return "Enjoy a cup of hot mocha made from Swiss dark chocolates!";
        }
        throw new RuntimeException("Sorry! " + beverageType + " is not served!");
    }

    public int getDispensedBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                return dispensedTeaCount;
            case Latte:
                return dispensedLatteCount;
            case Cappuccino:
                return dispensedCappuccinoCount;
            case Mocha:
                return dispensedMochaCount;
        }
        throw new RuntimeException("Sorry! " + beverageType + " is not supported!");
    }

    public int getAvailableBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                return availableTeaCount;
            case Latte:
                return availableLatteCount;
            case Cappuccino:
                return availableCappuccinoCount;
            case Mocha:
                return availableMochaCount;

        }
        throw new RuntimeException("Sorry! " + beverageType + " is not supported!");
    }

    public BeverageType getMostFavoriteBeverage() {
        if(dispensedTeaCount >= dispensedLatteCount
        && dispensedTeaCount >= dispensedCappuccinoCount
        && dispensedTeaCount >= dispensedMochaCount) {
            return BeverageType.Tea;
        }

        if(dispensedLatteCount >= dispensedTeaCount
        && dispensedLatteCount >= dispensedCappuccinoCount
        && dispensedLatteCount >= dispensedMochaCount) {
            return BeverageType.Latte;
        }

        if(dispensedCappuccinoCount >= dispensedTeaCount
        && dispensedCappuccinoCount >= dispensedLatteCount
        && dispensedCappuccinoCount >= dispensedMochaCount) {
            return BeverageType.Cappuccino;
        }

        if(dispensedMochaCount >= dispensedTeaCount
        && dispensedMochaCount >= dispensedLatteCount
        && dispensedMochaCount >= dispensedCappuccinoCount) {
            return BeverageType.Mocha;
        }

       return null;
    }
}
