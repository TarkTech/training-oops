package com.tarktech.training.oops.refresher.constructor;

import com.tarktech.training.oops.refresher.constructor.domain.Rectangle;
import com.tarktech.training.oops.refresher.constructor.domain.Square;
import com.tarktech.training.oops.refresher.constructor.domain.Triangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);
        System.out.println("Area of rectangle is: " + rectangle.calculateArea());

        Triangle triangle = new Triangle(10, 20);
        System.out.println("Area of triangle is: " + triangle.calculateArea());

        Square square = new Square(10);
        System.out.println("Area of square is: " + square.calculateArea());
    }
}
