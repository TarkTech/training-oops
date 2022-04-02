package com.tarktech.training.oops.refresher.accessmodifiers;

import com.tarktech.training.oops.refresher.accessmodifiers.domain.Rectangle;
import com.tarktech.training.oops.refresher.accessmodifiers.domain.Square;
import com.tarktech.training.oops.refresher.accessmodifiers.domain.Triangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.length = 100;
        rectangle.setLength(20);
        rectangle.setWidth(10);
        System.out.println("Area of rectangle is: " + rectangle.calculateArea());

        Triangle triangle = new Triangle();
        triangle.setBase(10);
        triangle.setHeight(20);
        System.out.println("Area of triangle is: " + triangle.calculateArea());

        Square square = new Square();
        square.setLength(10);
        System.out.println("Area of square is: " + square.calculateArea());
    }
}
