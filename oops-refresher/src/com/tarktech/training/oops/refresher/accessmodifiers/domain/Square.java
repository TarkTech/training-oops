package com.tarktech.training.oops.refresher.accessmodifiers.domain;

public class Square {
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double calculateArea(){
        return (length * length);
    }
}
