package com.tarktech.training.beverage.maker;

import com.tarktech.training.beverage.BeverageType;

public class LatteMaker extends BeverageMaker {
    public String dispenseBeverage() {
        return configBeverage(BeverageType.valueOf("Latte"));
    }
}
