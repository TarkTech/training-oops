package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class LatteMaker extends BeverageMaker {
    public LatteMaker() {
    }

    @Override
    public String makeBeverage() {
        validateBeveragesAreAvailable();
        beverageDispensed();
        return "Enjoy hot latte with fresh creamy milk!";
    }

    @Override
    public BeverageType getBeverageType() {
        return BeverageType.Latte;
    }
}
