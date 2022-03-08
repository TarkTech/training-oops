package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class TeaMaker extends BeverageMaker {
    public TeaMaker() {
    }

    @Override
    public String makeBeverage() {
        validateBeveragesAreAvailable();
        beverageDispensed();
        return "Enjoy your hot Masala Tea!";
    }

    @Override
    public BeverageType getBeverageType() {
        return BeverageType.Tea;
    }
}
