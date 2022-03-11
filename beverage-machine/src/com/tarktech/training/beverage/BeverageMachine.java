package com.tarktech.training.beverage;

public class BeverageMachine {
    private int dispensedTeaCount;
    private int availableTeaCount;

    private int dispensedLatteCount;
    private int availableLatteCount;

    public BeverageMachine() {
        dispensedTeaCount = 0;
        availableTeaCount = 5;

        dispensedLatteCount = 0;
        availableLatteCount = 5;
    }

    public String dispenseBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                availableLatteCount--;
                dispensedLatteCount++;
                return "Enjoy your cup of Latte with fresh creamy milk!";
            case Tea:
                availableTeaCount--;
                dispensedTeaCount++;
                return "Enjoy your Hot Masala Tea!";
        }
        throw new RuntimeException("Sorry! We are not supporting " + beverageType + " yet!");
    }

    public int getDispensedBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                return dispensedLatteCount;
            case Tea:
                return dispensedTeaCount;
        }
        throw new RuntimeException("Sorry! We are not supporting " + beverageType + " yet!");
    }

    public int getAvailableBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                return availableLatteCount;
            case Tea:
                return availableTeaCount;
        }
        throw new RuntimeException("Sorry! We are not supporting " + beverageType + " yet!");
    }
}
