package com.tarktech.training.beverage;

public class BeverageMachine {
    private int totalLatteDispensed;
    private int totalTeaDispensed;

    public BeverageMachine() {
        totalLatteDispensed = 0;
        totalTeaDispensed = 0;
    }

    public String makeBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                totalLatteDispensed++;
                return "Enjoy your hot Latte with creamy milk!";
            case Tea:
                totalTeaDispensed++;
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
}
