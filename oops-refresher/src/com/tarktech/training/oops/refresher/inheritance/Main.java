package com.tarktech.training.oops.refresher.inheritance;

import com.tarktech.training.oops.refresher.inheritance.domain.Polygon;
import com.tarktech.training.oops.refresher.inheritance.domain.Rectangle;
import com.tarktech.training.oops.refresher.inheritance.domain.Triangle;
import com.tarktech.training.oops.refresher.inheritance.domain.Square;

public class Main {

    public static void main(String[] args) {
        Polygon rectangle = new Rectangle(10, 20);
        rectangle.area();

        Polygon triangle = new Triangle(10, 20);
        triangle.area();

        Polygon square = new Square(10);
        square.area();
    }
}
