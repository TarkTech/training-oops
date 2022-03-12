package com.tarktech.training.beverage;

import com.tarktech.training.beverage.maker.*;

public class BeverageMachine {
    private BeverageMaker teaMaker;
    private BeverageMaker latteMaker;
    private BeverageMaker cappuccinoMaker;
    private BeverageMaker mochaMaker;

    public BeverageMachine() {
        teaMaker = new TeaMaker();
        latteMaker = new LatteMaker();
        cappuccinoMaker = new CappuccinoMaker();
        mochaMaker = new MochaMaker();
    }

    public String dispenseBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                return latteMaker.dispenseBeverage();
            case Tea:
                return teaMaker.dispenseBeverage();
           case Mocha:
               return mochaMaker.dispenseBeverage();
            case Cappuccino:
                return cappuccinoMaker.dispenseBeverage();
        }
        throw new RuntimeException("Sorry! We are not supporting " + beverageType + " yet!");
    }

    public int getDispensedBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                return latteMaker.getDispensedBeverageCount();
            case Tea:
                return teaMaker.getDispensedBeverageCount();
            case Mocha:
                return mochaMaker.getDispensedBeverageCount();
            case Cappuccino:
                return cappuccinoMaker.getDispensedBeverageCount();
        }
        throw new RuntimeException("Sorry! We are not supporting " + beverageType + " yet!");
    }

    public int getAvailableBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Latte:
                return latteMaker.getAvailableBeverageCount();
            case Tea:
                return teaMaker.getAvailableBeverageCount();
            case Mocha:
                return mochaMaker.getAvailableBeverageCount();
            case Cappuccino:
                return cappuccinoMaker.getAvailableBeverageCount();
        }
        throw new RuntimeException("Sorry! We are not supporting " + beverageType + " yet!");
    }

}
