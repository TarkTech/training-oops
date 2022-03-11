package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class MochaMaker extends BeverageMaker {
    public MochaMaker() {
    }

    @Override
    protected String brewFreshBeverage() {
        return "Enjoy Swiss Dark Chocolate Hot Mocha!";
    }
}
