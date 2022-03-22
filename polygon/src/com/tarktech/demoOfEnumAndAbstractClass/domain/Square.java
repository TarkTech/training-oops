package com.tarktech.demoOfEnumAndAbstractClass.domain;

public class Square extends Polygon {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    public void area(){
        System.out.println("Area of " + ShapeType.Square + " is " + side * side);
    }
}
