package com.tarktech.demoOfEnumAndAbstractClass.domain;

public class Triangle extends Polygon {
    private int height;
    private int base;

    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    public void area() {
        System.out.println("Area of " + ShapeType.Triangle + " is " + base * height * 0.5);
    }
}
