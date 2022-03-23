package com.tarktech.training.oops.refresher.inheritance.domain;

public class Square extends Polygon {
    public double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double calculateArea(){
        return side * side;
    }
}
