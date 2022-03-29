package com.tarktech.training.oops.refresher.inheritance.domain;

public class Square extends Polygon {
    public double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double calculateArea(){
        return length * length;
    }
}
