package com.tarktech.training.oops.refresher.accessmodifiers;

import com.tarktech.training.oops.refresher.accessmodifiers.domain.Rectangle;
import com.tarktech.training.oops.refresher.accessmodifiers.domain.Square;
import com.tarktech.training.oops.refresher.accessmodifiers.domain.Triangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        System.out.println("Area of rectangle is: " + rectangle.calculateArea());

        //TODO: Modify below examples - similar to above. Similarly, also modify the classes within constructor and inheritance packages.
        Triangle triangle = new Triangle();
        triangle.base = 10;
        triangle.height = 20;
        triangle.area();

        Square square = new Square();
        square.side = 10;
        square.area();
    }
}
