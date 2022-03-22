package com.tarktech.demoOfEnumAndAbstractClass.domain;

public class Rectangle extends Polygon {
    private int length;
    private int breath;

    public Rectangle(int length, int breath) {
        this.length = length;
        this.breath = breath;
    }

    public void area() {
        System.out.println("Area of " + ShapeType.Rectangle + " is " + length * breath);
    }
}
