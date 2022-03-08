package com.tarktech.training.beverage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BeverageMachine beverageMachine = new BeverageMachine();

        Scanner scanner = new Scanner(System.in);

        System.out.println("What beverage do you want (to refresh your morning)? Please enter Done, if you feel refreshed!");
        String userInput = scanner.nextLine();

        while(!userInput.equals("Done")){
            BeverageType beverageType = BeverageType.valueOf(userInput);

            String beverage = beverageMachine.makeBeverage(beverageType);

            System.out.println(beverage);

            System.out.println("What beverage do you want (to refresh your morning)? Please enter Done, if you feel refreshed!");
            userInput = scanner.nextLine();
        }

        System.out.println("Thank you! Visit again!");
    }
}
