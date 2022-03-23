package com.tarktech.training.oops.refresher.enums;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // TODO: Add enum examples like - DayOfWeek
        // Read string from console and print corresponding enum with ordinal number
        // Find DayOfWeek, i.e. print 3rd day of week
        // Print all DayOfWeeks

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day of week");
        String input = sc.nextLine();

        DayOfWeek day = DayOfWeek.valueOf(input);
        System.out.println(getDayNoString(day.ordinal()) + " day of week");
    }

    static String getDayNoString(int n){
        switch (n){
            case 0:
                return "1st";
            case 1:
                return "2nd";
            case 2:
                return "3rd";
            case 3:
            case 4:
            case 5:
            case 6:
                return (n+1 + "th");
            default:
                return "";
        }
    }
}
