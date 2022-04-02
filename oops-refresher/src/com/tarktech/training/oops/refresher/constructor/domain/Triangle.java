package com.tarktech.training.oops.refresher.constructor.domain;

public class Triangle extends Polygon {
    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double calculateArea() {
        return height * base * 0.5;
    }
}
