package com.tarktech.training.beverage;

import com.tarktech.training.beverage.maker.*;

public class BeverageMachine {
    private BeverageMaker[] beverageMakers = new BeverageMaker[5];

    public BeverageMachine() {
        beverageMakers[0] = new TeaMaker();
        beverageMakers[1] = new LatteMaker();
        beverageMakers[2] = new CappuccinoMaker();
        beverageMakers[3] = new MochaMaker();
        beverageMakers[4] = new BlackTeaMaker();
    }

    public String dispenseBeverage(BeverageType beverageType) {
        int indexOfEnum = beverageType.ordinal();
        return beverageMakers[indexOfEnum].dispenseBeverage();
    }

    public int getDispensedBeverageCount(BeverageType beverageType) {
        int indexOfEnum = beverageType.ordinal();
        return beverageMakers[indexOfEnum].getDispensedBeverageCount();
    }

    public int getAvailableBeverageCount(BeverageType beverageType) {
        int indexOfEnum = beverageType.ordinal();
        return beverageMakers[indexOfEnum].getAvailableBeverageCount();
    }

    public BeverageType getMostFavoriteBeverage() {
        int mostFavoriteBeverageIndex = 0;
        int maxDispensedBeverages = 0;

        for(int i=0; i<beverageMakers.length; ++i){
            int currentDispenseCount = beverageMakers[i].getDispensedBeverageCount();
            if(currentDispenseCount >= maxDispensedBeverages){
                maxDispensedBeverages = currentDispenseCount;
                mostFavoriteBeverageIndex = i;
            }
        }
        BeverageType[] values = BeverageType.values();
        return values[mostFavoriteBeverageIndex];
    }
}
