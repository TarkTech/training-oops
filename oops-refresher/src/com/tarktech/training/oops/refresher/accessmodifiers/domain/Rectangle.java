package com.tarktech.training.oops.refresher.accessmodifiers.domain;

public class Rectangle {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double breath) {
        this.width = breath;
    }

    public double calculateArea() {
        return length * width;
    }
}
