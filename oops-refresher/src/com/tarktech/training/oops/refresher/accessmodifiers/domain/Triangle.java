package com.tarktech.training.oops.refresher.accessmodifiers.domain;

public class Triangle {
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

    public double calculateArea(){
        return (height * base * 0.5);
    }
}
