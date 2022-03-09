package com.tarktech.training.beverage;

import com.tarktech.training.beverage.maker.*;

import java.util.Map;

public class BeverageMachine {
    private final Map<BeverageType, BeverageMaker> beverageMakerByType;

    public BeverageMachine(Map<BeverageType, BeverageMaker> beverageMakerByType) {
        this.beverageMakerByType = beverageMakerByType;
    }

    public String makeBeverage(BeverageType beverageType) {
        BeverageMaker beverageMaker = beverageMakerByType.get(beverageType);
        return beverageMaker.makeBeverage();
    }

    public int getBeveragesDrunkByUser(BeverageType beverageType) {
        BeverageMaker beverageMaker = beverageMakerByType.get(beverageType);
        return beverageMaker.getBeveragesDrunkByUser();
    }

    public int getAvailableBeverages(BeverageType beverageType) {
        BeverageMaker beverageMaker = beverageMakerByType.get(beverageType);
        return beverageMaker.getAvailableBeverages();
    }
}
