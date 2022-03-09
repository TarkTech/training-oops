package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class LatteMaker extends BeverageMaker {
    public LatteMaker() {
    }

    @Override
    protected String brewFreshBeverage() {
        return "Enjoy hot latte with fresh creamy milk!";
    }
}
