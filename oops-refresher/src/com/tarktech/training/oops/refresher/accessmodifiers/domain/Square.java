package com.tarktech.training.oops.refresher.accessmodifiers.domain;

public class Square {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double calculateArea(){
        return (side * side);
    }
}
