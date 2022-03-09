package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class CappuccinoMaker extends BeverageMaker {
    public CappuccinoMaker() {
    }

    @Override
    protected String brewFreshBeverage() {
        return "Enjoy cappuccino made from freshly brewed beans!";
    }
}
