package com.tarktech.training.beverage;

import com.tarktech.training.beverage.maker.BeverageMaker;

public class BlackTeaMaker extends BeverageMaker {
    public String dispenseBeverage() {
        return configBeverage(BeverageType.valueOf("BlackTea"));
    }
}
