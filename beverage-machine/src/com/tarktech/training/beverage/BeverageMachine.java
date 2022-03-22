package com.tarktech.training.beverage;


public class BeverageMachine {
    private int availableTeaCount;
    private int dispensedTeaCount;

    private int availableLatteCount;
    private int dispensedLatteCount;

    public BeverageMachine() {
        availableTeaCount = 5;
        dispensedTeaCount = 0;

        availableLatteCount = 5;
        dispensedLatteCount = 0;
    }

    public String dispenseBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                dispensedTeaCount++;
                availableTeaCount--;
                return "Enjoy your Hot Masala Tea!";
            case Latte:
                dispensedLatteCount++;
                availableLatteCount--;
                return "Enjoy a cup of Latte with fresh creamy milk!";
        }
        throw new RuntimeException("Sorry! " + beverageType + " is not served!");
    }

    public int getDispensedBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                return dispensedTeaCount;
            case Latte:
                return dispensedLatteCount;
        }
        throw new RuntimeException("Sorry! " + beverageType + " is not supported!");
    }

    public int getAvailableBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                return availableTeaCount;
            case Latte:
                return availableLatteCount;
        }
        throw new RuntimeException("Sorry! " + beverageType + " is not supported!");
    }
}
