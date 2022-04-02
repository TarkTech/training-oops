package com.tarktech.training.beverage;


public class BeverageMachine {
    private TeaMaker teaMaker;
    private LatteMaker latteMaker;
    private CappuccinoMaker cappuccinoMaker;
    private MochaMaker mochaMaker;

    public BeverageMachine() {
        teaMaker = new TeaMaker();
        latteMaker = new LatteMaker();
        cappuccinoMaker = new CappuccinoMaker();
        mochaMaker = new MochaMaker();
    }

    public String dispenseBeverage(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                return teaMaker.dispenseBeverage();
            case Latte:
                return latteMaker.dispenseBeverage();
            case Cappuccino:
                return cappuccinoMaker.dispenseBeverage();
            case Mocha:
                return mochaMaker.dispenseBeverage();
        }
        throw new RuntimeException("Sorry! " + beverageType + " is not served!");
    }

    public int getDispensedBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                return teaMaker.getDispensedBeverageCount();
            case Latte:
                return latteMaker.getDispensedBeverageCount();
            case Cappuccino:
                return cappuccinoMaker.getDispensedBeverageCount();
            case Mocha:
                return mochaMaker.getDispensedBeverageCount();
        }
        throw new RuntimeException("Sorry! " + beverageType + " is not supported!");
    }

    public int getAvailableBeverageCount(BeverageType beverageType) {
        switch (beverageType) {
            case Tea:
                return teaMaker.getAvailableBeverageCount();
            case Latte:
                return latteMaker.getAvailableBeverageCount();
            case Cappuccino:
                return cappuccinoMaker.getAvailableBeverageCount();
            case Mocha:
                return mochaMaker.getAvailableBeverageCount();

        }
        throw new RuntimeException("Sorry! " + beverageType + " is not supported!");
    }
}
