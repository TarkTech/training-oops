package com.tarktech.training.beverage.maker;


import com.tarktech.training.beverage.BeverageType;

public class TeaMaker extends BeverageMaker {
    public String dispenseBeverage() {
        return configBeverage(BeverageType.valueOf("Tea"));
    }
}
