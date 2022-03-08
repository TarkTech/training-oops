package com.tarktech.training.beverage;

import com.tarktech.training.beverage.maker.*;

public class BeverageMachine {
    private BeverageMaker[] beverageMakers;

    public BeverageMachine() {
        beverageMakers = new BeverageMaker[]{
                new TeaMaker(),
                new LatteMaker(),
                new CappuccinoMaker(),
                new MochaMaker()
        };
    }

    public String makeBeverage(BeverageType beverageType) {
        BeverageMaker beverageMaker = findBeverageMaker(beverageType);
        return beverageMaker.makeBeverage();
    }

    public int getBeveragesDrunkByUser(BeverageType beverageType) {
        BeverageMaker beverageMaker = findBeverageMaker(beverageType);
        return beverageMaker.getBeveragesDrunkByUser();
    }

    public int getAvailableBeverages(BeverageType beverageType) {
        BeverageMaker beverageMaker = findBeverageMaker(beverageType);
        return beverageMaker.getAvailableBeverages();
    }

    public int getTotalBeveragesDrunkByUser() {
        int totalBeveragesDrunkByUser = 0;
        for (BeverageMaker beverageMaker : beverageMakers) {
            totalBeveragesDrunkByUser += beverageMaker.getBeveragesDrunkByUser();
        }
        return totalBeveragesDrunkByUser;
    }

    public int getTotalAvailableBeverages() {
        int totalAvailableBeverages = 0;
        for (BeverageMaker beverageMaker : beverageMakers) {
            totalAvailableBeverages += beverageMaker.getAvailableBeverages();
        }

        return totalAvailableBeverages;
    }

    private BeverageMaker findBeverageMaker(BeverageType beverageType) {
        for (BeverageMaker beverageMaker : beverageMakers) {
            if (beverageMaker.getBeverageType() == beverageType) {
                return beverageMaker;
            }
        }
        throw new RuntimeException("No beverage maker found for " + beverageType);
    }
}
