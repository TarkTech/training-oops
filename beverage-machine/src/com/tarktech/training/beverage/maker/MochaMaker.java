package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class MochaMaker extends BeverageMaker {
    public MochaMaker() {
    }

    @Override
    public String makeBeverage() {
        validateBeveragesAreAvailable();
        beverageDispensed();
        return "Enjoy Swiss Dark Chocolate Hot Mocha!";
    }

    @Override
    public BeverageType getBeverageType() {
        return BeverageType.Mocha;
    }
}
