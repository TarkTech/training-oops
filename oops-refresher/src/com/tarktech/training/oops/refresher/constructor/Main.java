package com.tarktech.training.oops.refresher.constructor;

import com.tarktech.training.oops.refresher.constructor.domain.Rectangle;
import com.tarktech.training.oops.refresher.constructor.domain.Square;
import com.tarktech.training.oops.refresher.constructor.domain.Triangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);
        rectangle.area();

        Triangle triangle = new Triangle(10, 20);
        triangle.area();

        Square square = new Square(10);
        square.area();
    }
}
