package com.tarktech.demoOfPrivateFieldsAndParameterizedConstructor.domain;

public class Square {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    public void area() {
        System.out.println("Area of the square is " + side * side);
    }
}