package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class TeaMaker extends BeverageMaker {
    public TeaMaker() {
    }

    @Override
    protected String brewFreshBeverage() {
        return "Enjoy your hot Masala Tea!";
    }
}
