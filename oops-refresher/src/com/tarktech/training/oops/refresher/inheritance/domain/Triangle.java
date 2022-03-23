package com.tarktech.training.oops.refresher.inheritance.domain;

import com.tarktech.training.oops.refresher.inheritance.domain.Polygon;

public class Triangle extends Polygon {
    private double height;
    private double base;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double calculateArea() {
        return (base * height * 0.5);
    }
}
