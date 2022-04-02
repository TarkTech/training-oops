package com.tarktech.training.oops.refresher.constructor;

import com.tarktech.training.oops.refresher.constructor.domain.Polygon;
import com.tarktech.training.oops.refresher.constructor.domain.Rectangle;
import com.tarktech.training.oops.refresher.constructor.domain.Square;
import com.tarktech.training.oops.refresher.constructor.domain.Triangle;

public class Main {
    public static void main(String[] args) {
        Polygon rectangle = new Rectangle(10, 20);
        double area = rectangle.calculateArea();
        System.out.println("Area of rectangle is: " + area);

        Polygon triangle = new Triangle(10, 20);
        System.out.println("Area of triangle is: " + triangle.calculateArea());

        Polygon square = new Square(10);
        System.out.println("Area of square is: " + square.calculateArea());
    }
}
