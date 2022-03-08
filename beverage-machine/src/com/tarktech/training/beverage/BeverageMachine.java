package com.tarktech.training.beverage;

public class BeverageMachine {
    private int availableLatteCount;
    private int availableTeaCount;

    private int totalLatteDispensed;
    private int totalTeaDispensed;

    public BeverageMachine() {
        availableLatteCount = 5;
        availableTeaCount = 5;

        totalLatteDispensed = 0;
        totalTeaDispensed = 0;
    }

    public String makeBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                totalLatteDispensed++;
                availableLatteCount--;
                return "Enjoy your hot Latte with creamy milk!";
            case Tea:
                totalTeaDispensed++;
                availableTeaCount--;
                return "Enjoy your hot Masala Tea!";
            default:
                throw new RuntimeException("Unsupported beverage: " + beverageType);
        }
    }

    public int getTotalBeveragesDrunkByUser(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                return totalLatteDispensed;
            case Tea:
                return totalTeaDispensed;
        }
        return 0;
    }

    public int getAvailableBeverages(BeverageType beverageType){
        switch (beverageType) {
            case Latte:
                return availableLatteCount;
            case Tea:
                return availableTeaCount;
        }
        return 0;
    }
}
