package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class CappuccinoMaker extends BeverageMaker {
    public CappuccinoMaker() {
    }

    @Override
    public String makeBeverage() {
        validateBeveragesAreAvailable();
        beverageDispensed();
        return "Enjoy cappuccino made from freshly brewed beans!";
    }

    @Override
    public BeverageType getBeverageType() {
        return BeverageType.Cappuccino;
    }
}
