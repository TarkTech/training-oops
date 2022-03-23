package com.tarktech.training.oops.refresher.constructor.domain;

public class Triangle {
    private int height;
    private int base;

    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    public void area() {
        System.out.println("Area of the triangle is " + height * base * 0.5);
    }
}
