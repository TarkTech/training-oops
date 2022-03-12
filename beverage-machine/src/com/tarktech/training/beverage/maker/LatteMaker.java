package com.tarktech.training.beverage.maker;

public class LatteMaker extends BeverageMaker {

    public LatteMaker(){
    }

    public String dispenseBeverage() {
        if(getAvailableBeverageCount() == 0){
            throw new RuntimeException("Sorry, Beverage is out of stock!");
        }
        updateBeverageCount();
        return "Enjoy your Latte with fresh creamy milk!";
    }
}
