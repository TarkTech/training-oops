package com.tarktech.training.oops.refresher.constructor.domain;

public class Square {
    public double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }
}
