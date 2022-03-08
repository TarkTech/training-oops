package com.tarktech.training.beverage;

public class BeverageMachine {
    public String makeBeverage(BeverageType beverageType){
        switch (beverageType){

            case Latte:
                return "Enjoy your hot Latte with creamy milk!";
            case Tea:
                return "Enjoy your hot Masala Tea!";
            default:
                throw new RuntimeException("Unsupported beverage: " + beverageType);
        }
    }
}
