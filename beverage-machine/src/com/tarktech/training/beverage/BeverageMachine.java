package com.tarktech.training.beverage;


import java.util.HashMap;
import java.util.Map;

import static com.tarktech.training.beverage.BeverageType.*;

public class BeverageMachine {
    private Map<BeverageType, BeverageMaker> beverageMakers = new HashMap<>();

    public BeverageMachine() {
        beverageMakers.put(Latte, new LatteMaker());
        beverageMakers.put(Tea, new TeaMaker());
        beverageMakers.put(Cappuccino, new CappuccinoMaker());
        beverageMakers.put(Mocha, new MochaMaker());
    }

    public String dispenseBeverage(BeverageType beverageType) {
        BeverageMaker beverageMaker = beverageMakers.get(beverageType);
        return beverageMaker.dispenseBeverage();
    }

    public int getDispensedBeverageCount(BeverageType beverageType) {
        BeverageMaker beverageMaker = beverageMakers.get(beverageType);
        return beverageMaker.getDispensedBeverageCount();
    }

    public int getAvailableBeverageCount(BeverageType beverageType) {
        BeverageMaker beverageMaker = beverageMakers.get(beverageType);
        return beverageMaker.getAvailableBeverageCount();
    }
}
