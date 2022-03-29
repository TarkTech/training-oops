package com.tarktech.training.oops.refresher.constructor.domain;

public class Square {
    public double length;

    public Square(double length) {
        this.length = length;
    }

    public double calculateArea() {
        return length * length;
    }
}
