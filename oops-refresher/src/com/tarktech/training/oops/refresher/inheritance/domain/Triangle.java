package com.tarktech.training.oops.refresher.inheritance.domain;

import com.tarktech.training.oops.refresher.inheritance.domain.Polygon;

public class Triangle extends Polygon {
    private int height;
    private int base;

    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    public void area() {
        System.out.println("Area of triangle is " + base * height * 0.5);
    }
}
