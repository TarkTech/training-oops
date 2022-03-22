package com.tarktech.demoOfPublicFieldsAndMethods.domain;

public class Rectangle {
    public int length;
    public int breath;

    public void area(){
        System.out.println("Area of the rectangle is " + length * breath);
    }
}
