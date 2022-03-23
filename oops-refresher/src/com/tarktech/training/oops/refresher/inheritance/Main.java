package com.tarktech.training.oops.refresher.inheritance;

import com.tarktech.training.oops.refresher.inheritance.domain.Rectangle;
import com.tarktech.training.oops.refresher.inheritance.domain.Triangle;
import com.tarktech.training.oops.refresher.inheritance.domain.Square;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        System.out.println("Area of rectangle is: " + rectangle.calculateArea());

        Triangle triangle = new Triangle();
        triangle.setBase(10);
        triangle.setHeight(20);
        System.out.println("Area of triangle is: " + triangle.calculateArea());

        Square square = new Square();
        square.setSide(10);
        System.out.println("Area of square is: " + square.calculateArea());
    }
}
