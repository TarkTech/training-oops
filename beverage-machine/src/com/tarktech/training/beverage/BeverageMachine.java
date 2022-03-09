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

    public BeverageType getMostFavoriteBeverage() {
        BeverageType mostFavouriteBeverage = null;
        int mostFavouriteBeverageCount = 0;

        for (BeverageType beverageType: BeverageType.values()) {
            BeverageMaker beverageMaker = beverageMakerByType.get(beverageType);
            int beveragesDrunkByUser = beverageMaker.getBeveragesDrunkByUser();

            if(beveragesDrunkByUser >= mostFavouriteBeverageCount){
                mostFavouriteBeverageCount = beveragesDrunkByUser;
                mostFavouriteBeverage = beverageType;
            }
        }
        return mostFavouriteBeverage;
    }
}
