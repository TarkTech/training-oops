package com.tarktech.training.beverage.maker;

public class CappuccinoMaker extends BeverageMaker {
    public CappuccinoMaker(){

    }
    public String dispenseBeverage() {
        validateBeveragesAreAvailable();
        updateBeverageCount();
        return "Enjoy hot cappuccino made from freshly brewed beans!";
    }
}
