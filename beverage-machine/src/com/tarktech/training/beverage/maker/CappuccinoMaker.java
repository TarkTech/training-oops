package com.tarktech.training.beverage.maker;

public class CappuccinoMaker extends BeverageMaker {
    public CappuccinoMaker(){

    }
    public String dispenseBeverage() {
        if(getAvailableBeverageCount() == 0){
            return "Sorry, Beverage is out of stock!";
        }
        updateBeverageCount();
        return "Enjoy hot cappuccino made from freshly brewed beans!";
    }
}
