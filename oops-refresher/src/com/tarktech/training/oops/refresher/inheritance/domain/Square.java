package com.tarktech.training.oops.refresher.inheritance.domain;

public class Square extends Polygon {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    public void area(){
        System.out.println("Area of square is " + side * side);
    }
}
