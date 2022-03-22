package com.tarktech.demoOfPrivateFieldsAndParameterizedConstructor.domain;

public class Rectangle {
    private int length;
    private int breath;

    public Rectangle(int length, int breath) {
        this.length = length;
        this.breath = breath;
    }

    public void area() {
        System.out.println("Area of the rectangle is " + length * breath);
    }
}
