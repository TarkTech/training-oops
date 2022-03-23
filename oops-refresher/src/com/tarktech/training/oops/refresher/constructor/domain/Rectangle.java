package com.tarktech.training.oops.refresher.constructor.domain;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void area() {
        System.out.println("Area of the rectangle is " + length * width);
    }
}
