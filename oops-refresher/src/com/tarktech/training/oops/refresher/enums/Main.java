package com.tarktech.training.oops.refresher.enums;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day of week");
        String input = sc.nextLine();

        DayOfWeek day = DayOfWeek.valueOf(input);
        int dayOfWeek = day.ordinal() + 1;
        System.out.println("Day of week: " + dayOfWeek);
    }
}
