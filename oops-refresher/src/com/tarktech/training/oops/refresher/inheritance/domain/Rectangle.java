package com.tarktech.training.oops.refresher.inheritance.domain;

public class Rectangle extends Polygon {
    private int length;
    private int breath;

    public Rectangle(int length, int breath) {
        this.length = length;
        this.breath = breath;
    }

    public void area() {
        System.out.println("Area of rectangle is " + length * breath);
    }
}
