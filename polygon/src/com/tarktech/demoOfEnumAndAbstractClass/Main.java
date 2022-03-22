package com.tarktech.demoOfEnumAndAbstractClass;

import com.tarktech.demoOfEnumAndAbstractClass.domain.Polygon;
import com.tarktech.demoOfEnumAndAbstractClass.domain.Rectangle;
import com.tarktech.demoOfEnumAndAbstractClass.domain.Triangle;
import com.tarktech.demoOfEnumAndAbstractClass.domain.Square;

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
