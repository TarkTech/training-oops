package com.tarktech.training.beverage;

import com.tarktech.training.beverage.maker.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.tarktech.training.beverage.BeverageType.*;

public class Main {

    public static void main(String[] args) {
        Map<BeverageType, BeverageMaker> beverageMakerByType = new HashMap<>();
        beverageMakerByType.put(Latte, new LatteMaker());
        beverageMakerByType.put(Tea, new TeaMaker());
        beverageMakerByType.put(Cappuccino, new CappuccinoMaker());
        beverageMakerByType.put(Mocha, new MochaMaker());

        BeverageMachine beverageMachine = new BeverageMachine(beverageMakerByType);

        Scanner scanner = new Scanner(System.in);

        System.out.println("What beverage do you want (to refresh your morning)? Please enter Done, if you feel refreshed!");
        String userInput = scanner.nextLine();

        while(!userInput.equals("Done")){
            BeverageType beverageType = valueOf(userInput);

            String beverage = beverageMachine.makeBeverage(beverageType);
            System.out.println(beverage);

            int totalBeveragesDrunkByUser = beverageMachine.getBeveragesDrunkByUser(beverageType);
            System.out.println("You have drunk " + totalBeveragesDrunkByUser + " " + beverageType + " this morning!");

            int availableBeverageCount = beverageMachine.getAvailableBeverages(beverageType);
            System.out.println("There are " + availableBeverageCount + " more " + beverageType + " available.");

            System.out.println("You have drunk total " + beverageMachine.getTotalBeveragesDrunkByUser() + " beverages"
                    + " and there are " + beverageMachine.getTotalAvailableBeverages() + " more beverages available");

            System.out.println("\nWhat beverage do you want (to refresh your morning)? Please enter Done, if you feel refreshed!");
            userInput = scanner.nextLine();
        }

        System.out.println("Thank you! Visit again!");
    }
}
